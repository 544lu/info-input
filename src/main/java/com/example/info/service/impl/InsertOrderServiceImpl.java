package com.example.info.service.impl;

import com.example.info.domain.Checker;
import com.example.info.domain.Custemer;
import com.example.info.domain.Order;
import com.example.info.repository.CheckerRepository;
import com.example.info.repository.CustemerRepository;
import com.example.info.repository.OrderRepository;
import com.example.info.service.InsertOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by llc on 2019/9/9.
 */
@Service
public class InsertOrderServiceImpl implements InsertOrderService {

    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private CheckerRepository checkerRepo;
    @Autowired
    private CustemerRepository custemerRepo;

    @Override
    public boolean insertInfo(Order order) {
        orderRepo.insert(order);
        return true;
    }

    @Override
    public boolean insertChecker(Checker checker) {
        int i = checkerRepo.insert(checker);
        if (i == 1) {
            return true;
        } else return false;
    }

    @Override
    public boolean insertCustemer(Custemer custemer) {
        custemerRepo.insert(custemer);
        return true;
    }
}
