package mypractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Utility;

/*
 * Login to: https://freelance-learn-automation.vercel.app/login
 * Mouse hover to Manage
 * Click on Manage category
 * Click on Add New category
 * Enter category name "AWS"
 * Verify AWS category created
 * Open https://freelance-learn-automation.vercel.app/login and verify AWS is listed in register page under category
 * Now click on update button of AWS category
 * Update the new to GCP
 * Verify category name updated to GCP
 * Click on delete button of GCP category
 * Click on delete option
 * Verify GCP category deleted
 * Open https://freelance-learn-automation.vercel.app/login and verify GCP is not listed in register page under category
 * quite
 */

public class BreakoutTask {

	public static void main(String[] args) 
	{
		WebDriver driver=Utility.startBrowser("https://freelance-learn-automation.vercel.app/login");
		
		WebElement emailId=driver.findElement(By.xpath("//input[@id='email1']"));
				
		Utility.highlightAndType(driver, emailId, "admin@email.com");
		
		WebElement password=driver.findElement(By.xpath("//input[@id='password1']"));
				
		Utility.highlightAndType(driver, password, "admin@123");
		
		WebElement signInButton=driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
				
		Utility.highlightAndClickElement(driver, signInButton);
		
		System.out.println("Step1:Pass Login Sucessfull");
		
		
		
		
		
		
		
	}

}
