package class44_assignment;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import helper.Utility;

public class AssignmentFindSocialMedia 
{

	public static void main(String[] args) 
	{
		WebDriver driver=Utility.startBrowser("https://freelance-learn-automation.vercel.app/login");
		
		List<WebElement> allSocialMediaLinks=driver.findElements(By.xpath("//div[@class='social-btns']/./a"));
		
		System.out.println(allSocialMediaLinks);
		
		allSocialMediaLinks.get(2).click();
				
		String parentWindow=driver.getWindowHandle();
		
		System.out.println("Parent Window: "+parentWindow);
				
		Set<String> allWindow=driver.getWindowHandles();
		
		for(String handle:allWindow)
		{
			System.out.println("Handles: "+handle);
			
			if(!parentWindow.equalsIgnoreCase(handle))
			{
				driver.switchTo().window(handle);
				
				if(driver.getTitle().contains("Automation"))
				{
					System.out.println("Switched to Child Window");
				}
			}
		}
		
	}

}
