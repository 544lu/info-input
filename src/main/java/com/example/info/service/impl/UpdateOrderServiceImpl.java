package com.example.info.service.impl;

import com.example.info.domain.Checker;
import com.example.info.domain.Order;
import com.example.info.repository.CheckerRepository;
import com.example.info.repository.CustemerRepository;
import com.example.info.repository.OrderRepository;
import com.example.info.service.updateOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by llc on 2019/9/9.
 */
@Service
public class UpdateOrderServiceImpl implements updateOrderService {

    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private CustemerRepository custemerRepo;
    @Autowired
    private CheckerRepository checkerRepo;

    /**
     * 更新预约信息
     *
     * @param order
     * @return
     */
    @Override
    public boolean updateOrder(Order order) {
        orderRepo.updateById(order);
        return true;
    }

    @Override
    public boolean updateCustemer(String booked,String custemerId) {
        custemerRepo.updateCustemer(booked,custemerId);
        return true;
    }

    @Override
    public boolean updateChecker(Checker checker) {
        checkerRepo.updateById(checker);
        return true;
    }


}
