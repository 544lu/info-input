package com.example.info.controller;

import com.example.info.domain.Custemer;
import com.example.info.domain.Meal;
import com.example.info.domain.Order;
import com.example.info.domain.Record;
import com.example.info.presentation.MealView;
import com.example.info.presentation.RecordView;
import com.example.info.presentation.form.QueryOrderParam;
import com.example.info.service.impl.QueryOrderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by llc on 2019/9/9.
 * 用于查询客户信息
 */
@Controller
public class QueryOrderController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    QueryOrderServiceImpl queryOrderService;

    /**
     * 根据查询参数查新预约信息
     *
     * @param param
     * @param model
     * @return
     */
    @RequestMapping(value = "/queryOrder", method = RequestMethod.POST)
    public String queryOrder(QueryOrderParam param, Model model) {
        List<Order> orderList = queryOrderService.queryOrder(param);
        if (orderList.size() != 0) {
            model.addAttribute("orderList", orderList);
        } else {
            model.addAttribute("result", "查询无数据");
        }
        return "query";
    }

    /**
     * 查询Custemer
     *
     * @param param
     * @param model
     * @return
     */
    @RequestMapping(value = "/queryInfo", method = RequestMethod.POST)
    public String queryInfo(QueryOrderParam param, ModelMap model) {
        List<Custemer> custemerList = null;
        try {
            custemerList = queryOrderService.queryInfo(param);
        } catch (Exception e) {
            log.error("查询客户信息时出错");
        }
        if (custemerList.size() != 0) {
            model.addAttribute("custemerList", custemerList);
        } else {
            model.addAttribute("result", "查询无数据");
        }
        return "query";
    }

    /**
     * 查询修改历史记录
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "modifyRecord", method = RequestMethod.GET)
    public String modifyRecord(HttpServletRequest request, Model model) {
        String str = request.getParameter("checkerId");
        int checkerId = Integer.parseInt(str);
        List<Record> records = null;
        try {
            records = queryOrderService.queryRecordById(checkerId);
        } catch (Exception e) {
            log.error("在查询修改历史时出错");
            e.printStackTrace();
        }
        List<RecordView> views = new ArrayList<>();
        for (Record record : records) {
            RecordView view = createRecordView(record);
            views.add(view);
        }
        model.addAttribute("views", views);
        return "modify-record";
    }

    public RecordView createRecordView(Record record) {
        RecordView view = new RecordView();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        view.setModifyTime(dateFormat.format(record.getModifyTime()));
        view.setModifier(record.getModifier());
        String columnName = record.getColumnName();
        if (columnName.equals("new addition")) {
            view.setColumnName("新建");
        }
        if (columnName.equals("supplier")) {
            view.setColumnName("医院");
            view.setBeforeVal(record.getBeforeVal());
            view.setAfterVal(record.getAfterVal());
        }
        if (columnName.equals("checkerName")) {
            view.setColumnName("体检人");
            view.setBeforeVal(record.getBeforeVal());
            view.setAfterVal(record.getAfterVal());
        }
        if (columnName.equals("relationship")) {
            view.setColumnName("与投保人关系");
            view.setBeforeVal(record.getBeforeVal());
            view.setAfterVal(record.getAfterVal());
        }
        if (columnName.equals("birthday")) {
            view.setColumnName("出生日期");
            view.setBeforeVal(record.getBeforeVal());
            view.setAfterVal(record.getAfterVal());
        }
        if (columnName.equals("age")) {
            view.setColumnName("年龄");
            view.setBeforeVal(record.getBeforeVal());
            view.setAfterVal(record.getAfterVal());
        }
        if (columnName.equals("checkerTel")) {
            view.setColumnName("参检人电话");
            view.setBeforeVal(record.getBeforeVal());
            view.setAfterVal(record.getAfterVal());
        }
        if (columnName.equals("idCard")) {
            view.setColumnName("身份证号码");
            view.setBeforeVal(record.getBeforeVal());
            view.setAfterVal(record.getAfterVal());
        }
        if (columnName.equals("sex")) {
            view.setColumnName("性别");
            view.setBeforeVal(record.getBeforeVal());
            view.setAfterVal(record.getAfterVal());
        }
        if (columnName.equals("maritalSta")) {
            view.setColumnName("婚姻状况");
            view.setBeforeVal(record.getBeforeVal());
            view.setAfterVal(record.getAfterVal());
        }
        if (columnName.equals("mealGra")) {
            view.setColumnName("套餐等级");
            view.setBeforeVal(record.getBeforeVal());
            view.setAfterVal(record.getAfterVal());
        }
        if (columnName.equals("meal")) {
            view.setColumnName("体检套餐");
            view.setBeforeVal(record.getBeforeVal());
            view.setAfterVal(record.getAfterVal());
        }
        if (columnName.equals("orderDate")) {
            view.setColumnName("预约日期");
            view.setBeforeVal(record.getBeforeVal());
            view.setAfterVal(record.getAfterVal());
        }
        if (columnName.equals("checked")) {
            view.setColumnName("到检情况");
            if (record.getBeforeVal().equals("false")) {
                view.setBeforeVal("未检");
                view.setAfterVal("已检");
            } else {
                view.setBeforeVal("已检");
                view.setAfterVal("未检");
            }
        }
        if (columnName.equals("expense")) {
            view.setColumnName("报销情况");
            if (record.getBeforeVal().equals("false")) {
                view.setBeforeVal("已报销");
                view.setAfterVal("未报销");
            } else {
                view.setBeforeVal("已报销");
                view.setAfterVal("未报销");
            }
        }
        if (columnName.equals("report")) {
            view.setColumnName("体检报告");
            if (record.getBeforeVal().equals("false")) {
                view.setBeforeVal("未出");
                view.setAfterVal("已出");
            } else {
                view.setBeforeVal("已出");
                view.setAfterVal("未出");
            }
        }
        if (columnName.equals("remark")) {
            view.setColumnName("备注");
            view.setBeforeVal(record.getBeforeVal());
            view.setAfterVal(record.getAfterVal());
        }
        return view;
    }

    @RequestMapping(value = "queryByParentId", method = RequestMethod.POST)
    @ResponseBody
    public MealView queryByParentId(HttpServletRequest request) {
        String str = request.getParameter("id");
        Integer id = Integer.parseInt(str);
        List<Meal> data = new ArrayList<>();
        boolean success = true;
        try {
            data = queryOrderService.queryByParentId(id);
        } catch (Exception e) {
            log.error("查询体检套餐时出错");
            e.printStackTrace();
            success = false;
        }
        MealView view = new MealView(success, data);
        return view;
    }
}
