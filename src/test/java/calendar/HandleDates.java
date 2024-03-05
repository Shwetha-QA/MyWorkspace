package calendar;

import org.openqa.selenium.chrome.*;

import helper.Utility;

import java.util.List;

import org.openqa.selenium.*;

public class HandleDates {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=Utility.startBrowser("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("datepicker")).click();
		
		//click to next month
		driver.findElement(By.xpath("//span[contains(@class,'ui-icon ui-icon-circle-triangle-e')]")).click();

		
		List<WebElement> allDates=driver.findElements(By.xpath("//table[contains(@class,'ui-datepicker-calendar')]//td//a"));
		
		for(WebElement ele:allDates)
		{
			String dates=ele.getText();
			
			System.out.println("Dates are" +dates);
			
			if(dates.equalsIgnoreCase("19"))
			{
				ele.click();
				break;
			}					
		}
		
	}

}
