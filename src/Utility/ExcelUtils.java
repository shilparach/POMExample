package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	
	public  static Object[][] getTableArray(String FilePath,String SheetName) throws Exception {
		
		String [][]tabArray=null;
	
		
		try{
			FileInputStream ExcelFile = new FileInputStream(FilePath);
			
			//Access the required test data sheet
			
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			
			int startRow = 1;
			int startCol = 1;
			
			int ci,cj;
			
			int totalRows = ExcelWSheet.getLastRowNum();
			
			
			//int totalCols = ExcelWSheet.getRow(startRow).getLastCellNum();
			
			int totalCols =2;
			
			tabArray = new String[totalRows][totalCols];
			
			ci = 0;
			
			for(int i=startRow;i<=totalRows;i++,ci++){
				cj = 0;
				for(int j=startCol;j<=totalCols;j++,cj++){
					tabArray[ci][cj]=getCellData(i,j);
					System.out.println(tabArray[ci][cj]);
				}
			}
			
		}
		catch (NullPointerException|FileNotFoundException e){
			 
			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

			}

		catch (IOException e){

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

			}
		
		return (tabArray);
		
		
	}


	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num
	

	public static String getCellData(int RowNum,int ColNum) throws Exception{
		try{
			Cell=ExcelWSheet.getRow(RowNum).getCell(ColNum);
			
				String CellData = Cell.getStringCellValue();
				return CellData;
			
			}catch (Exception e){
				return "";
			}
		
	}
	

}
