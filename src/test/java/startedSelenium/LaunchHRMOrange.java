package startedSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Utility;

public class LaunchHRMOrange {

	public static void main(String[] args) 
	{
		WebDriver driver=Utility.startBrowser("Chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//click on myinfo
		driver.findElement(By.xpath("//span[normalize-space()='My Info']")).click();
		
	
		 WebElement firstName=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		 
		firstName.clear(); firstName.sendKeys("Sushruth");
		
		WebElement middleName=driver.findElement(By.xpath("//input[@placeholder='Middle Name']"));
		
		middleName.sendKeys("G");
		
		driver.findElement(By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//div[1]//div[2]//div[1]//div[1]//div[2]//input[1]")).sendKeys("Sush");
		
		WebElement empId=driver.findElement(By.xpath("//div[@class='orangehrm-edit-employee-content']//div[2]//div[1]//div[1]//div[1]//div[2]//input[1]"));
		empId.clear();
		empId.sendKeys("007");
		
		driver.findElement(By.xpath("//div[@class='orangehrm-edit-employee-content']//div[2]//div[1]//div[1]//div[1]//div[2]//input[1]")).sendKeys("Nill");
		
		
		

	}

}
