package POM;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import helper.Utility;
import pages.CategoriesPages;
import pages.CoursePages;
import pages.HomePage;
import pages.LoginPage;

public class PageObjectModel
{
	@Test
	public void loginTest()
	{
		WebDriver driver=Utility.startBrowser("Chrome", "https://freelance-learn-automation.vercel.app/login");
		
		LoginPage login = new LoginPage(driver);
		
		HomePage home=login.loginToApplicationAsAdmin("admin@email.com", "admin@123");
		
		Assert.assertTrue(home.getWelcomeMessage().contains("Welcome"), "Login Failed");
		
		CoursePages course=home.clickOnManageCourses();
		
		course.clickOnNewCourse();
	}

}
