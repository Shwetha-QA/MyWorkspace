package class47_assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class ByClass {

	public static void main(String[] args) 
	{
		WebDriver driver=Utility.startBrowser("https://login.yahoo.com/");
		
		Utility.type(driver, By.id("login-username"),"admin@yahoo.com");
		
		Utility.clickElement(driver, By.id("persistent"));

	}

}
