package com.testngframework.utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExcelUtil {

	private static Object[][] excelOutput;

	/**
	 * 
	 * @param ExcelFileName
	 * @return
	 * @throws IOException
	 */
	public static Object[][] ExcelTestDataRead(String ExcelFileName)
			throws IOException {
		Integer[] count;
		int rows = 0, cols = 0;

		try {
			FileInputStream file = getFileName(ExcelFileName);
			// read data from sheet
			@SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheetAt(0);
			
			count = getRowandColumnCount(sheet);
			excelOutput = new Object[count[0]][count[1]];
			
			Iterator<Row> rowIterator = sheet.iterator();
			// iterate and fetch the data
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_BOOLEAN:
						boolean valueBoolean = cell.getBooleanCellValue();
						excelOutput[rows][cols] = valueBoolean;
						break;
					case Cell.CELL_TYPE_NUMERIC:
						double valueDouble = cell.getNumericCellValue();
						excelOutput[rows][cols] = valueDouble;
						break;
					case Cell.CELL_TYPE_STRING:
						String valueString = cell.getStringCellValue();
						excelOutput[rows][cols] = valueString;
						break;
					case Cell.CELL_TYPE_BLANK:
						excelOutput[rows][cols] = null;
						break;
					}
					cols = cols + 1;
				}
				rows = rows + 1;
				cols = 0;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return excelOutput;
	}

	/**
	 * Map<String, Integer> getRowandColumnCount(Sheet sheet)
	 * 
	 * @param sheet
	 * @return
	 */
	private static Integer[] getRowandColumnCount(Sheet sheet) {
		int row = 0, column = 0;
		Integer[] count = new Integer[2];

		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row rows = rowIterator.next();
			if (row == 0) {
				Iterator<Cell> cellIterator = rows.cellIterator();
				while (cellIterator.hasNext()) {
					cellIterator.next();
					column = column + 1;
				}
			}
			row = row + 1;
		}
		count[0] = row;
		count[1] = column;

		return count;

	}

	/**
	 * FileInputStream getFileName(ExcelFileName)
	 * 
	 * @return
	 */
	private static FileInputStream getFileName(String ExcelFileName) {

		FileInputStream file = null;
		try {
			String fileName = System.getProperty("user.dir");
			fileName += "/src/test/resources/" + ExcelFileName + ".xlsx";
			file = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return file;
	}

}
