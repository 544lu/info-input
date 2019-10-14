package com.example.info.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.info.domain.Checker;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface CheckerRepository extends BaseMapper<Checker> {
    //查询一定时间范围内的Checker
    @Select("select * from checker_tb where order_date >= #{start} and order_date <= #{end}")
    List<Checker> selectByDate(Date start, Date end);
}
