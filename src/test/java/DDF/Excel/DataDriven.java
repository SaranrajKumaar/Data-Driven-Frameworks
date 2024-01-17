package DDF.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static Object[][] getTestDataFromExcel(String sheetName) throws IOException {
		// TODO Auto-generated method stub

		File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\DDF\\ExcelPath\\DDFexcel.xlsx");
		
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook =  new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rows =sheet.getLastRowNum();
		int cols =sheet.getRow(0).getLastCellNum();
		
		Object [][] data = new Object[rows][cols];
		for (int i =0; i<rows; i++)
		{
			XSSFRow row =sheet.getRow(i+1);
			for (int j=0; j<cols; j++) 
			{
				XSSFCell cell= row.getCell(j);
				CellType celltype =cell.getCellType();
				
				switch(celltype) {
				case STRING:
					data[i][j] =cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j]=Integer.toString((int) cell.getNumericCellValue());
				break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
			
					
				
				}
			}
			
		}
		
		return data;
		
	}

}
