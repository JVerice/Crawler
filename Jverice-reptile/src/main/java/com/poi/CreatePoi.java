package com.poi;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.model.Valve;
/**
 * ����excel���
 * @author jverice
 *
 */
public class CreatePoi {
	
	@SuppressWarnings("resource")
	public static void builtPoi(List<Valve> bookDatas) throws Exception{
		Workbook wb=new HSSFWorkbook();
		Sheet sheet=wb.createSheet("��һ��Sheetҳ");  // ������һ��Sheetҳ
		Row row=sheet.createRow(0); // ����һ����
		row.createCell(0).setCellValue("���");   // ����һ����Ԫ�� ��1�� ֵ
		row.createCell(1).setCellValue("����"); 
		row.createCell(2).setCellValue("����");
		row.createCell(3).setCellValue("��������");
		row.createCell(4).setCellValue("����");
		row.createCell(5).setCellValue("������");
		row.createCell(6).setCellValue("��������");
		row.createCell(7).setCellValue("�۸�");
		int i=0;
		for(Valve valve:bookDatas){
			Row row1=sheet.createRow(i+1); // ������
			row1.createCell(0).setCellValue(i+1);   // ����һ����Ԫ�� ��1�� ֵ
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
