package helper;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class Utility 
{
	WebDriver driver;
	@DataProvider(name ="excel-data")
	public void readData() throws IOException
	{

	XSSFWorkbook wb=new XSSFWorkbook(new FileInputStream(new File("./TestData/BreakoutTaskTestData.xlsx")));
	
	int rowCount=wb.getSheet("user_details").getPhysicalNumberOfRows();
	
	int column=wb.getSheet("user_details").getRow(0).getPhysicalNumberOfCells();
	
	Object [][] arr=new Object[rowCount-1][column];
	
	for(int i=1;i<rowCount;i++)
	{
		for(int j=0;j<column;j++)
		{
			arr[i-1][j]=wb.getSheet("user_details").getRow(i).getCell(j).getStringCellValue();
			
			System.out.print(arr[i-1][j]);
			
		}
		System.out.println("*************************");
	}

	}
	
	public static WebElement getElement(WebDriver driver,By locator)
	{
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element=	wait.until(ExpectedConditions.elementToBeClickable(locator));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
		highlightElement(driver, element);
		
		return element;
	}	
	

	public static void highlightElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 3px solid red;');", element);
		
		Utility.sleep(1);
		
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid black;');", element);
			
	}	
	
	public static void sleep(int seconds)
	{
		try 
		{
			Thread.sleep(seconds*1000);
			
		} catch (InterruptedException e) 
		{
			
		}
	}

	public static void type(WebDriver driver,By locator,String value)
	{
		WebElement element=driver.findElement(locator);
		try 
		{
			element.sendKeys(value);
			
		} catch (Exception e) 
		{
			System.out.println("Not able to type - Trying values using JavaScriptExecutor");
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].value=arguments[1]",element,value);
		}
		
	}
	
	public static void highlightAndType(WebDriver driver,WebElement element,String value)
	{
		try 
		{
			highlightElement(driver, element);
			element.sendKeys(value);
			
		} catch (Exception e) 
		{
			System.out.println("Not able to type - Trying values using JavaScriptExecutor");
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].value=arguments[1]",element,value);
		}
		
	}
	
	public static void loginAsAdmin(WebDriver driver, WebElement username, WebElement password, WebElement signInButton)
	{		
		highlightAndType(driver, username, "admin@email.com");
				
		highlightAndType(driver, password, "admin@123");
				
		highlightAndClickElement(driver, signInButton);
		
		System.out.println("Login Successfull");
		System.out.println("*****************");
	}
	
	public static void type(WebDriver driver,WebElement element,String value)
	{
		try 
		{
			element.sendKeys(value);
			
		} catch (Exception e) 
		{
			System.out.println("Not able to type - Trying values using JavaScriptExecutor");
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].value=arguments[1]",element,value);
		}
		
	}
	
	public static void clickElement(WebDriver driver,By locator)
	{
		WebElement ele=driver.findElement(locator);
		try 
		{
			ele.click();
			
		} catch (Exception e) 
		{
			try 
			{
				System.out.println("Normal Click Failed :Trying Click Using JavaScriptExecutor");
				
				JavascriptExecutor js=(JavascriptExecutor)driver;
				
				js.executeScript("arguments[0].click()", ele);
				
			} catch (Exception e1) 
			{
				
			}
		}
		
	}
	
	
	  public static void highlightAndClickElement(WebDriver driver,WebElement ele)
	  { try { highlightElement(driver, ele); ele.click();
	  
	  } catch (Exception e) { try { System.out.
	  println("Normal Click Failed :Trying Click Using JavaScriptExecutor");
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  
	  js.executeScript("arguments[0].click()", ele);
	  
	  } catch (Exception e1) {
	  
	  } } }
	 
	public static void clickElement(WebDriver driver, WebElement ele) 
	{

		try {
			ele.click();

		} catch (Exception e) {
			try {
				System.out.println("JS Click Failed :Trying Click Using Actions Class Click");

				Actions act = new Actions(driver);

				act.moveToElement(ele).click().build().perform();

			} catch (Exception e1) {

				System.out.println("Normal Click Failed :Trying Click Using JavaScriptExecutor");

				JavascriptExecutor js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].click()", ele);
			}

		}

	}
	/*
	 * public static void clickElement(WebDriver driver,WebElement ele) { try {
	 * ele.click();
	 * 
	 * } catch (Exception e) { try { System.out.
	 * println("Normal Click Failed :Trying Click Using JavaScriptExecutor");
	 * 
	 * JavascriptExecutor js=(JavascriptExecutor)driver;
	 * 
	 * js.executeScript("arguments[0].click()", ele);
	 * 
	 * } catch (Exception e1) {
	 * 
	 * } } }
	 */
	
	public static String captureCurrentDateAndTime()
	{
		String date=new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());
		
		return date;
	}
	
	public static void captureScreenshot(WebDriver driver) 
	{
		try 
		{
			FileHandler.copy(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File("./Screenshots/Screenshot_"+Utility.captureCurrentDateAndTime()+".png"));
			
			System.out.println("Screenshot captured in Screenshots directory");
			
		} catch (WebDriverException e) 
		{
			System.out.println("Could not take the screenshot" +e.getMessage());
			
		} catch (IOException e) 
		{
			System.out.println("Could not save the screenshot" +e.getMessage());
		}
	}
	
	public static void captureScreenshotOfWebElement(WebDriver driver,WebElement ele)
	{
		
		try 
		{
			FileHandler.copy(ele.getScreenshotAs(OutputType.FILE), new File("./Screenshots/Screenshot_"+Utility.captureCurrentDateAndTime()+".png"));
			
			System.out.println("Screenshot captured for webelement in Screenshots directory");
			
		} catch (WebDriverException e) 
		{
			System.out.println("Could not take the screenshot "+e.getMessage());
			
		} catch (IOException e) 
		{
			System.out.println("Could not save the screenshot "+e.getMessage());
		}

	}
	
	public static void selectValueFromList(WebDriver driver, String xpathValue, String value)
	{
		List<WebElement> allValues=driver.findElements(By.xpath(xpathValue));
		
		for(WebElement ele:allValues)
		{
			if(ele.getText().equalsIgnoreCase(value))
			{
				ele.click();
				break;
			}
		}
		
	}
	
	public static WebDriver startBrowser(String appURL) 
	{
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(15));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(appURL);
		
		return driver;
	}
	
	public static WebDriver startBrowser(String browser, String appURL) 
	{
		WebDriver driver=null;
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("FireFox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Safari"))
		{
			driver=new SafariDriver();
		}
		else
		{
			System.out.println("Sorry, Currently We dont support that Browser"+browser);
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(15));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(appURL);
		
		return driver;
	}
	
	public static void AssertTrueOrFalse(boolean condition, String messageIfTrue, String messageIfFalse)
	{
        if (condition) 
        {
            Assert.assertTrue(true, messageIfTrue);
        } else 
        {
            Assert.assertTrue(false, messageIfFalse);
        }

    }

}
