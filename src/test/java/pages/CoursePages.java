package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoursePages 
{
	WebDriver driver;
	
	public CoursePages(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By newNewCourse = By.xpath("//button[normalize-space()='Add New Course']");
	
	public void clickOnNewCourse()
	{
		driver.findElement(newNewCourse).click();
	}
	
	

}
