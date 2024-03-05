package calendar;

import org.openqa.selenium.chrome.*;

import helper.Utility;

import java.util.List;

import org.openqa.selenium.*;

public class FindMukeshInGoogle {

	public static void main(String[] args) throws InterruptedException 
	{
		//WebDriver driver=new ChromeDriver();	
		//driver.manage().window().maximize();
		//WebDriver driver=Utility.startBrowser("https://www.google.com.au/");
		//driver.get("https://www.google.com.au/");
		
		//the above 3 lines can be written and called
		WebDriver driver=Utility.startBrowser("Edge", "https://www.google.com.au/");
		
		driver.findElement(By.name("q")).sendKeys("Mukesh Otwani");
		
		Thread.sleep(2000);
		
		List<WebElement> allSuggestions=driver.findElements(By.xpath("(//div[@role='option'])//div[@role='presentation']//span"));
		
		System.out.println("Total suggestions:" +allSuggestions.size());
		
		for(WebElement ele:allSuggestions)
		{
			String values=ele.getText();
			
			if(values.length()>0)
			{
				System.out.println(values);
			}
		}	
		
	}

}
