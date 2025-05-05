package org.maximum0.controller;

import org.maximum0.annotation.Controller;
import org.maximum0.annotation.Inject;
import org.maximum0.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }
}
