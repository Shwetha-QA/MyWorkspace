package breakoutroom4;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LaunchLearnAutomation {

	public static void main(String[] args) throws InterruptedException 
	{

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://freelance-learn-automation.vercel.app/login");
		
		//verify URL contains login
		String url=driver.getCurrentUrl();
		if(url.contains("login"))
		{
			System.out.println("Validation_1:Pass URL contains" +url);
		}
		else
		{
			System.out.println("Validation_1:Fail URL contains" +url);
		}
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		WebElement errorMessage=driver.findElement(By.xpath("//h2[contains(text(),'Email and Password is required')]"));
		if(errorMessage.isDisplayed())
		{
			System.out.println("Validation_2:Pass Error message is displayed");
		}
		else
		{
			System.out.println("Validation_2: Verification failed");
		}
	
		driver.findElement(By.partialLinkText("New user?")).click();
		Thread.sleep(2000);
		String currentUrl=driver.getCurrentUrl();
		if(currentUrl.contains("signup"))
		{
			System.out.println("Validation_3:Pass URL contains" +currentUrl);
		}
		else
		{
			System.out.println("Validation_3:Failed URL not contains" +currentUrl);
		}
		
		WebElement buttonIsDisabled=driver.findElement(By.xpath("//button[@type='submit']"));
		if(!buttonIsDisabled.isEnabled())
		{
			System.out.println("Validation_4:Pass Signup button is disabled ");
		}
		else
		{
			System.out.println("Validation_4:Failed Signup button is Enabled");
		}
		
		// Using Faker to generate dynamic user email and password
        Faker faker = new Faker();
        String userEmail = faker.internet().emailAddress();
        String userPassword = faker.internet().password();
		
		//String userEmail="breakoutroom4@gmail.com", userPassword="Break123$";
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("BreakoutRoom4");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(userEmail);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(userPassword);
		
		driver.findElement(By.xpath("//label[contains(text(),'Selenium')]//preceding::input[1]")).click();
		
		driver.findElement(By.xpath("//input[@value='Female']")).click();
		
		//select state
		WebElement state=driver.findElement(By.xpath("//select[@id='state']"));
		
		Select stateName=new Select(state);
		stateName.selectByVisibleText("Assam");
		
		WebElement hobbies=driver.findElement(By.xpath("//select[@id='hobbies']"));
		Select hobby=new Select(hobbies);
		hobby.selectByVisibleText("Playing");
		hobby.selectByVisibleText("Dancing");
		
		WebElement buttonEnabled=driver.findElement(By.xpath("//button[@type='submit']"));
		if(buttonEnabled.isEnabled())
		{
			System.out.println("Validation_5:Pass Signup Button is enbaled");
		}
		else
		{
			System.out.println("Validation_5:Failed Signup Button is disabled");
		}
		Thread.sleep(2000);
		buttonEnabled.click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Email']")).sendKeys(userEmail);
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys(userPassword);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//check whether cart button is present
		Thread.sleep(2000);
		WebElement cartButton=driver.findElement(By.xpath("//button[normalize-space()='Cart']"));
		if(cartButton.isDisplayed())
		{
			System.out.println("Validation_6:Pass Cart button is present");
		}
		else
		{
			System.out.println("Validation_6:Failed Cart button is not present");
		}
		
		//count the number of course avaiable in Learn Automation website
		List<WebElement> NumberOfCourse=(List<WebElement>) driver.findElement(By.xpath("//h2[@class='name']"));
		int count=NumberOfCourse.size();
        System.out.println("Number of products: " + count);

		driver.quit();	

	}

}
