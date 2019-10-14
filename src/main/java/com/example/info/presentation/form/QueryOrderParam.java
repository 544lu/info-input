package com.example.info.presentation.form;

/**
 * Created by llc on 2019/9/12.
 * 查询预约信息参数
 */
public class QueryOrderParam {
    //客户ID
    private String id;
    //客户姓名
    private String name;
    //客户电话号码
    private String tel;
    //供应商
    private String supplier;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
