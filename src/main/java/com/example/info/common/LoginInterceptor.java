package com.example.info.common;

import com.example.info.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by llc on 2019/9/8.
 * 访问拦截
 */
public class LoginInterceptor implements HandlerInterceptor {
    Logger log = LoggerFactory.getLogger(this.getClass());

    public String[] IGNORE_URI = {"/loginForm", "/login"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        for (String url : IGNORE_URI) {
            if (!uri.isEmpty() && uri.contains(url)) {
                return true;
            }
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //判断用户是否已登陆
        if (user == null) {
            log.info("用户未登录！");
            request.getRequestDispatcher("/loginForm").forward(request, response);
            return false;
        } else {
            log.info("用户已登录！");
            return true;
        }
    }
}
