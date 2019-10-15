package com.example.info.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * Created by llc on 2019/9/9.
 */
public class CustemerOld {

    //主键
    @TableId(type = IdType.AUTO)
    private Integer id;
    //客户姓名
    private String custemerName;
    //客户ID
    private String custemerId;
    //客户联系电话
    private String telephone;
    //客户VIP等级
    private String vipGra;
    //是否转赠
    private boolean pass;
    //是否已预约
    private boolean booked;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public String getCustemerName() {
        return custemerName;
    }

    public void setCustemerName(String custemerName) {
        this.custemerName = custemerName;
    }

    public String getCustemerId() {
        return custemerId;
    }

    public void setCustemerId(String custemerId) {
        this.custemerId = custemerId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVipGra() {
        return vipGra;
    }

    public void setVipGra(String vipGra) {
        this.vipGra = vipGra;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
