package com.example.info.controller.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by llc on 2019/9/9.
 * 用于注销登录
 */
@Controller
public class LogoutController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 注销登录
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        log.info("用户正在进行退出操作");
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "loginForm";
    }
}
