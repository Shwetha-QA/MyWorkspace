package testNgAssert;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGSoftAssert 
{
	@Test(groups ="E2E")
	public void Test1()
	{
		System.out.println("START");
		
		SoftAssert softAssert=new SoftAssert();
		
		String expectedErrorMessage = "User Name is not valid";
		
		String actualErrorMessage = "User name is Not valid";
		
		softAssert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error Message not matching as per requirement");
		
		softAssert.assertEquals(true, false);
		
		softAssert.assertEquals(10, 11);
		
		System.out.println("END");
		
		softAssert.assertAll();
	}
	
	@Test(groups ="E2E")
	public void Test2()
	{
		System.out.println("START");
		
		String ExpectedErrorMessage = "User Name is not valid";
		
		String ActualErrorMessage = "User name is Not Valid";
		
		Assert.assertTrue(ActualErrorMessage.equals(ExpectedErrorMessage), "Error Message not matching as per requirement");
		
		System.out.println("END");


	}

}
