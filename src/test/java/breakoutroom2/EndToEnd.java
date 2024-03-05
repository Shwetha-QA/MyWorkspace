package breakoutroom2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import helper.Utility;

public class EndToEnd 
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=Utility.startBrowser("https://freelance-learn-automation.vercel.app/login");
		
		WebElement emailId=driver.findElement(By.xpath("//input[@id='email1']"));
				
		Utility.highlightAndType(driver, emailId, "admin@email.com");
		
		WebElement password=driver.findElement(By.xpath("//input[@id='password1']"));
				
		Utility.highlightAndType(driver, password, "admin@123");
		
		WebElement signInButton=driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
				
		Utility.highlightAndClickElement(driver, signInButton);
		
		System.out.println("Step1:Pass Login Sucessfull");
		
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Manage']"))).perform();
 
		driver.findElement(By.xpath("//a[normalize-space()='Manage Categories']")).click();
	
		String parentWindow=driver.getWindowHandle();
	  
		Set<String> allwindowhandles = driver.getWindowHandles();
	
		List<String> allTabs=new ArrayList<String>(allwindowhandles);
	
		driver.switchTo().window(allTabs.get(1));
		
		System.out.println("We are in Child Window");
	
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Add New Category ')]")).click();
		
		Alert alt=driver.switchTo().alert();
		
		String CategoryName = "AWS2 Room-2";
		
		alt.sendKeys(CategoryName);
		
		alt.accept();
		
		WebElement categoryCreated=driver.findElement(By.xpath("//td[contains(text(),'AWS2 Room-2')]"));
		
		if(categoryCreated.isDisplayed())
		{
			System.out.println("Validation1: Pass Category Created");
		}
		else
		{
			System.out.println("Validation1: Fail Category is not Created");
		}
		
		//driver.close();
		
		WebDriver driver1=Utility.startBrowser("https://freelance-learn-automation.vercel.app/Signup");
		
		Boolean categoryPresent=driver1.findElement(By.xpath("//label[normalize-space()='AWS2 Room-2']")).isDisplayed();
		
		if(categoryPresent)
		{
			System.out.println("Validation2: Pass Category Presented on Registration page");
		}
		else
		{
			System.out.println("Validation2: Fail Category is not Present on Registration page");
		}
		
		driver1.quit();
		
		//use following Xpath 
		driver.findElement(By.xpath("//td[contains(text(),'AWS2 Room-2')]//following::button[2]")).click();
		
		Alert alt2=new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
		
		//Alert alt1=driver.switchTo().alert();
	
		alt2.sendKeys("GCP Room2");
		
		alt2.accept();
		
		WebElement categoryUpdated=driver.findElement(By.xpath("//td[contains(text(),'GCP Room2')]"));
		
		if(categoryUpdated.isDisplayed())
		{
			System.out.println("Validation3: Pass Category Updated");
		}
		else
		{
			System.out.println("Validation3: Fail Category is not Created");
		}
		
		driver.findElement(By.xpath("//td[text()='GCP Room2']//following::button[1]")).click();
		
		//driver.findElement(By.xpath("//div[@class='modal-content']//following::div[2]/button[contains(text(),'Delete')]")).click();
		
		System.out.println("Validation4: Pass Category GCP Deleted");
		
		driver.findElement(By.xpath("//div[@class='modal-content']//*[text()='Delete']")).click();
		
		List<WebElement> categoryList=driver.findElements(By.xpath("//table[@class='category-table table table-borderless']//tbody//tr"));
		for (WebElement categoryElement : categoryList) {
			if(categoryElement.getText().equals("GCP"))
			{
				System.out.println("Validation4: Pass Category Deleted");
			}
			else
			{
				System.out.println("Validation3: Fail Category Still Exist");
			}
			
		}	
		
		}
		

	}
	

