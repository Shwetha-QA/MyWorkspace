package class_32assignment;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LaunchLearnAutomation2 
{
	/*
	 * Open https://freelance-learn-automation.vercel.app/login
	 * Validate url should contains "login"
     * Validate title should contains "Automation"
	 * Enter email as "admin@email.com" and password as "admin@123"
     * Click on login button
	 * After login verify "Manage" button is present

	   Note- Login might take few seconds so please use thread.sleep() as of now. Later on we will replace with waits.
	 * 
	 */
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://freelance-learn-automation.vercel.app/login");
		
		driver.manage().window().maximize();
		
		//Validate url should contains "login"
		String url=driver.getCurrentUrl();
	
		System.out.println("URL is : " +url);
		if(url.contains("login"))
		{
			System.out.println("TestCase_01: Validation- URL contains login - Pass");
		}
		else
		{
			System.out.println("TestCase_01: Validation- URL contains login - Fail");
		}
		
		//Validate title should contains "Automation"
		String title=driver.getTitle();
		System.out.println("Title is :" +title);
		if(title.contains("Automation"))
		{
			System.out.println("TestCase_02: Validation- Title contains Automation - Pass");
		}
		else
		{
			System.out.println("TestCase_02: Validation- Title contains Automation - Fail");
		}
			
		// Enter email as "admin@email.com" and password as "admin@123"
		driver.findElement(By.id("email1")).sendKeys("admin@email.com");
		driver.findElement(By.id("password1")).sendKeys("admin@123");
		
		//Click on login button
		driver.findElement(By.className("submit-btn")).click();
		Thread.sleep(2000);
		
		//After login verify "Manage" button is present
		
		try 
		{
		WebElement manageButton=driver.findElement(By.xpath("//span[normalize-space()='Manage']"));
		System.out.println("TestCase_03: Manage button is present - Pass");
		}
		catch(org.openqa.selenium.NoSuchElementException e) 
		{
            System.out.println("TestCase_03: Manage button is not present - Login failed");
		}
		
		driver.quit();

	}

}
