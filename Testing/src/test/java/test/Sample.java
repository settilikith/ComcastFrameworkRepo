package test;

import org.testng.annotations.Test;

public class Sample {
	@Test(priority=1)
	public void  Create()
	{
		System.out.println("m1");
	}
	@Test(priority=2,dependsOnMethods="Create")
	public void Modify()
	{
		System.out.println("m2");
	}
	@Test(priority=3,dependsOnMethods="Modify")
	public void Reuse()
	{
		System.out.println("m3");
	}
	@Test(priority=4,dependsOnMethods="Reuse")
	public void delete()
	{
		System.out.println("m4");
	}

}
