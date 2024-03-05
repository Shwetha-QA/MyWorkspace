package breakoutTaskClass_60;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import helper.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class TestDataEntry 
{
    WebDriver driver;
    
    @Parameters("BrowserName")
    @BeforeClass
	public void setUp(@Optional("Chrome") String browser)
	{
    	System.out.println("****Running Before Class - Setting the Browser****");
    	
		driver=Utility.startBrowser(browser, "https://freelance-learn-automation.vercel.app/signup");
		
		System.out.println("****Running Before Class - Browser is Up and running****");
	}
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("****Running After Class - Closing the Browser****");
		
		driver.quit();
		
		System.out.println("****Running After Class - Browser and Application Closed****");
	}
	
	@Test(priority=1)
	public void verifyUrl()
	{
		SoftAssert softAssert=new SoftAssert();
		
		String URL=driver.getCurrentUrl();
		
		softAssert.assertTrue(URL.contains("signup"),"URL does not contain signup text");
		
		softAssert.assertAll();
		
	}
	
	@Test(priority=2)
	public void signUpDisabled()
	{
		SoftAssert softAssert=new SoftAssert();
		
		 WebElement signUpButton = driver.findElement(By.xpath("//button[normalize-space()='Sign up']"));

		 softAssert.assertFalse(signUpButton.isEnabled(), "Sign up Button is disabled"); // Check if the button is disabled
	      
	     softAssert.assertAll();
	}
	

    @Test(priority=3, dataProvider = "LoginData", dataProviderClass = TestExcelDataProvider.class)
    public void signUpPage(String username, String emailId, String password, String interest, String gender, String state, String hobbies)
    {
    		WebElement nameInput = driver.findElement(By.xpath("//input[@id='name']"));
    		nameInput.sendKeys(username);
    		
    		WebElement emailInput = driver.findElement(By.xpath("//input[@id='email']"));
            emailInput.sendKeys(emailId);
            
            WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
            passwordInput.sendKeys(password);
            
            try 
            {
            	WebElement interestCheckbox = driver.findElement(By.xpath("//label[normalize-space()='" + interest + "']"));
                interestCheckbox.click();	
			} 
            catch (Exception e)
            {
            	Assert.fail("Step Failed: Interests named " + interest + " is not available");
			}
            
            WebElement radioButton=driver.findElement(By.xpath("//input[@value='"+gender+"']"));
            radioButton.click();
            Utility.AssertTrueOrFalse(radioButton.isSelected(), "Radio button is selected", "Radio button is not selected");
            
           // By state1 = By.id("state");
           // By hobbies1 = By.id("hobbies");
            
           driver.findElement(By.xpath("//button[normalize-space()='Sign up']")).click();
        } 
    }

   


