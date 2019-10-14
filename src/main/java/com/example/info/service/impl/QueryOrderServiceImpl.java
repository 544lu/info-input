package com.example.info.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.info.domain.*;
import com.example.info.presentation.form.QueryOrderParam;
import com.example.info.repository.*;
import com.example.info.service.queryOrderService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by llc on 2019/9/9.
 */
@Service
public class QueryOrderServiceImpl implements queryOrderService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private CustemerRepository custemerRepo;
    @Autowired
    private CheckerRepository checkerRepo;
    @Autowired
    private RecordRepository recordRepo;
    @Autowired
    private MealRepository mealRepo;


    @Override
    public List<Order> queryOrder(QueryOrderParam param) {
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        if (param == null) {
            throw new NullPointerException("查询参数为空");
        } else {
            if (StringUtils.isNotBlank(param.getId())) {
                wrapper.eq("custemer_id", param.getId());
            }
            if (StringUtils.isNotBlank(param.getName())) {
                wrapper.eq("custemer_name", param.getName());
            }
            if (StringUtils.isNotBlank(param.getTel())) {
                wrapper.eq("telephone", param.getTel());
            }
            if (StringUtils.isNotBlank(param.getSupplier())) {
                wrapper.eq("supplier", param.getSupplier());
            }
        }
        List<Order> orderList = orderRepo.selectList(wrapper);
        return orderList;
    }

    @Override
    public Order queryOrderById(Integer id) {
        Order order;
        if (id == null) {
            throw new NullPointerException("id为空");
        } else {
            order = orderRepo.selectById(id);
        }
        return order;
    }



    @Override
    public List<Order> queryOrderList() {
        List<Order> orderList = orderRepo.selectAll();
        return orderList;
    }

    @Override
    public List<Custemer> queryInfo(QueryOrderParam param) {
        QueryWrapper<Custemer> wrapper = new QueryWrapper<>();
        if (param == null) {
            throw new NullPointerException("查询参数为空");
        } else {
            if (StringUtils.isNotBlank(param.getId())) {
                wrapper.eq("custemer_id", param.getId());
            }
            if (StringUtils.isNotBlank(param.getName())) {
                wrapper.eq("custemer_name", param.getName());
            }
            if (StringUtils.isNotBlank(param.getTel())) {
                wrapper.eq("telephone", param.getTel());
            }
            if (StringUtils.isNotBlank(param.getSupplier())) {
                wrapper.eq("supplier", param.getSupplier());
            }
        }
        List<Custemer> custemerList = custemerRepo.selectList(wrapper);
        return custemerList;
    }

    @Override
    public Checker queryCheckerInfo(String custemerId) {
        QueryWrapper<Checker> wrapper = new QueryWrapper<>();
        if (custemerId == null) {
            throw new NullPointerException("查询参数为空");
        } else {
            wrapper.eq("custemer_id", custemerId);
        }
        Checker checker = checkerRepo.selectOne(wrapper);
        return checker;
    }

    @Override
    public List<Order> selectByDate(Date start, Date end) {
        List<Order> orderList=orderRepo.selectByDate(start,end);
        return orderList;
    }

    @Override
    public List<Checker> selectCheckerByDate(Date start, Date end) {
        List<Checker> checkerList=checkerRepo.selectByDate(start,end);
        return checkerList;
    }

    @Override
    public Custemer queryCustemerInfo(String custemerId) {
        QueryWrapper<Custemer> wrapper = new QueryWrapper<>();
        if (custemerId == null) {
            throw new NullPointerException("查询参数为空");
        } else {
            wrapper.eq("custemer_id", custemerId);
        }
        Custemer custemer = custemerRepo.selectOne(wrapper);
        return custemer;
    }

    @Override
    public Checker queryCheckerById(Integer id) {
        Checker checker=checkerRepo.selectById(id);
        return checker;
    }

    @Override
    public List<Record> queryRecordById(Integer checkerId) {
        QueryWrapper<Record> wrapper = new QueryWrapper<>();
        if (checkerId == null) {
            throw new NullPointerException("查询参数为空");
        } else {
            wrapper.eq("checker_id", checkerId);
        }
        List<Record> records=recordRepo.selectList(wrapper);
        return records;
    }

    @Override
    public List<Meal> queryByParentId(Integer id) {
        QueryWrapper<Meal> wrapper = new QueryWrapper<>();
        if (id == null) {
            throw new NullPointerException("查询参数为空");
        } else {
            wrapper.eq("parent_id", id);
        }
        List<Meal> data=mealRepo.selectList(wrapper);
        return data;
    }

}
