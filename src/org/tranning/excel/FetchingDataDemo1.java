package org.tranning.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class FetchingDataDemo1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("./Data/input.xls");
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet2");
		
	
		//int j;
		int row=0;
		int cell=0;
		for(int i =0;i<=sh.getLastRowNum();i++) {
			
			
			 //cell=i;
			 if(sh.getRow(i).getCell(row).getStringCellValue().equals("TC1"))
			 {

				 row=i;
				// System.out.println(row  +"roowww");
			 }
				 
		}
		for(int j=0;j<sh.getRow(0).getLastCellNum();j++)
				 {
					 
					 //System.out.println("result is"+result1);
					
						 String result1 = sh.getRow(0).getCell(j).getStringCellValue(); 
						 //System.out.println("results "+result1);
						 if(result1.equals("Result"))
						 {
							 cell=j;

							// System.out.print(result1+" ");

						 }

						 
						 System.out.println();

				 }
		
			 
				String result2 = sh.getRow(row).getCell(cell).getStringCellValue();
				System.out.println(result2);

		}
			
		

}
