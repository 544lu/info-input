package com.example.info.config;

import com.example.info.presentation.OrderView;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by llc on 2019/9/9.
 * 用于导出excel表
 */
public class ExcelUtil {

    /**
     * 导出到xlsx表格
     *
     * @param elementList
     */
    public void exportExcel(List<OrderView> elementList, HttpServletResponse response) {
        Logger log = LoggerFactory.getLogger(this.getClass());

        String[] titles = {"医院", "客户ID", "客户姓名", "客户电话", "客户VIP等级", "是否转赠", "参检人", "与投保人关系","身份证号", "出生日期", "年龄", "参检人电话", "性别", "婚姻状况", "体检套餐", "预约日期", "到检情况", "报销情况", "体检报告", "备注"};

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        //创建标题行
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Font font = workbook.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.BLUE.getIndex());
        style.setFont(font);
        Row header = sheet.createRow(0);
        for (int i = 0; i < titles.length; i++) {
            Cell cell = header.createCell(i);
            cell.setCellStyle(style);
            cell.setCellValue(titles[i]);
        }

        //写入数据
        int i = 1;
        for (OrderView order : elementList) {
            Row row = sheet.createRow(i);
            for (int j = 0; j <= header.getLastCellNum(); j++) {
                if (j == 0) {
                    Cell cell = row.createCell(0);
                    cell.setCellValue(order.getSupplier());
                } else if (j == 1) {
                    Cell cell = row.createCell(1);
                    cell.setCellValue(order.getCustemerId());
                } else if (j == 2) {
                    Cell cell = row.createCell(2);
                    cell.setCellValue(order.getCustemerName());
                } else if (j == 3) {
                    Cell cell = row.createCell(3);
                    cell.setCellValue(order.getTelephone());
                } else if (j == 4) {
                    Cell cell = row.createCell(4);
                    cell.setCellValue(order.getVipGra());
                } else if (j == 5) {
                    Cell cell = row.createCell(5);
                    cell.setCellValue(order.isPass() == true ? "是" : "否");
                } else if (j == 6) {
                    Cell cell = row.createCell(6);
                    cell.setCellValue(order.getCheckerName());
                } else if (j == 7) {
                    Cell cell = row.createCell(7);
                    cell.setCellValue(order.getRelationship());
                }else if (j == 8) {
                    Cell cell = row.createCell(8);
                    cell.setCellValue(order.getIdCard());
                } else if (j == 9) {
                    Cell cell = row.createCell(9);
                    cell.setCellValue(order.getBirthday());
                } else if (j == 10) {
                    Cell cell = row.createCell(10);
                    cell.setCellValue(order.getAge());
                } else if (j == 11) {
                    Cell cell = row.createCell(11);
                    cell.setCellValue(order.getCheckerTel());
                } else if (j == 12) {
                    Cell cell = row.createCell(12);
                    cell.setCellValue(order.getSex());
                } else if (j == 13) {
                    Cell cell = row.createCell(13);
                    cell.setCellValue(order.getMaritalSta());
                } else if (j == 14) {
                    Cell cell = row.createCell(14);
                    cell.setCellValue(order.getMeal());
                } else if (j == 15) {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    String dateStr = format.format(order.getOrderDate());
                    Cell cell = row.createCell(15);
                    cell.setCellValue(dateStr);
                } else if (j == 16) {
                    Cell cell = row.createCell(16);
                    cell.setCellValue(order.isChecked() == true ? "已检" : "未检");
                } else if (j == 17) {
                    Cell cell = row.createCell(17);
                    cell.setCellValue(order.isExpense() == true ? "已报销" : "未报销");
                } else if (j == 18) {
                    Cell cell = row.createCell(18);
                    cell.setCellValue(order.isReport() == true ? "已出" : "未出");
                } else {
                    Cell cell = row.createCell(19);
                    cell.setCellValue(order.getRemark());
                }
            }
            i++;
        }
        try {
            response.setHeader("Content-Disposition", "attachment;fileName=" + new String("客户预约信息.xlsx".getBytes("gbk"), StandardCharsets.ISO_8859_1));
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            OutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
