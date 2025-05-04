package org.maximum0.mvc.controller;

import org.maximum0.mvc.annotation.Controller;
import org.maximum0.mvc.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HealthCheckController {

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "health";
    }
}
