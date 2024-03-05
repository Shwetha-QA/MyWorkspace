package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By user = By.xpath("//input[@id='email1']");
	private By pass = By.xpath("//input[@id='password1']");
	private By login = By.xpath("//button[normalize-space()='Sign in']");
	
	public HomePage loginToApplicationAsAdmin(String userName, String password)
	{
		driver.findElement(user).sendKeys(userName);
		driver.findElement(pass).sendKeys(password);
		driver.findElement(login).click();
		
		HomePage home = new HomePage(driver);
		
		return home;
	}
}
