package Demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Sample3 {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\Desktop\\Book.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(1);
		Cell cel = row.createCell(5);
	     cel.setCellValue("hiii");
		  FileOutputStream fos=new FileOutputStream("C:\\Users\\DELL\\Desktop\\Book.xlsx");
		  wb.write(fos);
		  wb.close();
		
		
	     
	}
		
	}


