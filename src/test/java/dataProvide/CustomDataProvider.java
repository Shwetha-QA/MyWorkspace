package dataProvide;

import org.testng.annotations.DataProvider;

public class CustomDataProvider 
{
	@DataProvider(name = "logintest")
	public static Object[][] getData()
	{
		System.out.println("Creating Test Data");
		Object [][]arr = new Object [2][2];
		arr[0][0] = "Shwetha";
		arr[0][1] = "Sushruth";
		
		arr[1][0] = "Thanvi";
		arr[1][1] = "Sushruth";
		System.out.println("Test Data Created");
		return arr;
	}

}
