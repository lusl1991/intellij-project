package com.softel.model.utils;

import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.*;
import java.awt.*;
import java.awt.Label;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

public class ExportExcelUtil {
    public static byte[] ExportTemplate(String columnNames[], String fileName) throws UnsupportedEncodingException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        WritableWorkbook workbook;
        // 设置文件名
        try {
            workbook = Workbook.createWorkbook(os);
            // 设置第一个sheet名
            WritableSheet sheet = workbook.createSheet(new String(fileName.getBytes("ISO-8859-1"), "gbk"), 0);

            // 设置行宽行高
            CellView cv = new CellView();
            cv.setAutosize(true);
            for (int i = 0; i < columnNames.length; i++) {
                sheet.setColumnView(i, cv);
            }

            sheet.setRowView(0, 800);

            // 设置自定义颜色
            Color c = new Color(153, 204, 255);
            workbook.setColourRGB(Colour.LIGHT_BLUE, c.getRed(), c.getGreen(), c.getBlue());

            // 设置字体，字体 ，字粗
            WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,  WritableFont.BOLD);
            WritableCellFormat wff_merge = new WritableCellFormat(wf);
            wff_merge.setBackground(Colour.LIGHT_BLUE);
            //设置自动换行
            wff_merge.setWrap(true);
            //上下居中
            wff_merge.setVerticalAlignment(VerticalAlignment.CENTRE);
            //左右居中
            wff_merge.setAlignment(Alignment.CENTRE);
            // 设置excel边框
            wff_merge.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            // 第一行，表头
            for (int i = 0; i < columnNames.length; i++) {
                Label columnLabel = new Label(columnNames[i], 2);
                sheet.addCell((WritableCell) columnLabel);
            }
            workbook.write();
            workbook.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return os.toByteArray();
    }
}
