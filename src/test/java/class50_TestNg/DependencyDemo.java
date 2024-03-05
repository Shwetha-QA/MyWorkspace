package class50_TestNg;

import org.testng.annotations.Test;

public class DependencyDemo 
{
	@Test(groups="DemoGroup")
	public void LoginTest()
	{
		System.out.println(10/0);
		System.out.println("Login Done");
	}
	
	@Test(dependsOnMethods="LoginTest", groups="DemoGroup")
	public void LogoutTest()
	{
		System.out.println("Logout Done");
	}

}
