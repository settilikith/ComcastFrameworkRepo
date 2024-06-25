package listener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseutility.Exampleclass;



//@Listeners(com.comcast.crm.listenerutility.ListenerImp.class)

public class InvoiceTest extends Exampleclass {
	@Test
	public void  createInvoiceTest()
	{
		System.out.println("execute createInvoiceTest");
		String actTittle =driver.getTitle();
		//Assert.assertEquals(actTittle, "Login");
		Assert.assertEquals(actTittle, "Home");
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		System.out.println("Step4");
	}
	@Test
	public void createInvoicewithContactTest()
	{
		System.out.println("execute createInvoicewithContactTest");
//		System.out.println("Step1");
//		System.out.println("Step2");
//		System.out.println("Step3");
//		System.out.println("Step4");
	}

}
