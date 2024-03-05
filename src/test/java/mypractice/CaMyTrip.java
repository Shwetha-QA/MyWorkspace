package mypractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Utility;

public class CaMyTrip {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=Utility.startBrowser("https://ca.mytrip.com/");
		
		driver.findElement(By.xpath("//button[@class='b0x94f5 b0x94f0 b0x94f3 css-8ftosc']")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'From')]")).click();
		
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[normalize-space()='Bangalore']")).click();
		//js.executeScript("arguments[0]", fromPlace);

	}

}
