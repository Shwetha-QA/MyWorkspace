package parallelTest;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ParallelTest2 
{
	@Test
	public void test4()
	{
		Reporter.log("Thread ID: " +Thread.currentThread().getId(), true);
		Reporter.log("Executed Test4",true);
	}
	
	@Test
	public void test5()
	{
		Reporter.log("Thread ID: " +Thread.currentThread().getId(), true);
		Reporter.log("Executed Test5",true);
	}
	
	@Test
	public void test6()
	{
		Reporter.log("Thread ID: " +Thread.currentThread().getId(), true);
		Reporter.log("Executed Test6",true);
	}
}

