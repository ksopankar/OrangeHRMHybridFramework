package com.vtechsolution.orangehrm.utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	static XSSFWorkbook workbook;

	public ExcelDataProvider(String Filepath) {
		try {

			FileInputStream fins = new FileInputStream(Filepath);
			workbook = new XSSFWorkbook(fins);

		} catch (Exception e) {
			System.out.println("File Not Found" + e.getMessage());
		}

	}

	public static int getRowCount(String sheetname) {
		return workbook.getSheet(sheetname).getLastRowNum();

	} 
	public static int getColsCount(String sheetname) {
		return workbook.getSheet(sheetname).getRow(0).getLastCellNum();

	}

	public static int getRowCount(int index) {
		return workbook.getSheetAt(index).getLastRowNum();

	}

	public static int getColsCount(int index) {
		return workbook.getSheetAt(index).getRow(0).getLastCellNum();

	}

	public static String getStringCellData(String sheetname, int Row, int Col) {
		return workbook.getSheet(sheetname).getRow(Row).getCell(Col).getStringCellValue();
	}

	public static String getStringCellData(int index, int Row, int Col) {
		return workbook.getSheetAt(index).getRow(Row).getCell(Col).getStringCellValue();
	}

	public static int getNumericCellData(String sheetname, int Row, int Col) {
		return (int) workbook.getSheet(sheetname).getRow(Row).getCell(Col).getNumericCellValue();
	}

	public static int getNumericCellData(int index, int Row, int Col) {
		return (int) workbook.getSheetAt(index).getRow(Row).getCell(Col).getNumericCellValue();
	}

	public static Object[][] getExcelData(String sheetname) {

		int row = getRowCount(sheetname);
		int col = getColsCount(sheetname);
//		System.out.println(row);
//		System.out.println(col);
		Object[][] data = new Object[row][col];

//		Object[][] data = new Object[getRowCount(sheetname)][getColsCount(sheetname)];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				data[i][j] = workbook.getSheet(sheetname).getRow(i+1).getCell(j).toString();
			}
		}

		return data;  
	}

//	public static void main(String[] args) {
//		ExcelDataProvider excelData = new ExcelDataProvider("./TestData/TestData.xlsx");
//
//		Object[][] data1 = excelData.getExcelData("login1");
//
//		System.out.println(data1);
//	}
}
