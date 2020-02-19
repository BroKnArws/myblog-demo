package com.strutnut.controller;


import com.strutnut.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public String hello(@RequestParam("username") String userName,@RequestParam("userpassword") String account)
    {
        String temp="admin";
        if(temp.equals(userName)&&temp.equals(account))
        {
            return "1";
        }
        else
        {
            return "0";
        }
    }

    @RequestMapping("/register")
    public void registerUser(@RequestParam("username") String uname,@RequestParam("age") String age,
                             @RequestParam("sex") String sex,@RequestParam("account") String account,
                             @RequestParam("email") String email){
        Map<String,String> userMap=new HashMap<>();
        userMap.put(uname,uname);
        userMap.put(age,age);
        userMap.put(sex,sex);
        userMap.put(account,account);
        userMap.put(email,email);
        userService.addUser(userMap);
    }
}
