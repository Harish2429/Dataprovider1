package com.crm.Generic.utilites;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * its developed using Apache POI libraries, which used to handle Microsoft Excel sheet
 * 
 * @author DELL
 *
 */

public class ExcelUtility {
/**
 * its used read the data from excel base done below arguments
 * @param sheetName
 * @param rowNum
 * @param celNum
 * @param Data
 * @param Throwable
 * @throws Throwable 
 * @throws EncryptedDocumentException 
 * 
 */
	public String getDataFromExcel(String sheetName,int rowNum,int celNum) throws EncryptedDocumentException, Throwable
	{
		FileInputStream fis= new FileInputStream(".\\src\\data\\Book.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.getCell(celNum);
		String data = cel.getStringCellValue();
		return data;
		
	}
	
	
	/**
	 * this method is used to get last row Number
	 * @throws Throwable 
	 * @throws EncryptedDocumentException 
	 */
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\data\\Book.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRowNum = sh.getLastRowNum();
		return lastRowNum;
	}
	
	
	/**
	 * this method is used to set the data from excel sheet
	 * @throws Throwable 
	 * @throws EncryptedDocumentException 
	 * 
	 */
	
	public void setDataExcel(String sheetName,int rowNum,int celNum,String data) throws EncryptedDocumentException, Throwable
	{
		FileInputStream fis=new FileInputStream("./src/data/commanData.properties.txt");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./src/data/commanData.properties.txt");
		wb.write(fos);
		wb.close();
	}
	
	
	
	
	
}
