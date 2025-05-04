package org.maximum0.mvc;

import org.maximum0.mvc.controller.RequestMethod;
import org.maximum0.mvc.view.JspViewResolver;
import org.maximum0.mvc.view.View;
import org.maximum0.mvc.view.ViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);
    private List<HandlerMapping> handlerMapping;
    private List<HandlerAdapter> handlerAdapters;
    private List<ViewResolver> viewResolvers;

    @Override
    public void init() throws ServletException {
        RequestMappingHandlerMapping rmhm = new RequestMappingHandlerMapping();
        rmhm.init();

        AnnotationHandlerMapping ahm = new AnnotationHandlerMapping("org.maximum0");
        ahm.init();

        handlerMapping = List.of(rmhm, ahm);
        handlerAdapters = List.of(new SimpleControllerHandlerAdapter(), new AnnotationHandlerAdapter());
        viewResolvers = Collections.singletonList(new JspViewResolver());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("[DispatcherServlet] service started.");

        String requestURI = request.getRequestURI();
        RequestMethod requestMethod = RequestMethod.valueOf(request.getMethod());

        try {
            Object handler = handlerMapping.stream()
                .filter(hm -> hm.findHandler(new HandlerKey(requestMethod, requestURI)) != null)
                .map(hm -> hm.findHandler(new HandlerKey(requestMethod, requestURI)))
                .findFirst()
                .orElseThrow(() -> new ServletException("No handler for [" + requestMethod + ", " + requestURI + "]"));

            HandlerAdapter handlerAdapter = handlerAdapters.stream()
                .filter(adapter -> adapter.supports(handler))
                .findFirst()
                .orElseThrow(() -> new ServletException("No adapter for handler [" + handler + "]"));

            ModelAndView modelAndView = handlerAdapter.handle(request, response, handler);

            for (ViewResolver viewResolver: viewResolvers) {
                View view = viewResolver.resolveView(modelAndView.getViewName());
                view.render(modelAndView.getModel(), request, response);
            }

        } catch (Exception e) {
            log.error("exception occurred: [{}]", e.getMessage());
        }
    }
}
