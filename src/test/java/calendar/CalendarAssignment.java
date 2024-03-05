package calendar;

import helper.Utility;

import java.util.List;

import org.openqa.selenium.*;

public class CalendarAssignment {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=Utility.startBrowser("Chrome", "https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		Thread.sleep(2000);
		
		driver.findElement(By.id("datepicker")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(@class,'ui-datepicker-month')]"));
		Thread.sleep(2000);
		
		//month
		WebElement month=driver.findElement(By.xpath("//span[contains(@class,'ui-datepicker-month')]"));
		
		//year
		WebElement year=driver.findElement(By.xpath("//span[contains(@class,'ui-datepicker-year')]"));
		
		String monthText=month.getText();
		
		String yearText=year.getText();
		
		while(!(monthText.equals("Febraury") && yearText.equals("2025")))
		{
			List<WebElement> nextButtons=driver.findElements(By.xpath("//span[contains(text(),'Next')]"));
			
			for(WebElement nextButton:nextButtons)
			{
				nextButton.click();
			}
			
			yearText = year.getText();
            monthText = month.getText();
            
            if (yearText.equals("2025") && monthText.equals("February")) 
            {
                break;
            }
			
		}
		driver.findElement(By.xpath("//a[normalize-space()='14']")).click();
    }
}
	 		  
