package com.example.info.service;

import com.example.info.domain.Checker;

import javax.servlet.http.HttpServletRequest;

public interface ModifyRecordService {
    //添加修改记录
    void addRecord(HttpServletRequest request, Checker old, Checker current);
    //添加一个新添加checker记录
    void addNewChecker(HttpServletRequest request, Checker current);
}
