package breakoutTaskClass_60;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import helper.Utility;

public class BreakOutTask 
{
	//https://freelance-learn-automation.vercel.app/signup
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp()
	{
		driver=Utility.startBrowser("Chrome", "https://freelance-learn-automation.vercel.app/signup");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyUrl()
	{
		SoftAssert softAssert=new SoftAssert();
		
		String URL=driver.getCurrentUrl();
		
		softAssert.assertTrue(URL.contains("signup"),"URL does not contain signup text");
		
		softAssert.assertAll();
		
	}
	
	@Test(priority=2)
	public void signUpDisabled()
	{
		SoftAssert softAssert=new SoftAssert();
		
		 WebElement signUpButton = driver.findElement(By.xpath("//button[normalize-space()='Sign up']"));

		 softAssert.assertFalse(signUpButton.isEnabled(), "Sign up Button is disabled"); // Check if the button is disabled
	      
	     softAssert.assertAll();
	}
	
	

	
	  @Test(dataProvider ="excel-data") 
	  public void signUpPage(String username, String emailId, String password, String interest, String gender, String state, String hobbies) 
	  {
	  try {
		Utility.startBrowser("Chrome", "https://freelance-learn-automation.vercel.app/signup");
		  
		  WebElement userName=Utility.getElement(driver, By.xpath("//input[@id='name']"));
		  
		  userName.sendKeys(username);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  }
	 
	
	  @DataProvider(name ="excel-data") 
	  public Object[][] readData() throws IOException 
	  {
		  XSSFWorkbook wb=new XSSFWorkbook(new FileInputStream(new File("./TestData/newTestData.xlsx")));
		  String sheetName = "Sheet1";
		  
		  int rowCount=wb.getSheet(sheetName).getPhysicalNumberOfRows();
		  
		  int column=wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
		  
		  Object [][] arr=new Object[rowCount-1][column];
		  
		  for(int i=1;i<rowCount;i++) 
		  { 
			  for(int j=0;j<column;j++)
			  {
				  arr[i-1][j]=wb.getSheet(sheetName).getRow(i).getCell(j).getStringCellValue();
				  System.out.print(arr[i-1][j]);
			  }
		  System.out.println("*************************");
		  }
	      wb.close();
		  return arr;
	  }
	 
  	
}
