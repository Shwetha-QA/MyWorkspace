package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import helper.Utility;

public class JSExecutor {

	public static void main(String[] args) 
	{
		WebDriver driver=Utility.startBrowser("https://login.yahoo.com/");
		
		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("admin@yahoo.com");
		
		driver.findElement(By.xpath("//label[@for='persistent']")).click();
		
	}

}
