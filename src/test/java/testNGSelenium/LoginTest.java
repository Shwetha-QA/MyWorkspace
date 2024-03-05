package testNGSelenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import helper.Utility;

public class LoginTest 
{
	WebDriver driver;
	String categoryName;
	
	@BeforeClass 
	public void setup()
	{
		driver=Utility.startBrowser("Chrome", "https://freelance-learn-automation.vercel.app/login");
		
	}
	
	@Test(priority = 1)
	public void loginToApplication()
	{
		WebElement emailId=driver.findElement(By.xpath("//input[@id='email1']"));
		
		WebElement password=driver.findElement(By.xpath("//input[@id='password1']"));
		
		WebElement signInButton=driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
		
		Utility.loginAsAdmin(driver, emailId, password, signInButton);
		
		Assert.assertTrue(driver.findElement(By.xpath("//h4[@class='welcomeMessage']")).getText().contains("Welcome"),"Welcome text did not appear");
	}
	
	@Test(priority = 2, dependsOnMethods = "loginToApplication")
	public void createCategory()
	{
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Manage']"))).perform();
		
		WebElement manageCategory=driver.findElement(By.xpath("//a[normalize-space()='Manage Categories']"));
		
		Utility.clickElement(driver, manageCategory);
		
		Set<String> allWindows=driver.getWindowHandles();
		
		List<String> allTabs=new ArrayList<String>(allWindows);
		
		driver.switchTo().window(allTabs.get(1));
		
		//Click on Add New category
		driver.findElement(By.xpath("//button[normalize-space()='Add New Category']")).click();
		
		//Enter category name "AWS"
		
		Alert alt=driver.switchTo().alert();
		  
		String categoryName="AWS";
		  
		alt.sendKeys(categoryName);
		  
		alt.accept();
		
		//Verify AWS category created
		Assert.assertTrue(driver.findElement(By.xpath("//td[normalize-space()='"+categoryName+"']")).isDisplayed(),"Could not create the category");
		
	}
	
	@Test(priority = 3, dependsOnMethods = "createCategory")
	public void verifyCategoryOnRegisterion()
	{
		//Open https://freelance-learn-automation.vercel.app/signup and verify AWS is listed in register page under category
		WebDriver newWindow=Utility.startBrowser("Chrome","https://freelance-learn-automation.vercel.app/signup");
			
		Assert.assertTrue(newWindow.findElement(By.xpath("//label[normalize-space()='"+categoryName+"']")).isDisplayed(), "Category not displayed on Singup");
		
		newWindow.quit();
	}
	
	@Test(priority = 4, dependsOnMethods = "createCategory")
	public void updateCategory() throws InterruptedException
	{
		//Now click on update button of AWS category
		driver.findElement(By.xpath("//td[normalize-space()='"+categoryName+"']//following::button[2]")).click();
			
		//Update the new to GCP 
		 Thread.sleep(6000);
		 Alert alt1=driver.switchTo().alert();
				 
		 String categoryName1="GCP";
				  
		 alt1.sendKeys(categoryName1);
				 
		 alt1.accept();
				
		 //Verify category name updated to GCP
		 Assert.assertTrue(driver.findElement(By.xpath("//td[normalize-space()='GCP']")).isDisplayed(), "Category update failed");
		
	}
	@Test(priority = 5, dependsOnMethods = "createCategory")
	public void deleteCategory()
	{
		 //Click on delete button of GCP category
		 driver.findElement(By.xpath("//td[normalize-space()='GCP']//following::button[contains(text(),'Delete')]")).click();
		 
		 //Click on delete option
		 driver.findElement(By.xpath("//button[@class='action-btn'][normalize-space()='Delete']")).click();
		 
		 //Verify GCP category deleted
		 Boolean categoryStatus = false;
		 List<WebElement> categoryList=driver.findElements(By.xpath("//table[@class='category-table table table-borderless']//tbody//tr//td[1]"));
			for (WebElement categoryElement : categoryList) 
			{	
				if(!categoryElement.getText().equals("GCP"))
					categoryStatus = true;
				else {
						categoryStatus = false;
						break;
					}
			}
			
			if(categoryStatus == true)
				System.out.println("Validation 4: Pass - Category Deleted");
			else
				System.out.println("Validation 4: Fail - Category Still Exist");
				
	}
	

	@AfterClass
	public void tearDown()
	{
		driver.quit();
		
	}
}
