package seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGridLT {

	public static void main(String[] args) throws MalformedURLException
	{
		ChromeOptions browserOptions = new ChromeOptions();
		
		browserOptions.setPlatformName("Windows 11");
		
		browserOptions.setBrowserVersion("121.0");
		
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		
		ltOptions.put("username", "shwethas.aus");
		
		ltOptions.put("accessKey", "kTN8ReClFDnXySwnPVRbsQwE02C4OZwyko8rESKCHq38WOYGHL");
		
		//ltOptions.put("project", "Untitled");
		
		ltOptions.put("w3c", true);
		
		//ltOptions.put("plugin", "java-java");
		
		browserOptions.setCapability("LT:Options", ltOptions);
		
		URL hubURL=new URL("https://shwethas.aus:kTN8ReClFDnXySwnPVRbsQwE02C4OZwyko8rESKCHq38WOYGHL@hub.lambdatest.com/wd/hub");
		
		WebDriver driver=new RemoteWebDriver(hubURL,browserOptions);
		
		driver.get("https://www.google.com.au/");
		
		driver.findElement(By.name("q")).sendKeys("Australia");
		
		driver.quit();

	}

}
