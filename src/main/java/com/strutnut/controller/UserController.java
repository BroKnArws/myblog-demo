package com.strutnut.controller;


import com.strutnut.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {


    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/login", produces = "text/html;charset=UTF-8")
    public String login(@RequestParam("useremail") String email,
                        @RequestParam("userpassword") String password) {
        return null;

    }
}
