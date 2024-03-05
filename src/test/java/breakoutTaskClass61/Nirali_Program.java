package breakoutTaskClass61;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import helper.Utility;


public class Nirali_Program {
    WebDriver driver;
    SoftAssert Sassert;

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Parameters("BrowserName")
    @BeforeMethod
    public void setup(@Optional("Chrome") String browser) {
        Sassert = new SoftAssert();
        Reporter.log("Thread id " + Thread.currentThread().getId(), true);
        System.out.println("*****Running Before class - Setting up Browser******");
        driver = Utility.startBrowser(browser, "https://freelance-learn-automation.vercel.app/signup");
        System.out.println("*****Running Before class - Setting up Browser******");

    }

    @Test(priority = 1)
    public void Signuppage() 
    {

        Assert.assertTrue(driver.getCurrentUrl().contains("signup"), "URL does not contain 'signup'");
    }

    @Test(priority = 2)
    public void checksignUpbutton() 
    {

        WebElement signUpButton = driver.findElement(By.xpath("//*[@class='submit-btn']"));
        Assert.assertFalse(signUpButton.isEnabled(), "Sign Up button should not be enabled");
    }

    @Test(priority = 3, dataProvider = "Signup")
    public void SignupPage(String Name, String email, String Password, String Interests, String Gender, String State, String Hobbies) {
        WebElement nameInput = driver.findElement(By.id("name"));
        nameInput.sendKeys(Name);

        WebElement emailInput = driver.findElement(By.xpath("//input[@id='email']"));
        long data = new Faker().number().randomNumber();
        String[] arr = email.split("@");
        System.out.println("New Email " + arr[0] + String.valueOf(data) + "@" + arr[1]);
        emailInput.sendKeys(arr[0] + String.valueOf(data) + "@" + arr[1]);

        driver.findElement(By.id("password")).sendKeys(Password);

        driver.findElement(By.xpath("//label[text()='" + Interests + "']/preceding::input[1]")).click();

        driver.findElement(By.xpath("//label[text()='" + Gender + "']/preceding::input[1]")).click();

        WebElement state1 = driver.findElement(By.name("state"));
        Select statesel = new Select(state1);
        statesel.selectByVisibleText(State);

        WebElement hobbies = driver.findElement(By.id("hobbies"));
        Select hobby = new Select(hobbies);
        hobby.selectByVisibleText(Hobbies);

        WebElement signUpButton = driver.findElement(By.xpath("//button[text()='Sign up']"));
        Assert.assertTrue(signUpButton.isEnabled(), "Sign Up button is not enabled");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton));

        signUpButton.click();

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Signup successfully, Please login!')]")));
        Assert.assertTrue(successMessage.isDisplayed(), "Signup success message is not displayed");

        Sassert.assertAll();
    }

    @DataProvider(name = "Signup")
    public Object[][] SignupPagedata() throws IOException 
    {
        XSSFWorkbook wbook = new XSSFWorkbook(new FileInputStream(new File("./TestData/newTestData.xlsx")));
        int rowcount = wbook.getSheet("Sheet1").getPhysicalNumberOfRows();
        int colcount = wbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells();
        Object[][] arr = new Object[rowcount - 1][colcount];

        for (int i = 1; i < rowcount; i++)
        {
            for (int j = 0; j < colcount; j++) 
            {
                String value = "";
                CellType type = wbook.getSheet("Sheet1").getRow(i).getCell(j).getCellType();
                if (type == CellType.NUMERIC)
                {
                    value = String.valueOf(wbook.getSheet("Sheet1").getRow(i).getCell(j).getNumericCellValue());
                } else if (type == CellType.STRING) {
                    value = wbook.getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();
                } else if (type == CellType.BOOLEAN) {
                    value = String.valueOf(wbook.getSheet("Sheet1").getRow(i).getCell(j).getBooleanCellValue());
                } else if (type == CellType.BLANK) {
                    value = "";
                }
                arr[i - 1][j] = value;
            }
        }
        return arr;
    }
}
