package breakoutroom2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Utility;

/* 1. Login to https://freelance-learn-automation.vercel.app/login as admin credentials
 * 2. Verify number of courses on home page should be >4
 * 3. Capture Cypress course price and click to add cart
 * 4. Capture Selenium course price and click to add cart
 * 5. Verify count value should be 2
 * 6. Click on cart
 * 7. Verify Total price value should be total of course Price1 + Price2
 * 8. Click on Enroll now
 * 9. Enter Address and Phone Number
 * 10. Click on Enroll now
 * 11. Capture Order Id and should not be null.
 * 12. Delete one of the course and check cart total price
 * 13. Again add course and verify total price
 * 14. Remove both the course from cart and verify total price should be zero
 * 15. Quit
 */

public class BreakoutRoom2 {

	public static void main(String[] args) 
	{
		WebDriver driver=Utility.startBrowser("https://freelance-learn-automation.vercel.app/login");
		
		//1. Login to https://freelance-learn-automation.vercel.app/login as admin credentials
		driver.findElement(By.id("email1")).sendKeys("admin@email.com");
		
		driver.findElement(By.id("password1")).sendKeys("admin@123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//2. Verify number of courses on home page should be >4
		double totalCoursesCount=driver.findElements(By.xpath("//h2[@class='name']")).size();
		
		if(totalCoursesCount>=4)
		{
			System.out.println("Test_02 Pass: Number of Courses on Home Page is greater than 4: "+totalCoursesCount);
		}
		
		//3. Capture Cypress course price and click to add cart
		String courseCypress=driver.findElement(By.xpath("//div[@class='home-container']//div[2]/div/h2[text()=\"Cypress\"]/../../span[contains(text(),'Price')]/b")).getText();
		
		double cypressCoursePrice=Integer.parseInt(courseCypress.substring(1));
		
		System.out.println("Cypress Course Price is: "+cypressCoursePrice);
		
		driver.findElement(By.xpath("//div[@class='home-container']//div[1]//div[2]//button[1]")).click();
		
		//4. Capture Selenium course price and click to add cart
		String courseSelenium=driver.findElement(By.xpath("//div[@class='home-container']/div[2]//div[2]/div/h2/../../span/b")).getText();
		
		double seleniumCoursePrice=Integer.parseInt(courseSelenium.substring(1));
		
		System.out.println("Selenium Course Price is: "+seleniumCoursePrice);
		
		driver.findElement(By.xpath("//div[@class='home-container']//div[2]//div[2]//button[1]")).click();
		
		//5. Verify count value should be 2
		String cartCount=driver.findElement(By.xpath("//button[@class='cartBtn']/./span[text()='2']")).getText();
		
		double expectedCartCount=Integer.parseInt(cartCount);
		
		double actualCartCount=2;
		
		if(actualCartCount==expectedCartCount)
		{
			System.out.println("Test_05 Pass: Expected Cart Count is 2 :"+actualCartCount);
		}
		else
		{
			System.out.println("Test_05 Fail: Expected Cart Count is not 2 :"+actualCartCount);
		}
		
		//6. Click on cart
		driver.findElement(By.xpath("//button[@class='cartBtn']")).click();
		
		//7. Verify Total price value should be total of course Price1 + Price2
		String totalPrice=driver.findElement(By.xpath("//div[@class='container-child']//h3[1]")).getText();
		
		System.out.println("The total cart value is: "+totalPrice);
				
		double totalPriceInCart=Integer.parseInt(totalPrice.substring(14,19));
		
		double totalOfCourse=cypressCoursePrice + seleniumCoursePrice;
		
		if(totalPriceInCart==totalOfCourse)
		{
			System.out.println("Test_07 Pass: Verified Total price value should be total of course Price1 + Price2: "+totalPriceInCart);
		}
		else
		{
			System.out.println("Test_07 Fail: Verified Total price value is not equal to total of course Price1 + Price2 :"+totalPriceInCart);
		}
		
		//8. Click on Enroll now
		driver.findElement(By.xpath("//button[normalize-space()='Enroll Now']")).click();
		
		//9. Enter Address and Phone Number
		driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("Bangalore");
		
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("0123456789");
		
		//10. Click on Enroll now
		driver.findElement(By.xpath("//button[@class='action-btn']")).click();
		
		//11. Capture Order Id and should not be null.
		String orderId= driver.findElement(By.xpath("//h4[@class='uniqueId']")).getText();
		
		System.out.println("Your Order ID is:" +orderId);
		
		String[] arr=orderId.split("-");
		{
			if(arr[1]!=null)
			{
				System.out.println("Test_11 Pass: Order ID is not Null");
			}
			else
			{
				System.out.println("Test_11 Fail: Order ID is Null");
			}
			
		}
		
		//12. Close Enroll now button
		driver.findElement(By.xpath("//button[@aria-label='Close']")).click();		
		
		// 8. Delete Cypress course from cart and check the cart total price after deleting course
		//driver.findElement(By.xpath("//div[@class='cart-container']//div//div[2]//div/./h2[contains(text(),'Cypress')]/../../button[contains(text(),'Remove from Cart')]")).click();
		
		//driver.findElement(By.xpath("//div[@class='cart-container']//div//div[2]//div/./h2[contains(text(),'Selenium')]/../../button[contains(text(),'Remove from Cart')]")).click();
		
		driver.quit();

	}

}
