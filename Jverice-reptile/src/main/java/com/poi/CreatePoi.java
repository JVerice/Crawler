package com.poi;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.model.Valve;
/**
 * 生成excel表格
 * @author jverice
 *
 */
public class CreatePoi {
	
	@SuppressWarnings("resource")
	public static void builtPoi(List<Valve> bookDatas) throws Exception{
		Workbook wb=new HSSFWorkbook();
		Sheet sheet=wb.createSheet("第一个Sheet页");  // 创建第一个Sheet页
		Row row=sheet.createRow(0); // 创建一个行
		row.createCell(0).setCellValue("序号");   // 创建一个单元格 第1列 值
		row.createCell(1).setCellValue("书名"); 
		row.createCell(2).setCellValue("评分");
		row.createCell(3).setCellValue("评价人数");
		row.createCell(4).setCellValue("作者");
		row.createCell(5).setCellValue("出版社");
		row.createCell(6).setCellValue("出版日期");
		row.createCell(7).setCellValue("价格");
		int i=0;
		for(Valve valve:bookDatas){
			Row row1=sheet.createRow(i+1); // 创建行
			row1.createCell(0).setCellValue(i+1);   // 创建一个单元格 第1列 值
			row1.createCell(1).setCellValue(valve.getBookName()); 
			row1.createCell(2).setCellValue(valve.getScore()); 
			row1.createCell(3).setCellValue(valve.getNumber());
			row1.createCell(4).setCellValue(valve.getAuthor());
			row1.createCell(5).setCellValue(valve.getPress());
			row1.createCell(6).setCellValue(valve.getDate());
			row1.createCell(7).setCellValue(valve.getPrice());
			i++;
		}
		
		FileOutputStream fileOut=new FileOutputStream("E:\\books.xls");
		wb.write(fileOut);
		fileOut.close();
		
	}
}
