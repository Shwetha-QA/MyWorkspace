package parallelTest;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ParallelTest 
{
	@Test
	public void test1()
	{
		Reporter.log("Thread ID: " +Thread.currentThread().getId(), true);
		Reporter.log("Executed Test1",true);
	}
	
	@Test
	public void test2()
	{
		Reporter.log("Thread ID: " +Thread.currentThread().getId(), true);
		Reporter.log("Executed Test2",true);
	}
	
	@Test
	public void test3()
	{
		Reporter.log("Thread ID: " +Thread.currentThread().getId(), true);
		Reporter.log("Executed Test3",true);
	}
}

