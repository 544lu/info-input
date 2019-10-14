package com.example.info.controller;

import com.example.info.config.ExcelUtil;
import com.example.info.domain.Checker;
import com.example.info.domain.Custemer;
import com.example.info.presentation.OrderView;
import com.example.info.service.impl.QueryOrderServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExportExcelController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QueryOrderServiceImpl queryOrderService;

    /**
     * 导出预约信息
     *
     * @param response
     * @return
     */

    /*
    @RequestMapping(value = "/exportExcel", method = RequestMethod.POST)
    @ResponseBody
    public String exportExcel(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, HttpServletResponse response) {
        DateTime start = new DateTime(startDate);
        DateTime end = new DateTime(endDate);
        ExcelUtil excelUtil = new ExcelUtil();
        List<Order> orderList = null;
        try {
            orderList = queryOrderService.selectByDate(start.toDate(), end.toDate());
        } catch (Exception e) {
            log.error("查询日期范围内数据时出错");
        }
        if (orderList.size() != 0) {
            excelUtil.exportExcel(orderList, response);
            return "success";
        } else {
            return "error";
        }
    }
    */

    /**
     * 导出预约信息
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
    public String exportExcel(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, HttpServletResponse response) {
        if (StringUtils.isBlank(startDate) && StringUtils.isBlank(endDate)) {
            return "export-checker";
        }
        DateTime start = new DateTime(startDate);
        DateTime end = new DateTime(endDate);
        ExcelUtil excelUtil = new ExcelUtil();
        List<Checker> checkerList = null;
        try {
            checkerList = queryOrderService.selectCheckerByDate(start.toDate(), end.toDate());
        } catch (Exception e) {
            log.error("查询日期范围内数据时出错");
        }
        List<OrderView> listView = new ArrayList<>();
        for (Checker checker : checkerList) {
            Custemer custemer = queryOrderService.queryCustemerInfo(checker.getCustemerId());
            OrderView view = new OrderView(custemer, checker);
            listView.add(view);
        }
        if (listView.size() >= 0) {
            excelUtil.exportExcel(listView, response);
            return "success";
        } else {
            return "error";
        }
    }
}
