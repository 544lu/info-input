package com.example.info.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("custemer_tb")
public class Custemer {
    //主键
    @TableId(type = IdType.AUTO)
    private Integer id;
    //二级机构代码
    private String secondLevelCode;
    //三级机构名称
    private String thirdLevelName;
    //客户ID
    private String custemerId;
    //客户姓名
    private String custemerName;
    //客户VIP等级
    private String vipGra;
    //客户分级指数
    private String gradedIndex;
    //跨业务渠道类型
    private String channelType;
    //客户性别
    private String sex;
    //出生日期
    private String birthday;
    //客户联系电话
    private String telephone;
    //身份证号
    private String idCard;
    //家庭地址
    private String address;
    //业务类型
    private String businessType;
    //业务员直属组织名称
    private String salesmanOrg;
    //业务员代码
    private String salesmanCode;
    //业务员姓名
    private String salesmanName;
    //VIP客户服务人员组织名称
    private String serviceStaffOrg;
    //VIP客户服务人员代码
    private String serviceStaffCode;
    //VIP客户服务人员姓名
    private String serviceStaffName;
    //晋升到本层级时间
    private String promotionTime;
    //18年体检情况
    private String lastYearCheck;
    //体检状态
    private String checkSta;
    //回执情况
    private String receiptStatus;
    //第一次邀约
    private String firstInvite;
    //追踪情况
    private String trackingSituation;
    //二次邀约
    private String secondInvite;
    //追踪情况
    private String trackingSituationSec;
    //是否已预约
    private boolean booked;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSecondLevelCode() {
        return secondLevelCode;
    }

    public void setSecondLevelCode(String secondLevelCode) {
        this.secondLevelCode = secondLevelCode;
    }

    public String getThirdLevelName() {
        return thirdLevelName;
    }

    public void setThirdLevelName(String thirdLevelName) {
        this.thirdLevelName = thirdLevelName;
    }

    public String getCustemerId() {
        return custemerId;
    }

    public void setCustemerId(String custemerId) {
        this.custemerId = custemerId;
    }

    public String getCustemerName() {
        return custemerName;
    }

    public void setCustemerName(String custemerName) {
        this.custemerName = custemerName;
    }

    public String getVipGra() {
        return vipGra;
    }

    public void setVipGra(String vipGra) {
        this.vipGra = vipGra;
    }

    public String getGradedIndex() {
        return gradedIndex;
    }

    public void setGradedIndex(String gradedIndex) {
        this.gradedIndex = gradedIndex;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getSalesmanOrg() {
        return salesmanOrg;
    }

    public void setSalesmanOrg(String salesmanOrg) {
        this.salesmanOrg = salesmanOrg;
    }

    public String getSalesmanCode() {
        return salesmanCode;
    }

    public void setSalesmanCode(String salesmanCode) {
        this.salesmanCode = salesmanCode;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public String getServiceStaffOrg() {
        return serviceStaffOrg;
    }

    public void setServiceStaffOrg(String serviceStaffOrg) {
        this.serviceStaffOrg = serviceStaffOrg;
    }

    public String getServiceStaffCode() {
        return serviceStaffCode;
    }

    public void setServiceStaffCode(String serviceStaffCode) {
        this.serviceStaffCode = serviceStaffCode;
    }

    public String getServiceStaffName() {
        return serviceStaffName;
    }

    public void setServiceStaffName(String serviceStaffName) {
        this.serviceStaffName = serviceStaffName;
    }

    public String getPromotionTime() {
        return promotionTime;
    }

    public void setPromotionTime(String promotionTime) {
        this.promotionTime = promotionTime;
    }

    public String getLastYearCheck() {
        return lastYearCheck;
    }

    public void setLastYearCheck(String lastYearCheck) {
        this.lastYearCheck = lastYearCheck;
    }

    public String getCheckSta() {
        return checkSta;
    }

    public void setCheckSta(String checkSta) {
        this.checkSta = checkSta;
    }

    public String getReceiptStatus() {
        return receiptStatus;
    }

    public void setReceiptStatus(String receiptStatus) {
        this.receiptStatus = receiptStatus;
    }

    public String getFirstInvite() {
        return firstInvite;
    }

    public void setFirstInvite(String firstInvite) {
        this.firstInvite = firstInvite;
    }

    public String getTrackingSituation() {
        return trackingSituation;
    }

    public void setTrackingSituation(String trackingSituation) {
        this.trackingSituation = trackingSituation;
    }

    public String getSecondInvite() {
        return secondInvite;
    }

    public void setSecondInvite(String secondInvite) {
        this.secondInvite = secondInvite;
    }

    public String getTrackingSituationSec() {
        return trackingSituationSec;
    }

    public void setTrackingSituationSec(String trackingSituationSec) {
        this.trackingSituationSec = trackingSituationSec;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
