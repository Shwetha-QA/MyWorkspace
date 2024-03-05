package calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import helper.Utility;
import java.util.List;

public class FirstCalendarAssignment {

    public static void main(String[] args) throws InterruptedException
    {
    	WebDriver driver= Utility.startBrowser("Chrome", "https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
        Thread.sleep(2000);

        driver.findElement(By.id("datepicker")).click();
        Thread.sleep(2000);

        WebElement year = driver.findElement(By.xpath("//span[contains(@class,'ui-datepicker-year')]"));
        
        WebElement month = driver.findElement(By.xpath("//span[contains(@class,'ui-datepicker-month')]"));

        String yearText = year.getText();
        
        String monthText = month.getText();

        System.out.println("The year is: " + yearText);
        
        System.out.println("The month is: " + monthText);

        while (!(yearText.equals("2025") && monthText.equals("February"))) {
        	
            List<WebElement> nextButtons = driver.findElements(By.xpath("//span[contains(text(),'Next')]"));

            for (WebElement nextButton : nextButtons)
            {
                nextButton.click();

                yearText = driver.findElement(By.xpath("//span[contains(@class,'ui-datepicker-year')]")).getText();
                
                monthText = driver.findElement(By.xpath("//span[contains(@class,'ui-datepicker-month')]")).getText();

                System.out.println("The year is: " + yearText);
                
                System.out.println("The month is: " + monthText);

                if (yearText.equals("2025") && monthText.equals("February")) 
                {
                	driver.findElement(By.xpath("//a[normalize-space()='14']")).click();
                    break;
                }
            }
        }

      //  driver.findElement(By.xpath("//a[normalize-space()='14']")).click();
    }
}
