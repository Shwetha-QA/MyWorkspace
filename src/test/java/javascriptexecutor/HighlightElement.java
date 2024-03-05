package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Utility;

public class HighlightElement {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=Utility.startBrowser("https://freelance-learn-automation.vercel.app/login");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		WebElement element=driver.findElement(By.xpath("//input[@id='email1']"));
		
		driver.findElement(By.xpath("//input[@id='password1']")).sendKeys("ssss");
		
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 3px solid red;');", element);
		
		Utility.captureScreenshot(driver);
		
		Thread.sleep(1000);
		
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid black;');", element);
		
		element.clear();
		
		element.sendKeys("Selenium");


	}

}
