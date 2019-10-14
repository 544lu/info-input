package com.example.info.service.impl;

import com.example.info.domain.Checker;
import com.example.info.domain.Record;
import com.example.info.domain.User;
import com.example.info.repository.RecordRepository;
import com.example.info.service.ModifyRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class ModifyRecordServiceImpl implements ModifyRecordService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RecordRepository recordRepo;

    @Override
    public void addRecord(HttpServletRequest request, Checker old, Checker current) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            log.error("未登录");
            return;
        }
        String userName = user.getUserName();
        Date modifyTime = new Date();

        ArrayList<String> columns = new ArrayList<>();
        ArrayList<Object> beforeVals = new ArrayList<>();
        ArrayList<Object> afterVals = new ArrayList<>();

        if (!old.getSupplier().equals(current.getSupplier())) {
            columns.add("supplier");
            beforeVals.add(old.getSupplier());
            afterVals.add(current.getSupplier());
        }
        if (!old.getCheckerName().equals(current.getCheckerName())) {
            columns.add("checkerName");
            beforeVals.add(old.getCheckerName());
            afterVals.add(current.getCheckerName());
        }
        if (!old.getRelationship().equals(current.getRelationship())) {
            columns.add("relationship");
            beforeVals.add(old.getRelationship());
            afterVals.add(current.getRelationship());
        }
        if (!old.getBirthday().equals(current.getBirthday())) {
            columns.add("birthday");
            beforeVals.add(old.getBirthday());
            afterVals.add(current.getBirthday());
        }
        if (!old.getAge().equals(current.getAge())) {
            columns.add("age");
            beforeVals.add(old.getAge());
            afterVals.add(current.getAge());
        }
        if (!old.getCheckerTel().equals(current.getCheckerTel())) {
            columns.add("checkerTel");
            beforeVals.add(old.getCheckerTel());
            afterVals.add(current.getCheckerTel());
        }
        if (!old.getIdCard().equals(current.getIdCard())) {
            columns.add("idCard");
            beforeVals.add(old.getIdCard());
            afterVals.add(current.getIdCard());
        }
        if (!old.getSex().equals(current.getSex())) {
            columns.add("sex");
            beforeVals.add(old.getSex());
            afterVals.add(current.getSex());
        }
        if (!old.getOrderDate().equals(current.getOrderDate())) {
            columns.add("orderDate");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            beforeVals.add(dateFormat.format(old.getOrderDate()));
            afterVals.add(dateFormat.format(current.getOrderDate()));
        }
        if (!old.getMealGra().equals(current.getMealGra())) {
            columns.add("mealGra");
            beforeVals.add(old.getMealGra());
            afterVals.add(current.getMealGra());
        }
        if (!old.getMeal().equals(current.getMeal())) {
            columns.add("meal");
            beforeVals.add(old.getMeal());
            afterVals.add(current.getMeal());
        }
        if (!old.getMaritalSta().equals(current.getMaritalSta())) {
            columns.add("maritalSta");
            beforeVals.add(old.getMaritalSta());
            afterVals.add(current.getMaritalSta());
        }
        if (!old.isChecked() == (current.isChecked())) {
            columns.add("checked");
            beforeVals.add(old.isChecked()?"true":"false");
            afterVals.add(current.isChecked()?"true":"false");
        }
        if (!old.isExpense() == (current.isExpense())) {
            columns.add("expense");
            beforeVals.add(old.isExpense()?"true":"false");
            afterVals.add(current.isExpense()?"true":"false");
        }
        if (!old.isReport() == (current.isReport())) {
            columns.add("report");
            beforeVals.add(old.isReport()?"true":"false");
            afterVals.add(current.isReport()?"true":"false");
        }
        if (!old.getRemark().equals(current.getRemark())) {
            columns.add("remark");
            beforeVals.add(old.getRemark());
            afterVals.add(current.getRemark());
        }
        for (String str : columns) {
            int index = columns.indexOf(str);
            String beforeVal = (String) beforeVals.get(index);
            String afterVal = (String) afterVals.get(index);

            Record record = new Record();
            record.setModifier(userName);
            record.setModifyTime(modifyTime);
            record.setColumnName(str);
            record.setBeforeVal(beforeVal);
            record.setAfterVal(afterVal);
            record.setCheckerId(old.getId());

            recordRepo.insert(record);
        }
    }

    @Override
    public void addNewChecker(HttpServletRequest request, Checker current) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            log.error("未登录");
            return;
        }
        String userName = user.getUserName();
        Date modifyTime = new Date();

        Record record = new Record();
        record.setModifier(userName);
        record.setModifyTime(modifyTime);
        record.setColumnName("new addition");
        record.setCheckerId(current.getId());

        recordRepo.insert(record);
    }
}
