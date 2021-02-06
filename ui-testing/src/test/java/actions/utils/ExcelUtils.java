package actions.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public static XSSFSheet getDataSheet(String dataPath, String SheetName) throws Exception {
		try {
			FileInputStream ExcelFile = new FileInputStream(dataPath);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			return ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {
			throw (e);
		}
	}

	public static String getCellData(XSSFSheet dataSheet, int RowNum, int ColNum) throws Exception {
		try {
			Cell = dataSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	public static int getTotalRow(XSSFSheet excelSheet) {
		return excelSheet.getPhysicalNumberOfRows();
	}

	public static void setCellData(String outputFilePath, XSSFSheet dataSheet, String result, int rowNum, int colNum)
			throws Exception {

		try {
			Row = dataSheet.getRow(rowNum);
			Cell = Row.getCell(colNum);
			if (Cell == null) {
				Cell = Row.createCell(colNum);
				Cell.setCellValue(result);
			} else {
				Cell.setCellValue(result);
			}
			FileOutputStream fileOut = new FileOutputStream(outputFilePath);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}
	
	
}
