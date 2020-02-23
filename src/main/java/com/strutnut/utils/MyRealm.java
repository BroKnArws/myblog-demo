package com.strutnut.utils;

import com.strutnut.pojo.User;
import com.strutnut.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MyRealm extends AuthorizingRealm {

    private final IUserService userService;

    @Autowired
    public MyRealm(IUserService userService) {
        this.userService = userService;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String email = (String) authenticationToken.getCredentials();
        SimpleAuthenticationInfo info = null;
        User user = login(email);
        if (user != null) {
            info = new SimpleAuthenticationInfo(
                    user.getEmail(),
                    user.getAccount(),
                    user.getUname());
        }
        return info;
    }

    private User login(String email) {
        return new User();
    }
}
