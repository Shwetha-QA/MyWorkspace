package mypractice;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.*;

public class MakeMyTrip 
{

	public static void main(String[] args) throws InterruptedException
	{

		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.makemytrip.com/");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
	    driver.findElement(By.xpath("//input[@id='fromCity']")).click();
	    
	   // driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Bengaluru International Airport")
		

	}

}
