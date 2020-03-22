package com.strutnut.interceptor;


import com.strutnut.model.pojo.User;
import com.strutnut.service.IUserService;
import com.strutnut.utils.CookieUtil;
import com.strutnut.utils.RequestUtil;
import com.strutnut.utils.TokenUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@Component
public class JwtTokenInterceptor implements HandlerInterceptor {


    private Logger logger = LogManager.getLogger(JwtTokenInterceptor.class);

    @Autowired
    private RequestUtil requestUtil;

    @Autowired
    private TokenUtils tokenUtil;

    @Autowired
    private IUserService userService;

    @Autowired
    private CookieUtil cookieUtil;

    private static final String TOKEN_NAME = "token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info(this.getClass().getName() + " is worked ... ");
        checkPermission(request, response);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 检查登录状态
     */
    private void checkPermission(HttpServletRequest request, HttpServletResponse response) {
        logger.info("Check permisson now ...");
        String tokenvalue = requestUtil.getCookie(request, TOKEN_NAME);
        //null for 最近没登录/token过期/校验失败
        if (tokenvalue != null) {
            String userEmail = tokenUtil.getEmailByToken(tokenvalue);
            //null for 从未登录过/token无法解密
            if (userEmail != null) {
                //可以改成更新登录状态而非登录，Redis ?
                User user = userService.getUserByEmail(userEmail);
                Cookie cookie = cookieUtil.setCookie(request.getCookies(), "token", tokenUtil.generateToken(user));
                response.addCookie(cookie);
            }
        }
    }
}
