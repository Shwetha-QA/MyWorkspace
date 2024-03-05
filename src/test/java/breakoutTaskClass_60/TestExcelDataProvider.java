package breakoutTaskClass_60;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestExcelDataProvider 
{
	 @DataProvider(name = "LoginData")
	    public Object[][] readData() throws IOException 
	    {
	        String filePath = "./TestData/newTestData.xlsx";
	        
	        FileInputStream fis = new FileInputStream(new File(filePath));
	        
	        XSSFWorkbook wb = new XSSFWorkbook(fis);
	        
	        String sheetName = "Sheet1";

	        int rowCount = wb.getSheet(sheetName).getPhysicalNumberOfRows();
	        
	        int column = wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();

	        Object[][] arr = new Object[rowCount - 1][column];

	        for (int i = 1; i < rowCount; i++) 
	        {
	            for (int j = 0; j < column; j++) 
	            {	
	            	
	                arr[i - 1][j] = wb.getSheet(sheetName).getRow(i).getCell(j).getStringCellValue();
	            }
	        }

	        wb.close();
	        fis.close();

	        return arr;
	    }

}
