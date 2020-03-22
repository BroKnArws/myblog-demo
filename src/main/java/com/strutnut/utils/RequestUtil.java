package com.strutnut.utils;


import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
public class RequestUtil {


    /**
     * 用以获取cookie值
     * @param request 请求
     * @param key 需要获取cookie的键
     * @return cookie值
     */
    public String getCookie(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if (cookieName.equals(key)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
