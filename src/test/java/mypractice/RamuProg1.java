package mypractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RamuProg1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testSearch() {
        WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement searchBar = expWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.name("q"))));
        searchBar.sendKeys("India");
        searchBar.sendKeys(Keys.ENTER);

        searchBar = expWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.name("q"))));

        Assert.assertTrue(searchBar.isDisplayed(), "Search bar is not displayed");

        // Validate search results
        List<WebElement> searchResults = driver.findElements(By.cssSelector("div.g")); 
        Assert.assertFalse(searchResults.isEmpty(), "No search results found");

        // Validate the title
        String expectedTitle = "India - Google Search"; // Adjust expected title as needed
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match");

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
