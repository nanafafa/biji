package com.riji.controller.excelDemo;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author 杨鹏发
 * @date 2020/4/28 0028
 */
public class ExcelWriterTest {
    @Test
    public void testWrite03() throws Exception {

        String path="G:\\biji";
        //1.创建一个工作薄
        Workbook workbook = new HSSFWorkbook();
        //2.创建一个工作表sheet
        Sheet sheet = workbook.createSheet("进货统计表");
        //3.创建一个行
        Row row1 = sheet.createRow(0);
        //4.创建一个单元格（1，1）
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("今日新增观众");
        //(1,2)
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue(6666);

        //第二行2,1
        Row row2 = sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("统计时间");
        //第二行2.2
        Cell cell22 = row2.createCell(1);
        cell22.setCellValue(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));

        //生成一张表(IO流)  03版本就是使用的xls结尾的
        FileOutputStream outputStream = new FileOutputStream(path + "狂神统计表03.xls");
        workbook.write(outputStream);
        //关闭流
        outputStream.close();
        System.out.println("狂神excel03表生成完毕");

    }

}
