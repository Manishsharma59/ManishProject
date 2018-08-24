package com.uiFramework.companyName.projectName.helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.resource.ResouceHelper;

import freemarker.core.StringArraySequence;

public class ExcelHelper {
	private Logger log = LoggerHelper.getLogger(ExcelHelper.class);

	public Object[][] getExcelData(String excelLocation, String sheetName) {
		try {
			Object[][] dataSets = null;
			FileInputStream file = new FileInputStream(new File(excelLocation));
			// Create workbook instance
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// Get Sheet name from workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			// count number of active rows in excel sheet
			int totalRow = sheet.getLastRowNum();
			// count number of active column in row
			short totalColumn = sheet.getRow(0).getLastCellNum();

			dataSets = new Object[totalRow+1][totalColumn];
			// Iterator through each row one by one
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;
			while (rowIterator.hasNext()) {
				i++;
				// For every row we need to iterate over columns
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				int j = 0;
				while (cellIterator.hasNext()) {
					j++;
					Cell cell = cellIterator.next();

					switch (cell.getCellTypeEnum()) {
					case STRING:
						dataSets[i-1][j-1] = cell.getStringCellValue();
						break;
					case NUMERIC:
						dataSets[i-1][j-1] = cell.getNumericCellValue();
						break;
					case BOOLEAN:
						dataSets[i-1][j-1] = cell.getBooleanCellValue();
						break;
					case FORMULA:
						dataSets[i-1][j-1] = cell.getCellFormula();
						break;
					default:
						System.out.println("No matching enum data type found");
						break;
					}
				}
			}
			return dataSets;
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return null;
	}
	
	public void updateResult(String excelLocation, String sheetName,String testCaseName,String testStatus) {
		
		try {
			FileInputStream file = new FileInputStream(new File(excelLocation));
			// Create workbook instance
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// Get Sheet name from workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			// count number of active rows in excel sheet
			int totalRow = sheet.getLastRowNum()+1;
			for(int i =1;i<totalRow;i++) {
				XSSFRow r = sheet.getRow(i);
				String ce = r.getCell(0).getStringCellValue();
				if(ce.contains(testCaseName)) {
					r.createCell(1).setCellValue(testStatus);
					file.close();
					log.info("Result is updated");
					FileOutputStream out = new FileOutputStream(new File(excelLocation));
					workbook.write(out);
					out.close();
					break;
				}
				
			}
			
		}catch(Exception e) {
			
		}
		
	}
	
	public static void main(String[] args) {
		
		ExcelHelper excelHelper = new ExcelHelper();
		Object[][] data = excelHelper.getExcelData(ResouceHelper.getResources("src\\main\\resources\\Book1.xlsx"), "Login");
		 System.out.println(data);
		//excelHelper.updateResult(ResouceHelper.getResources("src\\main\\resources\\Book1.xlsx"), "TestScripts", "Login", "PASS");
		//excelHelper.updateResult(ResouceHelper.getResources("src\\main\\resources\\Book1.xlsx"), "TestScripts", "Registration", "FAIL");
		//excelHelper.updateResult(ResouceHelper.getResources("src\\main\\resources\\Book1.xlsx"), "TestScripts", "Add to cart", "PASS");
	}
	
}
