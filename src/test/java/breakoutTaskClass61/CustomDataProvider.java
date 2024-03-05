package breakoutTaskClass61;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class CustomDataProvider
{
	@DataProvider(name="TestData")
	public static Object [][] readData() throws IOException
	{

	XSSFWorkbook wb=new XSSFWorkbook(new FileInputStream(new File("./TestData/newTestData.xlsx")));
	
	int rowCount=wb.getSheet("Sheet2").getPhysicalNumberOfRows();
	
	int column=wb.getSheet("Sheet2").getRow(0).getPhysicalNumberOfCells();
	
	Object [][] arr=new Object[rowCount-1][column];
	
	for(int i=1;i<rowCount;i++)
	{
		for(int j=0;j<column;j++)
		{
			arr[i-1][j]=wb.getSheet("Sheet2").getRow(i).getCell(j).getStringCellValue();
			
			System.out.print(arr[i-1][j]);
			
		}
		System.out.println("*************************");
	}
	
	wb.close();
	return arr;

	}

}
