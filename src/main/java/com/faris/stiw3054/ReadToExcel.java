package com.faris.stiw3054;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class ReadToExcel {
    public void saveData() {
        try{
            FollowingStat list = new FollowingStat();
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Sir Zhamri Follower Statistic");

            Row rowHeader = sheet.createRow(0);
            rowHeader.createCell(0).setCellValue("Login id");
            rowHeader.createCell(1).setCellValue("Number of repositories");
            rowHeader.createCell(2).setCellValue("Number of followers");
            rowHeader.createCell(3).setCellValue("Number of stars");
            rowHeader.createCell(4).setCellValue("Number of following");

            for (int i= 0;i <=4;i++){
                CellStyle style = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                font.setFontName(HSSFFont.FONT_ARIAL);
                style.setFont(font);
                style.setVerticalAlignment(VerticalAlignment.CENTER);
                rowHeader.getCell(i).setCellStyle(style);

            }
            int j = 1;
            for (Data info: list.showAcc()) {
                Row row = sheet.createRow(j);
                Cell Column1 = row.createCell(0);
                Column1.setCellValue(info.getColumn1());
                Cell Column2 = row.createCell(1);
                Column2.setCellValue(info.getColumn2());
                Cell Column3 = row.createCell(2);
                Column3.setCellValue(info.getColumn3());
                Cell Column4 = row.createCell(3);
                Column4.setCellValue(info.getColumn4());
                Cell Column5 = row.createCell(4);
                Column5.setCellValue(info.getColumn5());
                j++;
            }


            for (int i= 1;i<=100;i++)
                sheet.autoSizeColumn(i);

            FileOutputStream out= new FileOutputStream(new File("G:\\Sir Zhamri Follower Statistic.xls"));
            workbook.write(out);
            out.close();
            workbook.close();
        }catch (IOException e)  {
            e.printStackTrace();

        }
    }
}
