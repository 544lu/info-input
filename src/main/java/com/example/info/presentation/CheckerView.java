package com.example.info.presentation;

import com.example.info.domain.Checker;

/**
 * Created by llc on 2019/9/9.
 * 参检人实体类
 */
public class CheckerView {

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
    private String orderDate;
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

    public Checker createChecker() {
        Checker checker = new Checker();
        checker.setAge(age);
        checker.setBirthday(birthday);
        checker.setChecked(checked);
        checker.setCheckerName(checkerName);
        checker.setRelationship(relationship);
        checker.setCheckerTel(checkerTel);
        checker.setExpense(expense);
        checker.setIdCard(idCard);
        checker.setMaritalSta(maritalSta);
        //对套餐级别进行转换
        String mealGraReal = transformMealGra(mealGra);
        checker.setMealGra(mealGraReal);

        checker.setMeal(meal);
        checker.setRemark(remark);
        checker.setReport(report);
        checker.setSex(sex);
        //对供应商进行转换
        String supplierReal = transformSupplier(supplier);
        checker.setSupplier(supplierReal);

        return checker;
    }

    public String transformMealGra(String current) {
        if (current.equals("8")) {
            return "【健凯】铂金级套餐";
        } else if (current.equals("9")) {
            return "【健凯】钻石一级套餐";
        } else if (current.equals("10")) {
            return "【健凯】钻石二级套餐";
        } else if (current.equals("11")) {
            return "【健凯】钻石三级套餐";
        } else if (current.equals("12")) {
            return "【爱康】铂金级套餐";
        } else if (current.equals("13")) {
            return "【爱康】钻石一级套餐";
        } else if (current.equals("14")) {
            return "【爱康】钻石二级套餐";
        } else if (current.equals("15")) {
            return "【爱康】钻石三级套餐";
        } else if (current.equals("16")) {
            return "铂金级客户";
        } else if (current.equals("17")) {
            return "钻石一级客户";
        } else if (current.equals("18")) {
            return "钻石二级客户";
        } else if (current.equals("19")) {
            return "钻石三级客户";
        } else if (current.equals("20")) {
            return "铂金级客户";
        } else if (current.equals("21")) {
            return "钻石一级客户";
        } else if (current.equals("22")) {
            return "钻石二级客户";
        } else if (current.equals("23")) {
            return "铂金级客户";
        } else if (current.equals("24")) {
            return "钻石一级客户";
        } else if (current.equals("25")) {
            return "钻石二级客户";
        } else if (current.equals("26")) {
            return "铂金级客户";
        } else if (current.equals("27")) {
            return "钻石一级客户";
        } else if (current.equals("28")) {
            return "钻石二级客户";
        } else if (current.equals("29")) {
            return "铂金级客户";
        } else if (current.equals("30")) {
            return "钻石一级客户";
        } else if (current.equals("31")) {
            return "钻石二级客户";
        }else if (current.equals("100")) {
            return "无";
        }else if (current.equals("103")) {
            return "无";
        }else {
            return current;
        }
    }

    public String transformSupplier(String current) {
        if (current.equals("1")) {
            return "健凯医疗";
        } else if (current.equals("2")) {
            return "爱康卓悦";
        } else if (current.equals("3")) {
            return "佛山市第一人民医院";
        } else if (current.equals("4")) {
            return "禅城区中心医院";
        } else if (current.equals("5")) {
            return "顺德人民医院";
        } else if (current.equals("6")) {
            return "广东同江医院";
        } else if (current.equals("7")) {
            return "南海区人民医院";
        }else if (current.equals("99")) {
            return "电话确认";
        }else if (current.equals("102")) {
            return "冯了性";
        }else {
            return current;
        }
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

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
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
