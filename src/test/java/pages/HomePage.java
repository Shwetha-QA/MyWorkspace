package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage 
{
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By welcomeMessage = By.xpath("//h4[@class='welcomeMessage']");
	
	By manageOptions = By.xpath("//span[normalize-space()='Manage']");
	
	By manageCourses = By.xpath("//a[normalize-space()='Manage Courses']");
	
	By manageCategories = By.xpath("//a[normalize-space()='Manage Categories']");
	
	
	public String getWelcomeMessage()
	{
		String welcomeText=driver.findElement(welcomeMessage).getText();
		
		return welcomeText;
	}
	
	public CoursePages clickOnManageCourses()
	{
		driver.findElement(manageOptions).click();
		driver.findElement(manageCourses).click();
		
		CoursePages course = new CoursePages(driver);
		
		return course;
		
	}
	
	public CategoriesPages clickOnManageCategories()
	{
		driver.findElement(manageOptions).click();
		driver.findElement(manageCategories).click();
		
		CategoriesPages category = new CategoriesPages();
		return category;
	}
}
