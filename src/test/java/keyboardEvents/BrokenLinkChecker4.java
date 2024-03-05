package keyboardEvents;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Utility;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BrokenLinkChecker4 {

	public static void main(String[] args) 
	{

		WebDriver driver=Utility.startBrowser("https://www.naukri.com/");
		
		List<WebElement> allLinks=driver.findElements(By.xpath("//a[@href]"));
		
		System.out.println("Total Links to scan" +allLinks.size());
		
		List<String> brokenLink=new ArrayList<String>();
		
		for(WebElement ele:allLinks)
		{
			System.out.println("**********************************************");
			
			String linkHRef=ele.getAttribute("href");
			
			int statusCode=RestAssured.get(linkHRef).getStatusCode();
			
			System.out.println("Status Code For:  "+linkHRef+"  "+statusCode);
			
			if(statusCode<400 || statusCode==400)
			{
				System.out.println("Link is working as expected");
			}
			else
			{
				brokenLink.add(linkHRef);
				System.out.println("Link is broken");
			}		
		System.out.println("**********************************************");
		}
		if(brokenLink.size()>0)
		{
			System.out.println("Test Failed- Broken Link Found, Total Broken Links are" +brokenLink.size());
		}
		else
		{
			System.out.println("No Broken Link Found");
		}
		
		driver.quit();		

	}

}
