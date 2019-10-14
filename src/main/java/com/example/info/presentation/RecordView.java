package com.example.info.presentation;

public class RecordView {
    private String modifier;
    private String modifyTime;
    private String columnName;
    private String beforeVal;
    private String afterVal;

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
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
