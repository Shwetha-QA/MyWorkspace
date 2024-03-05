package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Utility;

public class UsingByClassReference {

	public static void main(String[] args) 
	{
		WebDriver driver=Utility.startBrowser("https://login.yahoo.com/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		WebElement element=driver.findElement(By.xpath("//input[@id='login-username']"));
		
		
	}

}
