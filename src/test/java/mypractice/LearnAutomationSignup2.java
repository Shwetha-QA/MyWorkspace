package mypractice;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LearnAutomationSignup2 {

	public static void main(String[] args) throws InterruptedException 
	{

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://freelance-learn-automation.vercel.app/signup");
		Thread.sleep(5000);
		
		
		Select state=new Select(driver.findElement(By.id("state")));
		
		state.selectByVisibleText("Goa");
		
		String stateName=state.getFirstSelectedOption().getText();
		
		if(stateName.contains("Goa"))
		{
			System.out.println("Dropdown is working as expected");
		}
		else
		{
			System.out.println("Dropdown is not working as expected");
		}
		
		Select hobbies=new Select(driver.findElement(By.id("hobbies")));
		
		hobbies.selectByVisibleText("Reading");
		hobbies.selectByVisibleText("Playing");
		hobbies.selectByVisibleText("Dancing");
		hobbies.selectByVisibleText("Singing");
		
		hobbies.deselectByVisibleText("Playing");
		

	}

}
