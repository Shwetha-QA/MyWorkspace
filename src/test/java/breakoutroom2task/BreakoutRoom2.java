package breakoutroom2task;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import helper.Utility;

/*Login to: https://freelance-learn-automation.vercel.app/login
 * Mouse hover to Manage
 * Click on Manage category
 * Click on Add New category
 * Enter category name "AWS"
 * Verify AWS category created
 * Open https://freelance-learn-automation.vercel.app/login and verify AWS is listed in register page under category
 * Now click on update button of AWS category
 * Update the new to GCP
 * Verify category name updated to GCP
 * Click on delete button of GCP category
 * Click on delete option
 * Verify GCP category deleted
 * Open https://freelance-learn-automation.vercel.app/signup and verify GCP is not listed in register page under category
 * quite
 */
public class BreakoutRoom2
{

	public static void main(String[] args) throws InterruptedException 
	{
		//Login to: https://freelance-learn-automation.vercel.app/login
		WebDriver driver=Utility.startBrowser("https://freelance-learn-automation.vercel.app/login");
		
		WebElement emailId=driver.findElement(By.xpath("//input[@id='email1']"));
		
		WebElement password=driver.findElement(By.xpath("//input[@id='password1']"));
		
		WebElement signInButton=driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
		
		Utility.loginAsAdmin(driver, emailId, password, signInButton);
		
		//Mouse hover to Manage
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
		 
		//Utility.getAlertWindow(driver, "AWS");
		
		//Verify AWS category created
		if(driver.findElement(By.xpath("//td[normalize-space()='"+categoryName+"']")).isDisplayed())
				{
					System.out.println("Validation 1: Pass - AWS category created");
				}
				else
				{
					System.out.println("Validation 1: Fail - AWS category is not created");
				}
			
		//Open https://freelance-learn-automation.vercel.app/signup and verify AWS is listed in register page under category
		WebDriver newWindow=new ChromeDriver();
		
		newWindow.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		newWindow.get("https://freelance-learn-automation.vercel.app/signup");
		
		if(newWindow.findElement(By.xpath("//label[normalize-space()='"+categoryName+"']")).isDisplayed())
		{
			System.out.println("Validation 2: Pass - AWS is listed in register page under category");
		}
		else
		{
			System.out.println("Validation 2: Fail - AWS is not listed in register page under category");
		}
		
		newWindow.quit();
		
		//Now click on update button of AWS category
		driver.findElement(By.xpath("//td[normalize-space()='"+categoryName+"']//following::button[2]")).click();
	
		 //Update the new to GCP 
		 Thread.sleep(6000);
		 Alert alt1=driver.switchTo().alert();
		 
		 String categoryName1="GCP";
		  
		 alt1.sendKeys(categoryName1);
		 
		 alt1.accept();
		
		//Verify category name updated to GCP
		 if(driver.findElement(By.xpath("//td[normalize-space()='GCP']")).isDisplayed())
		 {
			 System.out.println("Validation 3: Pass - GCP category is updated");
		 }
		 else
		 {
			 System.out.println("Validation 3: Fail - GCP category is not updated");
		 }
		 
		 //Click on delete button of GCP category
		 driver.findElement(By.xpath("//td[normalize-space()='GCP']//following::button[contains(text(),'Delete')]")).click();
		 
		 //Click on delete option
		 driver.findElement(By.xpath("//button[@class='action-btn'][normalize-space()='Delete']")).click();
		 
		 //Verify GCP category deleted
		 Thread.sleep(6000);
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
				
		 //Open https://freelance-learn-automation.vercel.app/login and verify GCP is not listed in register page under category
		 WebDriver newSession=new ChromeDriver();
		 
		 newSession.manage().window().maximize();
			
		 newSession.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		 newSession.get("https://freelance-learn-automation.vercel.app/signup");
			
		 Boolean interestStatus = false; 
		 List<WebElement> interestList=newSession.findElements(By.xpath("//div[@class='interests-div']//following::label[@class='interest']"));
			for (WebElement interestElement : interestList)
			{
				if(!interestElement.getText().equals("GCP"))
					interestStatus = true; 
				else
					{
						interestStatus = false; 
						break;
					}
			}
			
			if(interestStatus == true)
				System.out.println("Validation 5: Pass - GCP is not listed in register page under category");
			else
				System.out.println("Validation 5: Fail - GCP is listed in register page under category");
			
		newSession.quit();
		
		driver.quit();

	}

}
