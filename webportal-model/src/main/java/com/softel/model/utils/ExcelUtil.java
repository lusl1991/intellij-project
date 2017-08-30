package com.softel.model.utils;

import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.*;
import jxl.write.Label;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class ExcelUtil {
    /**
     * 下载excel文件模板
     * @param columnNames
     * @param list
     * @return
     * @throws UnsupportedEncodingException
     */
    public static byte[] ExportTemplate(List<Field> columnNames, List<Method> columnMethods, List<Object> list) throws UnsupportedEncodingException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        WritableWorkbook workbook;
        // 设置文件名
        try {
            workbook = Workbook.createWorkbook(os);
            // 设置第一个sheet名
            WritableSheet sheet = workbook.createSheet("sheet1", 0);

            // 设置行宽行高
            CellView cv = new CellView();
            cv.setAutosize(true);
            for (int i = 0; i < columnNames.size(); i++) {
                cv.setSize(500);
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
            for (int i = 0; i < columnNames.size(); i++) {
                Label columnLabel = new Label(i,0,columnNames.get(i).getName(), wff_merge);
                sheet.addCell(columnLabel);
            }

            //设置excel数据区边框
            WritableCellFormat data_merge = new WritableCellFormat();
            data_merge.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            //设置数据区左右居中
            data_merge.setAlignment(Alignment.CENTRE);
            //设置数据区背景色
            data_merge.setBackground(Colour.WHITE);

            //填充数据
            if(list!=null){
                for(int row = 0; row < list.size(); row++){
                    sheet.setRowView(row+1, 400);
                    Object rowobj = list.get(row);
                    for(int col = 0; col < columnNames.size(); col++){
                        Method method = columnMethods.get(col);
                        Object colobj = method.invoke(rowobj);
                        Label dataLabel = new Label(col, row+1, colobj.toString(),data_merge);
                        sheet.addCell(dataLabel);
                    }
                }
            }
            workbook.write();
            workbook.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return os.toByteArray();
    }

    /**
     * 对excel单元格数值进行格式化
     * @param cell
     * @return
     */
    public Object getCellValue(Cell cell){
        Object value = null;
        DecimalFormat df = new DecimalFormat("0");  //格式化number String字符
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //日期格式化
        DecimalFormat df2 = new DecimalFormat("0.00");  //格式化数字

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                value = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if("General".equals(cell.getCellStyle().getDataFormatString())){
                    value = df.format(cell.getNumericCellValue());
                }else if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){
                    value = sdf.format(cell.getDateCellValue());
                }else{
                    value = df2.format(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            default:
                break;
        }
        return value;
    }

    /**
     * excel2003版本，文件格式.xls
     * @param path
     * @return
     * @throws IOException
     */
    public static byte[] WriteHssf(String path) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream( new File(path)));
        HSSFSheet sheet = workbook.getSheetAt(0);
        for(int r = 1; r < 50; r++){
            HSSFRow row = sheet.createRow(r);
            String name = "name" + "-" + r ;
            String sex = "sex" + "-" + r ;
            String phone = "phone" + "-" + r ;
            String address = "address" + "-" + r ;
            HSSFCell first = row.createCell(0);
            first.setCellValue(name);

            HSSFCell second = row.createCell(1);
            second.setCellValue(sex);

            HSSFCell third = row.createCell(2);
            third.setCellValue(phone);

            HSSFCell fourth = row.createCell(3);
            fourth.setCellValue(address);
        }
        workbook.write(os);
        return  os.toByteArray();
    }

    /**
     * excel2007及以上版本，格式.xlsx
     * @param path
     * @return
     * @throws IOException
     */
    public static byte[] WriteXssf(String path) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream( new File(path)));
        XSSFSheet sheet = workbook.getSheetAt(0);
        for(int r = 1; r < 50; r++){
            XSSFRow row = sheet.createRow(r);
            String name = "name" + "-" + r ;
            String sex = "sex" + "-" + r ;
            String phone = "phone" + "-" + r ;
            String address = "address" + "-" + r ;
            XSSFCell first = row.createCell(0);
            first.setCellValue(name);

            XSSFCell second = row.createCell(1);
            second.setCellValue(sex);

            XSSFCell third = row.createCell(2);
            third.setCellValue(phone);

            XSSFCell fourth = row.createCell(3);
            fourth.setCellValue(address);
        }
        workbook.write(os);
        return  os.toByteArray();
    }
}