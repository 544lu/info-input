package com.example.info.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * Created by llc on 2019/9/9.
 * 参检人实体类
 */
@TableName("checker_tb")
public class Checker {

    //主键
    @TableId(type = IdType.AUTO)
    private Integer id;
    //供应商
    private String supplier;
    //参检人姓名
    private String checkerName;
    //与投保人关系
    private String relationship;
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
    //套餐等级
    private String mealGra;
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
    //外键
    private String custemerId;

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

    public String getCheckerName() {
        return checkerName;
    }

    public void setCheckerName(String checkerName) {
        this.checkerName = checkerName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
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

    public String getMealGra() {
        return mealGra;
    }

    public void setMealGra(String mealGra) {
        this.mealGra = mealGra;
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

    public String getCustemerId() {
        return custemerId;
    }

    public void setCustemerId(String custemerId) {
        this.custemerId = custemerId;
    }
}
