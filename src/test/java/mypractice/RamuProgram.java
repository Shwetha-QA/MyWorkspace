package mypractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RamuProgram 
{

    WebDriver driver;

    @BeforeMethod
    public void setUp() 
    {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testSearch()
    {
        WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement searchBar = expWait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        searchBar.sendKeys("India");
        searchBar.sendKeys(Keys.ENTER);

        searchBar = expWait.until(ExpectedConditions.elementToBeClickable(By.name("q")));

        try
        {
            // Check if the element is still displayed
            Assert.assertTrue(searchBar.isDisplayed(), "Search bar is not displayed");
        } catch (StaleElementReferenceException e) 
        {
           
            searchBar = expWait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
            Assert.assertTrue(searchBar.isDisplayed(), "Search bar is not displayed");
          
        }

      
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
