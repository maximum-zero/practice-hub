package org.maximum0.controller;


import org.maximum0.annotation.Controller;
import org.maximum0.annotation.RequestMapping;
import org.maximum0.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HealthCheckController {

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String healthCheck(HttpServletRequest request, HttpServletResponse response) {
        return "ok";
    }
}
