package com.softel.model.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 采用MD5生成32位字符串
 * @author zhongyao
 * @version 2010年12月27日18:02:06
 *
 */
public class RxMD5 {

	private static final  RxMD5 rxmd5 = new RxMD5();

	private static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	public static  RxMD5 getInstance(){
		return rxmd5;
	}

	/**
	 * 对字符串采用MD5加密
	 * @param s
	 * @return
	 */
	public final String md5(String s) {
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * @funcion 对文件全文生成MD5摘要
	 * @param file:要加密的文件
	 * @return MD5摘要码
	 */
	public String getMD5(File file) {
		if (file == null || !file.exists()) {
			return null;
		} else {
			return TxtMD5(file);
		}
	}

	/**
	 * txt文件md5加密
	 * @param file
	 * @return
	 */
	private String TxtMD5(File file){
		FileInputStream fis = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			fis = new FileInputStream(file);
			byte[] buffer = new byte[2048];
			int length = -1;
			while ((length = fis.read(buffer)) != -1) {
				md.update(buffer, 0, length);
			}
			byte[] b = md.digest();
			return byteToHexString(b);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * excel文件转字符串
	 * 说明：单元格之间用|分隔，行与行之间用换行符\r\n分隔
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 */
	private String ExcelToStr(File file) throws FileNotFoundException{
		String msg = "";
		InputStream is =  new FileInputStream(file);
		try {
			is.close();
			Workbook workbook = getWorkBook(file);
			Sheet sheet = workbook.getSheetAt(0);
			//获得当前sheet的开始行
			int firstRowNum  = sheet.getFirstRowNum();
			//获得当前sheet的结束行
			int lastRowNum = sheet.getLastRowNum();
			for(int rowNum = firstRowNum; rowNum <= lastRowNum; rowNum++){
				Row row = sheet.getRow(rowNum);
				short columns = row.getLastCellNum();
				for(int columnNum = 0; columnNum < columns; columnNum++){
					Cell cell = row.getCell(columnNum);
					cell.setCellType(Cell.CELL_TYPE_STRING);
					String value = cell.getStringCellValue();
					msg += value;
					if(columnNum < columns){
						msg += "|";
					}
				}
				if(rowNum < lastRowNum){
					msg += "\\r\\n";
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
		return msg;
	}

	private Workbook getWorkBook(File file) {
		String fileName = file.getName();
		Workbook workbook = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			if(fileName.endsWith("xls")){
				workbook = new HSSFWorkbook(fileInputStream);
			}else if(fileName.endsWith("xlsx")){
				workbook = new XSSFWorkbook(fileInputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return workbook;
	}


	/**
	 * @function 把byte[]数组转换成十六进制字符串表示形式
	 * @param tmp  要转换的byte[]
	 * @return 十六进制字符串表示形式
	 */
	private String byteToHexString(byte[] tmp) {
		String s;
		char str[] = new char[16 * 2];
		int k = 0; // 表示转换结果中对应的字符位置
		for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节转换成 16 进制字符的转换
			byte byte0 = tmp[i]; // 取第 i 个字节
			str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移
			str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
		}
		s = new String(str); // 换后的结果转换为字符串
		return s;
	}

}
