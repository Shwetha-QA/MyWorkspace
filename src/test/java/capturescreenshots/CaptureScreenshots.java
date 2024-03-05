package capturescreenshots;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import helper.Utility;

public class CaptureScreenshots {

	public static void main(String[] args) throws IOException
	{
		WebDriver driver=Utility.startBrowser("https://www.selenium.dev/");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		File destination=new File("./Screenshots/Screenshot1.png");
		
		FileHandler.copy(src, destination);
		
		//driver.quit();	

	}

}
