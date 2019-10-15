package com.example.info.service;

import com.example.info.domain.*;
import com.example.info.presentation.form.ExportParam;
import com.example.info.presentation.form.QueryOrderParam;

import java.util.Date;
import java.util.List;

/**
 * Created by llc on 2019/9/9.
 */
public interface queryOrderService {
    //通过参数查询客户信息
    List<Order> queryOrder(QueryOrderParam param);
    //通过客户ID查询客户信息
    Order queryOrderById(Integer id);
    //查询所有预约信息
    List<Order> queryOrderList();
    //通过查询参数查询Custemer信息
    List<Custemer> queryInfo(QueryOrderParam param);
    //通过custemerId查询Checker
    Checker queryCheckerInfo(String custemerId);
    //根据日期范围查询Order
    List<Order> selectByDate(Date start, Date end);
    //根据日期范围查询Checker
    List<Checker> selectCheckerByDate(Date start, Date end);
    //通过custemerId查询Custemer
    Custemer queryCustemerInfo(String custemerId);
    //通过主键查询Checker
    Checker queryCheckerById(Integer id);
    //通过主键查询Record
    List<Record> queryRecordById(Integer id);
    //通过parentId查询Meal
    List<Meal> queryByParentId(Integer id);
    //通过查询参数查询Checker
    List<Checker> queryCheckerByParam(ExportParam param);
}
