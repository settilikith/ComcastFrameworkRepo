package test;

import org.testng.annotations.Test;

public class OrderTest {
	@Test(invocationCount = 5 )
	public void createordertest()
	{
		System.out.println("Execute createordertest ==> 123");
	}
	//@Test(dependsOnMethods="createordertest")
	@Test(enabled=false)
	public void billinganordertest()
	{
		System.out.println("Execute billinganordertest==>123");
	}

}
