package endtoendscript;

import helper.Utility;

import java.util.List;

import org.openqa.selenium.*;

import com.github.javafaker.Faker;

public class AutomateLearnAutomation {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Open https://freelance-learn-automation.vercel.app/login Validate url should
		 * contains "login" Validate title should contains "Automation" Enter email as
		 * "admin@email.com" and password as "admin@123" Click on login button After
		 * login verify "Manage" button is present
		 * 
		 * Note- Login might take few seconds so please use thread.sleep() as of now.
		 * Later on we will replace with waits.
		 * 
		 */

		// Open https://freelance-learn-automation.vercel.app/login
		WebDriver driver = Utility.startBrowser("https://freelance-learn-automation.vercel.app/login");

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
	
