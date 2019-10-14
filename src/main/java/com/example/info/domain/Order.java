package com.example.info.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * Created by llc on 2019/9/11.
 * 体检预约实体
 */
@TableName("order_tb")
public class Order {

    //主键
    @TableId(type = IdType.AUTO)
    private Integer id;
    //供应商
    private String supplier;

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

    //参检人姓名
    private String checkerName;
    //参检人性别
    private String sex;
    //参检人身份证号码
    private String idCard;
    //参检人年龄
    private String age;
    //出生日期
    private String birthday;
    //参检人电话
    private String checkerTel;
    //婚姻状况
    private String maritalSta;
    //体检套餐
    private String meal;
    //预约日期
    private Date orderDate;
    //到检情况
    private boolean checked;
    //是否报销
    private boolean expense;
    //体检报告是否已出
    private boolean report;
    //备注
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
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

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public String getCheckerName() {
        return checkerName;
    }

    public void setCheckerName(String checkerName) {
        this.checkerName = checkerName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCheckerTel() {
        return checkerTel;
    }

    public void setCheckerTel(String checkerTel) {
        this.checkerTel = checkerTel;
    }

    public String getMaritalSta() {
        return maritalSta;
    }

    public void setMaritalSta(String maritalSta) {
        this.maritalSta = maritalSta;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isExpense() {
        return expense;
    }

    public void setExpense(boolean expense) {
        this.expense = expense;
    }

    public boolean isReport() {
        return report;
    }

    public void setReport(boolean report) {
        this.report = report;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
