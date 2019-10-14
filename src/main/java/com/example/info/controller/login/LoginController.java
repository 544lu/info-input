package com.example.info.controller.login;

import com.example.info.domain.User;
import com.example.info.service.impl.LoginServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by llc
 * on 2019/9/8.
 */
@Controller
public class LoginController {

    /**
     * 登录页面
     *
     * @return
     */
    private org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoginServiceImpl loginService;

    @RequestMapping("loginForm")
    public String loginForm() {
        return "login";
    }

    @RequestMapping("login")
    public String login(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpServletRequest request,Model model) {
        log.info("正在进行登陆...");
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        boolean result = loginService.selectByNameAndPassword(user);
        if (result == true) {
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
            return "query";
        } else {
            model.addAttribute("result","falure");
            return "login";
        }
    }

}
