package class_32assignment;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LaunchLearnAutomation4 
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
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(5000);

		//WebElement addToCart=driver.findElement(By.xpath("//h2[text()='DataBase Testing']/../../button[text()='Add to Cart']"));
		
		//WebElement countProduct=driver.findElement(By.xpath("h2[@class='name']"));
		//Thread.sleep(5000);
		//Object countProd = len(countProduct);
		//Thread.sleep(5000);
		//System.out.println(countProd);
		
		//addToCart.click();
		//driver.quit();
		By productLocator = By.xpath("//h2[@class='name']");

        // Find all elements matching the product locator
        Thread.sleep(5000); // Note: Thread.sleep is not recommended for waiting, consider using WebDriverWait
        java.util.List<WebElement> productElements = driver.findElements(productLocator);

        // Get the count of products
        int productCount = productElements.size();

        // Print the count
        System.out.println("Number of products: " + productCount);
		
	}

	

}
