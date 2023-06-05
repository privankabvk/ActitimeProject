package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibrary {
	/**
	 * this method is a generic method which is used to read data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readdataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./Testdata/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value; 
				
	}
	public String readDataFromExcel(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./Testdata/Testdata1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	

}
