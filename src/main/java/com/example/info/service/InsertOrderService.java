package com.example.info.service;

import com.example.info.domain.Checker;
import com.example.info.domain.Custemer;
import com.example.info.domain.Order;

/**
 * Created by llc on 2019/9/9.
 */
public interface InsertOrderService {
    //添加客户信息
    boolean insertInfo(Order order);
    //添加预约信息
    boolean insertChecker(Checker checker);
    //添加Custemer
    boolean insertCustemer(Custemer custemer);
}
