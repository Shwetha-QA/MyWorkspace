package mypractice;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LearnAutomationSignup {

	public static void main(String[] args) throws InterruptedException 
	{

		WebDriver driver=new ChromeDriver();
		
		driver.get("https://freelance-learn-automation.vercel.app/login");
		Thread.sleep(5000);
		
		driver.manage().window().maximize();
		
		driver.findElement(By.partialLinkText("New user")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("SS");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SSSS");
		
		//List<WebElement> allCheckbox =driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		//allCheckbox.get(1).click();
		driver.findElements(By.xpath("//input[@type='checkbox']")).get(3).click();
		
		WebElement dropdown=driver.findElement(By.id("state"));
		Select state=new Select(dropdown);
		//state.selectByIndex(1);
		//new Select(driver.findElement(By.id("state"))).selectByVisibleText("Goa");
		

	}

}
