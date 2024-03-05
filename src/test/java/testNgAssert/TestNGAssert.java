package testNgAssert;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssert 
{
	@Test(groups ="E2E")
	public void Test1()
	{
		System.out.println("START");
		
		String expectedErrorMessage = "User Name is not valid";
		
		String actualErrorMessage = "User Name is not valid";
		
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error Message not matching as per requirement");
		
		System.out.println("END");
	}
	
	@Test(groups ="E2E")
	public void Test2()
	{
		System.out.println("START");
		
		String expectedErrorMessage = "User Name is not valid";
		
		String actualErrorMessage = "User name is Not Valid";
		
		Assert.assertTrue(actualErrorMessage.equals(expectedErrorMessage), "Error Message not matching as per requirement");
		
		System.out.println("END");


	}

}
