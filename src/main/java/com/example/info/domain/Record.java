package com.example.info.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * 用于记录每次对Checker的修改
 */

@TableName("record_tb")
public class Record {
    //主键
    @TableId(type = IdType.AUTO)
    private Integer id;
    //修改人
    private String modifier;
    //修改时间
    private Date modifyTime;
    //修改的checker_tb记录主键ID
    private Integer checkerId;
    //修改的列名称
    private String columnName;
    //原值
    private String beforeVal;
    //修改后的值
    private String afterVal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getCheckerId() {
        return checkerId;
    }

    public void setCheckerId(Integer checkerId) {
        this.checkerId = checkerId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getBeforeVal() {
        return beforeVal;
    }

    public void setBeforeVal(String beforeVal) {
        this.beforeVal = beforeVal;
    }

    public String getAfterVal() {
        return afterVal;
    }

    public void setAfterVal(String afterVal) {
        this.afterVal = afterVal;
    }
}
