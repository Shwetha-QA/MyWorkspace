package seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.javafaker.Faker;

public class SeleniumGridLT2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException
	{
		ChromeOptions browserOptions = new ChromeOptions();
		
		browserOptions.setPlatformName("Windows 11");
		
		browserOptions.setBrowserVersion("121.0");
		
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		
		ltOptions.put("username", "shwethas.aus");
		
		ltOptions.put("accessKey", "kTN8ReClFDnXySwnPVRbsQwE02C4OZwyko8rESKCHq38WOYGHL");
		
		//ltOptions.put("project", "Untitled");
		
		ltOptions.put("w3c", true);
		
		//ltOptions.put("plugin", "java-java");
		
		browserOptions.setCapability("LT:Options", ltOptions);
		
		URL hubURL=new URL("https://shwethas.aus:kTN8ReClFDnXySwnPVRbsQwE02C4OZwyko8rESKCHq38WOYGHL@hub.lambdatest.com/wd/hub");
		
		WebDriver driver=new RemoteWebDriver(hubURL,browserOptions);
		
		driver.get("https://freelance-learn-automation.vercel.app/login");
		
		// Validate url should contains "login"
				String currentUrl = driver.getCurrentUrl();

				if (currentUrl.contains("login")) 
				{
					System.out.println("TC_001:Validation Pass url contains login");
				} 
				else 
				{
					System.out.println("TC_001:Validation Failes url doesnot contains login");
				}

				// Validate title should contains "Automation"
				String title = driver.getTitle();

				if (title.contains("Automation"))
				{
					System.out.println("TC_002:Validation Pass Title contains Automation");
				} 
				else
				{
					System.out.println("TC_002:Validation Failed Title doesnot contains Automation");
				}
				
				// Using Faker to generate dynamic user email and password
		        Faker faker = new Faker();
		        String userEmail = faker.internet().emailAddress();
		        String userPassword = faker.internet().password();
		        Thread.sleep(2000);
		        
				// Enter email as "admin@email.com" and password as "admin@123"
				driver.findElement(By.xpath("//input[@placeholder='Enter Email']")).sendKeys("admin@email.com");
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("admin@123");

				// Click on login button
				driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
				Thread.sleep(5000);

				// After login verify "Manage" button is present
				WebElement manageButton = driver.findElement(By.cssSelector("div[class='nav-menu-item-manage'] span"));

				if (manageButton.equals("Manage"))
				{
					System.out.println("TC_003:Validation Pass \"Manage\" button is present");
				}
				else
				{
					System.out.println("TC_003:Validation Failed \"Manage\" button is present");
				}

				// click on manage button
				manageButton.click();

				// click on Manage Courses
				driver.findElement(By.xpath("//a[@href='/course/manage']")).click();

				driver.findElement(By.xpath("//div[@class='manage-btns']//button[4]")).click();
				Thread.sleep(2000);
				
				//thumbnail give path name
				driver.findElement(By.xpath("//input[@id='thumbnail']")).sendKeys("C:\\Users\\shwet\\OneDrive\\Desktop\\selenium-icon-2048x1986-3fr2ikf8.png");
				Thread.sleep(2000);
				// Add Course
				driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Selenium + Java");
				
				driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("Selenium Online Course for beginners");
				
				driver.findElement(By.xpath("//input[@name='instructorName']")).sendKeys("Shwetha Sushruth");
				
				driver.findElement(By.xpath("//input[@id='price']")).clear();
				
				driver.findElement(By.xpath("//input[@id='price']")).sendKeys("15000");
				
				//select startdate
				driver.findElement(By.xpath("//input[@name='startDate']")).click();
				
				WebElement monthYear = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']"));
				
				String monthYearText = monthYear.getText();
				
				System.out.println("The month and year is: " + monthYearText);
				
				while (!(monthYearText.equals("February 2024"))) {
		        	
		        List<WebElement> nextButtons = driver.findElements(By.xpath("//span[@class='react-datepicker__navigation-icon react-datepicker__navigation-icon--next']"));
		       
		        for (WebElement nextButton : nextButtons)
		        {
		        	
		            nextButton.click();

		            monthYearText = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']")).getText();
		            
		            System.out.println("The month is: " + monthYearText);

		            if (monthYearText.equals("February 2024")) 
		            {
		            	driver.findElement(By.xpath("//div[@aria-label='Choose Thursday, February 1st, 2024']")).click();
		            	
		                break;
		            }
		        }
		    }
				//select check box
				// driver.findElement(By.xpath("//div[@class='combine-child']/input[@type='checkbox']")).click();
				  
				//select category from the dropdown 
				 WebElement selectCategory=driver.findElement(By.xpath("//div[contains(text(),'Select Category')]/img"));
				 selectCategory.click(); 
				 Thread.sleep(2000);
				 
				 driver.findElement(By.xpath("//button[normalize-space()='Selenium']")).click();
				  
				  //save
				 driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
				  
				 driver.quit();
				 
	}

}
