package com.strutnut.controller;


import com.alibaba.fastjson.JSON;
import com.strutnut.model.entity.RespHeader;
import com.strutnut.model.pojo.User;
import com.strutnut.service.IUserService;
import com.strutnut.utils.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String login(User user) {
        if (!FormatUtil.hasStringNull(user.getEmail(), user.getPassword())) {
            String token = userService.login(user);
            RespHeader respHeader = new RespHeader();
            respHeader.setToken(token);
            respHeader.setStatus(200);
            return JSON.toJSONString(respHeader);
        }
        //暂用
        return JSON.toJSONString("ParamHasNull");
    }

    @RequestMapping("/logincheck")
    public String logincheck() {
        return JSON.toJSONString("logincheck...");
    }

    @RequestMapping("/test")
    public String userForTest() {
        System.out.println("hello world");
        return JSON.toJSONString(new User());
    }
}
