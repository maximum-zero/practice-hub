package org.maximum0.controller;


import org.maximum0.annotation.Controller;
import org.maximum0.annotation.RequestMapping;
import org.maximum0.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpServletRequest request, HttpServletResponse response) {
        return "home";
    }
}
