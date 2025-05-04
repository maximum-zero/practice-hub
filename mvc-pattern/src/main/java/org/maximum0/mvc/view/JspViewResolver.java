package org.maximum0.mvc.view;

public class JspViewResolver implements ViewResolver {
    public static final String DEFAULT_REDIRECT_PREFIX = "redirect:";
    public static final String DEFAULT_JSP_SUFFIX = ".jsp";

    @Override
    public View resolveView(String viewName) {
        if (viewName.startsWith(DEFAULT_REDIRECT_PREFIX)) {
            return new RedirectView(viewName);
        }
        return new JspView(viewName + DEFAULT_JSP_SUFFIX);
    }
}
