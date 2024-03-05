package calendar;

import org.openqa.selenium.chrome.*;

import java.util.List;

import org.openqa.selenium.*;

public class HandleAutoSuggestions {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-autocomplete-feature-in.html");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[contains(@class,'autocomplete')]")).sendKeys("A");
		Thread.sleep(2000);
		
		List<WebElement> allSuggestions=driver.findElements(By.xpath("//ul[contains(@class,'autocomplete')]//div"));
		
		for(WebElement ele:allSuggestions)
		{
			String values=ele.getText();
			
			System.out.println(values);
			
			if(values.equalsIgnoreCase("Java"))
			{
				ele.click();
				break;
			}
		}
		
		
	}

}
