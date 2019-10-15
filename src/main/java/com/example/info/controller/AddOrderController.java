package com.example.info.controller;

import com.example.info.domain.Checker;
import com.example.info.domain.Custemer;
import com.example.info.domain.Order;
import com.example.info.presentation.CheckerView;
import com.example.info.service.impl.InsertOrderServiceImpl;
import com.example.info.service.impl.ModifyRecordServiceImpl;
import com.example.info.service.impl.UpdateOrderServiceImpl;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by llc on 2019/9/9.
 * 添加客户信息
 */
@Controller
public class AddOrderController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InsertOrderServiceImpl insertOrderService;
    @Autowired
    private UpdateOrderServiceImpl updateOrderService;
    @Autowired
    private ModifyRecordServiceImpl modifyRecordService;

    @RequestMapping(value = "insertOrder", method = RequestMethod.POST)
    public String insertOrder(Order order, Model model) {
        insertOrderService.insertInfo(order);
        model.addAttribute("result", "success");
        return "frame";
    }

    @RequestMapping(value = "insertChecker", method = RequestMethod.POST)
    @ResponseBody
    public String insertChecker(HttpServletRequest request, CheckerView checkerView, Model model) {
        String custemerId = request.getParameter("custemerId");
        DateTime dateTime = new DateTime(checkerView.getOrderDate());
        Date modifyDate=new Date();
        Checker checker = checkerView.createChecker();
        checker.setCustemerId(custemerId);
        checker.setOrderDate(dateTime.toDate());
        checker.setModifyDate(modifyDate);
        boolean result = true;
        try {
            insertOrderService.insertChecker(checker);
        } catch (Exception e) {
            result = false;
            log.error("添加预约信息时出错");
        }
        if (result != false) {
            //添加record
            try {
                modifyRecordService.addNewChecker(request, checker);
            } catch (Exception e) {
                log.error("添加Checker成功后无法正确添加record");
                e.printStackTrace();
            }
            //更新custemer_tb的cheked字段
            try {
                updateOrderService.updateCustemer("1", custemerId);
            } catch (Exception e) {
                result = false;
                log.error("更改客户预约状态时出错");
                e.printStackTrace();
            }
        }
        if (result == true) {
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "insertCustemer", method = RequestMethod.POST)
    public String insertOrder(Custemer custemer, Model model) {
        try {
            insertOrderService.insertCustemer(custemer);
        } catch (Exception e) {
            log.error("添加客户信息时出错");
            e.printStackTrace();
            model.addAttribute("result", "falure");
            return "frame";
        }
        model.addAttribute("result", "success");
        return "frame";
    }
}
