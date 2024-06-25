package listener;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample {
	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void activatesim()
	{
		System.out.println("executed sim");
		Assert.assertEquals("", "Login");
		System.out.println("Setp1");
		System.out.println("Setp2");
		System.out.println("Setp3");
	}

}
