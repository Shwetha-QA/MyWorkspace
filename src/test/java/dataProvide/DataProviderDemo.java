package dataProvide;

import org.testng.annotations.Test;

public class DataProviderDemo 
{
	
	@Test(dataProvider = "logintest" ,dataProviderClass = CustomDataProvider.class )
	public void test1(String name, String password)
	{
		System.out.println("Test 1 Executed " +name +"  "+password);
	}

}
