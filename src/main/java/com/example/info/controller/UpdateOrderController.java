package com.example.info.controller;

import com.example.info.domain.Checker;
import com.example.info.presentation.CheckerView;
import com.example.info.service.impl.ModifyRecordServiceImpl;
import com.example.info.service.impl.QueryOrderServiceImpl;
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
 * 更新客户信息
 */
@Controller
public class UpdateOrderController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UpdateOrderServiceImpl updateOrderService;
    @Autowired
    private ModifyRecordServiceImpl modifyRecordService;
    @Autowired
    private QueryOrderServiceImpl queryOrderService;

    /**
     * 接收前端数据更新预约信息
     * @param checkerView*
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateOrder(CheckerView checkerView, HttpServletRequest request, Model model) {
        String orderDate=checkerView.getOrderDate();
        DateTime dateTime=new DateTime(orderDate);
        Date modifyDate=new Date();
        Checker checker=checkerView.createChecker();
        checker.setOrderDate(dateTime.toDate());
        checker.setModifyDate(modifyDate);
        if (checker == null) {
            throw new NullPointerException("请求参数为空");
        } else {
            String arg=request.getParameter("id");
            int id=Integer.parseInt(arg);
            checker.setId(id);
            //查询更新前的Checker
            Checker old=queryOrderService.queryCheckerById(id);
            //进行Checker更新
            boolean result = updateOrderService.updateChecker(checker);
            if (result == true) {
                //添加修改记录
                try {
                    modifyRecordService.addRecord(request, old, checker);
                }catch (Exception e){
                    log.error("在添加修改记录时出错");
                    e.printStackTrace();
                }
                return "success";
            } else {
                return "error";
            }
        }
    }
}
