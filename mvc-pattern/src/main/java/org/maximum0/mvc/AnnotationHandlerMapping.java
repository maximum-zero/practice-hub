package org.maximum0.mvc;

import org.maximum0.mvc.annotation.Controller;
import org.maximum0.mvc.annotation.RequestMapping;
import org.maximum0.mvc.controller.RequestMethod;
import org.reflections.Reflections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationHandlerMapping implements HandlerMapping {
    private final Object[] basePackage;
    private Map<HandlerKey, AnnotationHandler> handlers = new HashMap<>();

    public AnnotationHandlerMapping(Object... basePackage) {
        this.basePackage = basePackage;
    }

    public void init() {
        Reflections reflections = new Reflections(basePackage);
        Set<Class<?>> clazzWithControllerAnnotation = reflections.getTypesAnnotatedWith(Controller.class);

        clazzWithControllerAnnotation.forEach(clazz ->
            Arrays.stream(clazz.getDeclaredMethods()).forEach(declaredMethod -> {
                RequestMapping requestMapping = declaredMethod.getDeclaredAnnotation(RequestMapping.class);

                Arrays.stream(getRequestMethods(requestMapping))
                    .forEach(requestMethod -> handlers.put(
                        new HandlerKey(requestMethod, requestMapping.value()), new AnnotationHandler(clazz, declaredMethod)
                    ));
            })
        );
    }

    private RequestMethod[] getRequestMethods(RequestMapping requestMapping) {
        return requestMapping.method();
    }


    @Override
    public Object findHandler(HandlerKey handlerKey) {
        return handlers.get(handlerKey);
    }
}
