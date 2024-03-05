package keyboardEvents;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Utility;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BrokenLinkChecker3 {

	public static void main(String[] args) 
	{
		// Step 1- Capture all href
		// Step 2- Make API call for each href
		// Step 3- If code<400 working fine else fail

		WebDriver driver=Utility.startBrowser("https://www.naukri.com/");
		
		List<WebElement> allLinks=driver.findElements(By.xpath("//div[contains(@class,'column')]//a"));
		
		for(WebElement ele:allLinks)
		{
			String linkHRef=ele.getAttribute("href");
			
			int statusCode=RestAssured.get(linkHRef).getStatusCode();
			
			System.out.println("Status Code For"+linkHRef+" "+statusCode);
			
			if(statusCode<400)
			{
				System.out.println("Link is working as expected");
			}
			else
			{
				System.out.println("Link is broken");
			}
			
		}
		
	
		
		driver.quit();
		

	}

}
