package testNGSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import helper.Utility;

public class OrangeHRM 
{
	WebDriver driver;
	
	@BeforeClass
	public void setUp()
	{
		driver=Utility.startBrowser("Chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	public void loginPage()
	{
		
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
