package JSDemoOptionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import helper.Utility;
import org.openqa.selenium.*;

public class OptionsClass {

	public static void main(String[] args) 
	{

		ChromeOptions opt=new ChromeOptions();
		
		opt.addArguments("--headless=new");
		
		WebDriver driver=new ChromeDriver(opt);
		
		driver.get("https://freelance-learn-automation.vercel.app/login");
		
		Utility.getElement(driver, By.xpath("//input[@id='email1']")).sendKeys("admin@email.com");
		
		Utility.getElement(driver, By.xpath("//input[@id='password1']")).sendKeys("admin@123");
		
		Utility.getElement(driver, By.className("submit-btn")).click();
		
		System.out.println("Sucessfully executed in headless mode");

	}

}
