package com.example.info.service;

import com.example.info.domain.Checker;
import com.example.info.domain.Order;

/**
 * Created by llc on 2019/9/9.
 */
public interface updateOrderService {
    //更新体检信息
    boolean updateOrder(Order order);
    //更新客户信息
    boolean updateCustemer(String booked,String custemerId);
    //更新体检信息
    boolean updateChecker(Checker checker);
}
