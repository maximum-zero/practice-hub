package org.maximum0.mvc.controller;

import org.maximum0.mvc.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserListController implements Controller{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("users", UserRepository.findAll());
        return "/user/list";
    }
}
