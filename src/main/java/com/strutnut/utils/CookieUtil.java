package com.strutnut.utils;

import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
public class CookieUtil {

    public Cookie setCookie(Cookie[] cookies, String key, String value) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(key)) {
                cookie.setValue(value);
                return cookie;
            }
        }
        return null;
    }
}
