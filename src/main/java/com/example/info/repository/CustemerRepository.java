package com.example.info.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.info.domain.Custemer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CustemerRepository extends BaseMapper<Custemer> {
    @Select("update custemer_tb set booked = #{booked} where custemer_id = #{custemerId} ")
    Integer updateCustemer(@Param("booked") String booked, @Param("custemerId") String custemerId);
}
