package keyboardEvents;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Utility;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BrokenImageChecker {

	public static void main(String[] args) 
	{

		WebDriver driver=Utility.startBrowser("https://www.naukri.com/");
		
		List<WebElement> allImages=driver.findElements(By.xpath("//img[@src]"));
		
		System.out.println("Total Images to scan: " +allImages.size());
		
		List<String> brokenImage=new ArrayList<String>();
		
		for(WebElement ele:allImages)
		{
			System.out.println("**********************************************");
			
			String linkHRef=ele.getAttribute("src");
			
			int statusCode=0;
			
			try 
			{
				statusCode=RestAssured.get(linkHRef).getStatusCode();
				
			} catch (Exception e) 
			{
				System.out.println("Exception While Making Request To "+ linkHRef +" "+e.getMessage());
			}
			
			System.out.println("Status Code For:  "+linkHRef+"  "+statusCode);
			
			if(statusCode<400 || statusCode==400)
			{
				System.out.println("Image is working as expected");
			}
			else
			{
				brokenImage.add(linkHRef);
				
				System.out.println("Image is broken");
			}		
		System.out.println("**********************************************");
		}
		if(brokenImage.size()>0)
		{
			System.out.println("Test Failed- Broken Image Found, Total Broken Image are" +brokenImage.size());
		}
		else
		{
			System.out.println("No Broken Image Found");
		}
		
		driver.quit();		

	}

}
