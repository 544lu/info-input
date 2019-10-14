package com.example.info.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.info.domain.Order;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * Created by llc on 2019/9/11.
 */
public interface OrderRepository extends BaseMapper<Order> {
    //查询所有预约信息
    @Select("select * from order_tb")
    List<Order> selectAll();
    //查询一定时间范围内的order
    @Select("select * from order_tb where order_date >= #{start} and order_date <= #{end}")
    List<Order> selectByDate(Date start, Date end);
}
