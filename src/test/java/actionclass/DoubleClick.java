package actionclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import helper.Utility;

public class DoubleClick {

	public static void main(String[] args) throws InterruptedException 
	{
		//https://api.jquery.com/dblclick/
		
		WebDriver driver=Utility.startBrowser("https://api.jquery.com/dblclick/");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
		
		Thread.sleep(2000);
		
		Actions act=new Actions(driver);
		
		Thread.sleep(2000);
		
		act.doubleClick(driver.findElement(By.xpath("//span[text()='Double click the block']//parent::body/div"))).perform();
		
		driver.quit();
		
		

	}

}
