package com.nsfocus.util;

import com.nsfocus.bean.Grade;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class TeacherUtil {
    /*
    * 功能：实现将list集合中数据在xlsx中显示
    * */
    public boolean isProduct(List<Grade> gradeList,String outPath)
    {
        Workbook workbook=new XSSFWorkbook();
        Sheet sheet=workbook.createSheet("0");
        Row row=sheet.createRow(0);//第一行内容
        row.createCell(0).setCellValue("学生姓名");//第一行第一列
        row.createCell(1).setCellValue("学生成绩");//第一行第二列
        int count=1;
        for(Grade grade:gradeList)
        {
            Row rows=sheet.createRow(count++);//下面行数
            rows.createCell(0).setCellValue(grade.getStudent().getStudentname());
            rows.createCell(1).setCellValue(grade.getScore());
        }
        workbook.setSheetName(0,"学生成绩信息");
        try {
            File file = new File(outPath);
            FileOutputStream fileoutputStream = new FileOutputStream(file);
            workbook.write(fileoutputStream);
            fileoutputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
