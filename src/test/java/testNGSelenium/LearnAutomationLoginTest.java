package testNGSelenium;

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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import helper.Utility;

public class LearnAutomationLoginTest 
{
	WebDriver driver;
	String categoryName;
	String newcategoryName;
	
	@Parameters("BrowserName")
	@BeforeClass
	public void setup(String browser)
	{
		System.out.println("****Running Before Class - Setting up Browser****");
		
		driver=Utility.startBrowser(browser, "https://freelance-learn-automation.vercel.app/login");
		
		System.out.println("****Running Before Class - Browser is up and running****");
	}
	
	@Test(priority = 1)
	public void loginToApplication()
	{
		WebElement emailId=driver.findElement(By.xpath("//input[@id='email1']"));
		
		WebElement password=driver.findElement(By.xpath("//input[@id='password1']"));
		
		WebElement signInButton=driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
		
		Utility.loginAsAdmin(driver, emailId, password, signInButton);
		
		Assert.assertTrue(driver.findElement(By.xpath("//h4[@class='welcomeMessage']")).getText().contains("Welcome"), "Welcome message do not appear");

	}
	@Test(priority = 2, dependsOnMethods = "loginToApplication")
	public void createCategory() 
	{
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Manage']"))).perform();
		
		driver.findElement(By.xpath("//a[normalize-space()='Manage Categories']")).click();
		
		Set<String> allWindows=driver.getWindowHandles();
		
		List<String> allTabs=new ArrayList<String>(allWindows);
		
		driver.switchTo().window(allTabs.get(1));
		
		driver.findElement(By.xpath("//button[normalize-space()='Add New Category']")).click();
		
		Alert alt=driver.switchTo().alert();
		
		categoryName="AWS";
		  
		alt.sendKeys(categoryName);
		  
		alt.accept();
		
		//Verify AWS category created
		Assert.assertTrue(driver.findElement(By.xpath("//td[normalize-space()='"+categoryName+"']")).isDisplayed(),"Could not create the category");
		
	}
	
	@Test(priority = 3, dependsOnMethods = "createCategory")
	public void verifyCategory()
	{
		WebDriver newWindow=Utility.startBrowser("Chrome", "https://freelance-learn-automation.vercel.app/signup");
				
		Assert.assertTrue(newWindow.findElement(By.xpath("//label[normalize-space()='"+categoryName+"']")).isDisplayed(), "Category not displayed on Singup");
		
		newWindow.quit();	
	}
	
	@Test(priority = 4, dependsOnMethods = "createCategory")
	public void updateCategory()
	{
		driver.findElement(By.xpath("//td[normalize-space()='"+categoryName+"']//following::button[2]")).click();
		
		Alert newAlt=new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
		
		newcategoryName="GCP";
		
		newAlt.sendKeys(newcategoryName);
		
		newAlt.accept();
		
		Assert.assertTrue(driver.findElement(By.xpath("//td[normalize-space()='"+newcategoryName+"']")).isDisplayed(), "Category Updated Failed");

	}
	
	@Test(priority = 5, dependsOnMethods = "createCategory")
	public void deleteCategory()
	{
		driver.findElement(By.xpath("//td[normalize-space()='"+newcategoryName+"']//following::button[1]")).click();
		
		driver.findElement(By.xpath("//button[@class='action-btn'][normalize-space()='Delete']")).click();
		
		List<WebElement> numberOfElements=new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.numberOfElementsToBe(By.xpath("//td[normalize-space()='"+newcategoryName+"']"), 0));

		Assert.assertEquals(numberOfElements.size(), 0, "Category Deletion Failed");
		//Assert.assertTrue(numberOfElements.size()==0, "Category Deletion Failed");
		
	}
	
	@Test(priority = 6, dependsOnMethods = "createCategory")
	public void deleteCategoryFromSignup()
	{
		WebDriver newSession2=Utility.startBrowser("Chrome", "https://freelance-learn-automation.vercel.app/signup");
		
		Assert.assertTrue(newSession2.findElements(By.xpath("//label[normalize-space()='"+newcategoryName+"']")).size()==0, "Category present on register page");
		
		newSession2.quit();

	}

	@AfterClass
	public void tearDown()
	{
		System.out.println("****Running After Class - Closing up Browser****");
		
		driver.quit();
		
		System.out.println("****Running After Class - Browser and Application closed****");
	}
}
