package com.example.info.presentation;

import com.example.info.domain.Checker;
import com.example.info.domain.Custemer;

import java.util.Date;

public class OrderView {
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

    //构造函数
    public OrderView(Custemer custemer, Checker checker){
        this.custemerId=custemer.getCustemerId();
        this.custemerName=custemer.getCustemerName();
        this.telephone=custemer.getTelephone();
        this.vipGra=custemer.getVipGra();
        this.pass=custemer.isPass();

        this.supplier=checker.getSupplier();
        this.checkerName=checker.getCheckerName();
        this.relationship=checker.getRelationship();
        this.age=checker.getAge();
        this.birthday=checker.getBirthday();
        this.checkerTel=checker.getCheckerTel();
        this.idCard=checker.getIdCard();
        this.maritalSta=checker.getMaritalSta();
        this.orderDate=checker.getOrderDate();
        this.meal=checker.getMeal();
        this.sex=checker.getSex();
        this.expense=checker.isExpense();
        this.report=checker.isReport();
        this.remark=checker.getRemark();
        this.checked=checker.isChecked();
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
