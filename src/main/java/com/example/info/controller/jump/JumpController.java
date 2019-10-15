package com.example.info.controller.jump;

import com.example.info.domain.Checker;
import com.example.info.service.impl.QueryOrderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by llc on 2019/9/11.
 * 页面跳转
 */
@Controller
public class JumpController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QueryOrderServiceImpl queryOrderService;

    //跳转到frame.html
    @RequestMapping(value = "frame")
    public String jumpToFrame() {
        return "frame";
    }

    //跳转到query.html
    @RequestMapping(value = "query")
    public String jumpToQuery() {
        return "query";
    }

    /**
     * 跳转到modify-order.html
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "modify-order")
    public String jumpToModify(HttpServletRequest request, Model model) {
        String custemerId = request.getParameter("id");
        String action = request.getParameter("action");
        if (custemerId == null) {
            throw new NullPointerException("请求参数为空");
        } else {
            Checker checker = null;
            try {
                checker = queryOrderService.queryCheckerInfo(custemerId);
            } catch (Exception e) {
                log.error("查询预约信息时出错");
                e.printStackTrace();
            }
            if (checker != null) {
                if(action!=null&&action.equals("modify")){
                    model.addAttribute("checker", checker);
                    return "present-info";
                }else {
                    model.addAttribute("checker", checker);
                    return "modify-order";
                }
            } else {
                model.addAttribute("custemerId", custemerId);
                return "add-checker";
            }
        }
    }

    /**
     * 跳转到添加预约页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "add-checker")
    public String jumpToAdd(HttpServletRequest request, Model model) {
        String custemerId = request.getParameter("custemerId");
        model.addAttribute("custemerId", custemerId);
        return "add-checker";
    }

    @RequestMapping(value = "jumpToDate",method = RequestMethod.GET)
    public String jumpToDate() {
        return "export-checker";
    }
}
