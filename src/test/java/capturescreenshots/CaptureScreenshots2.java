package capturescreenshots;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import helper.Utility;

public class CaptureScreenshots2 {

	public static void main(String[] args) throws IOException
	{
		WebDriver driver=Utility.startBrowser("https://www.selenium.dev/");
		
		Utility.captureScreenshot(driver);
	
		
		//driver.quit();	

	}

}
