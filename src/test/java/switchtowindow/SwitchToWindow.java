package switchtowindow;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import helper.Utility;

public class SwitchToWindow {

	public static void main(String[] args) throws InterruptedException 
	{
		
		WebDriver driver=Utility.startBrowser("https://freelance-learn-automation.vercel.app/login");
		
		driver.findElements(By.xpath("//a[contains(@href,'facebook')]")).get(0).click();
		
		String parentWindow=driver.getWindowHandle();
		
		System.out.println("Parent Handle Window : "+parentWindow);
		
		Set<String> allWindows=driver.getWindowHandles();
		
		for(String handle:allWindows)
		{
			System.out.println("Handle Are: "+handle);
			
			if(!parentWindow.equalsIgnoreCase(handle))
			{
				driver.switchTo().window(handle);
				
				if(driver.getTitle().contains("Facebook"))
				{
					System.out.println("Switched to child tab");
				}
				
				driver.findElement(By.xpath("//input[@id=':r5:']")).sendKeys("shwethas007@gmail.com");
				
				driver.findElement(By.xpath("//input[@id=':r7:']")).sendKeys("Thanvi123$");
				
				driver.findElement(By.xpath("//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft x1j85h84'][normalize-space()='Log in']")).click();
				
				if(driver.getTitle().contains("facebook"))
				{
					System.out.println("Facebook title validation passed");
				}

			}
			
		}
		driver.switchTo().window(parentWindow);
		
		if(driver.getTitle().contains("Course"))
		{
			System.out.println("Switched to Parent Window");
		}
		else
		{
			System.out.println("Sorry, try again");
		}
		
		driver.quit();
	}

}
