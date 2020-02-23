package com.strutnut.controller;


import com.strutnut.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
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


    @RequestMapping("/login")
    public String login(@RequestParam("useremail") String email,
                        @RequestParam("userpassword") String password) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                email,
//                 暂不加密
//                new Md5Hash(password, email + password, 1000).toString()
                password
        );
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            try {
                subject.login(usernamePasswordToken);
            } catch (UnknownAccountException e) {
                System.out.println("账号错误");
                return "AccountError";
            } catch (IncorrectCredentialsException e) {
                System.out.println("密码错误");
                return "PasswordError";
            } catch (AuthenticationException e) {
                System.out.println("认证失败");
                return "AuthenticationError";
            }
        }
        return "OK";

    }
}
