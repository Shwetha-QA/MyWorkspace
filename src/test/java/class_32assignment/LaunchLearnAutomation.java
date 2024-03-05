package class_32assignment;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LaunchLearnAutomation 
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
		
		//Validate URL
		if(driver.getCurrentUrl().contains("login"))
		{
			System.out.println("TestCase_01: URL validation passed");
		}
		else
		{
			System.out.println("TestCase_01: URL validation failed");
		}
		
		//Validate title should contains "Automation"
		if(driver.getTitle().contains("Automation"))
		{
			System.out.println("TestCase_02: Title validation passed");
		}
		else
		{
			System.out.println("TestCase_02: Title validation failed");
		}
		
		//Enter email as "admin@email.com" and password as "admin@123"
		driver.findElement(By.xpath("//input[@id='email1']")).sendKeys("admin@email.com");
		driver.findElement(By.xpath("//input[@id='password1']")).sendKeys("admin@123");
		
		//Click on login button
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
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
