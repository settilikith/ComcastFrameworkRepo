package practice;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Sample {
	@Test
	public void homepageTest(Method mtd)
	{
		System.out.println(mtd.getName()+"Test start");
		SoftAssert assetob=new SoftAssert();
		System.out.println("Step-1");
		System.out.println("Step-2");
		Assert.assertEquals("Home", "Home");
		System.out.println("Step-3");
		Assert.assertEquals("Home-CRM", "Home-CRM");
		System.out.println("Step-4");
		System.out.println(mtd.getName()+"Test End");
	}
	@Test
	public void verifyhometest(Method mtd)
	{
		System.out.println(mtd.getName()+"Teststart");
		SoftAssert assertob =new SoftAssert();
		System.out.println("Step-1");
		System.out.println("Step-2");
		Assert.assertTrue(true);
		System.out.println("Step-3");
		System.out.println("Step-4");
		System.out.println(mtd.getName()+"Testend");
		
	}

}
