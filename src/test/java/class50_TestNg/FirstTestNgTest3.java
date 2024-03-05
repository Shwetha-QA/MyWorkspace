package class50_TestNg;

import org.testng.annotations.Test;

public class FirstTestNgTest3 
{
	@Test(priority = 1, groups="Smoke")
	public void logintest()
	{
		System.out.println("login done");
	}
	
	@Test(priority = 2, groups="Smoke")
	public void createcourses()
	{
		System.out.println("course created");
	}
	
	
	@Test(priority = 2, groups="Smoke")
	public void createcategory()
	{
		System.out.println("category created");
	}
	
	@Test(priority = 4, groups="Smoke")
	public void deletecategory()
	{
		System.out.println("category deleted");
	}
	
	@Test(priority = 5, groups="Smoke")
	public void deletecourses()
	{
		System.out.println("courses deleted");
	}

	
	@Test(priority = 6, groups="Smoke")
	public void logout()
	{
		System.out.println("logout done");
	}
}

