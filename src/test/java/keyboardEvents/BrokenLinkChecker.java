package keyboardEvents;

import org.openqa.selenium.WebDriver;

import helper.Utility;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BrokenLinkChecker {

	public static void main(String[] args) 
	{
		// https://www.naukri.com/ 
		
		/*
		 * Response resp=RestAssured.get("https://www.naukri.com/");
		 * 
		 * int code=resp.statusCode();
		 */
		int code=RestAssured.get("https://www.naukri.com/").statusCode();
		System.out.println(code);
		

	}

}
