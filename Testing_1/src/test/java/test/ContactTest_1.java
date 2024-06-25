package test;

import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class ContactTest_1 {
	@Test
	public void CreateContactTest()
	{
		System.out.println("execute createContact with--->HDFC");
	}
	@Test(dependsOnMethods="CreateContactTest")
	public void modifycontact()
	{
		//System.out.println("execute query insert contact in Db==>ICCI");
		//System.out.println("execute createContact ICICI");
		//System.out.println("execute modifyContactTest-->ICICI=>ICCI_1");
		System.out.println("execute modifycontacttest==>HDFC-->ICCI");
	}
	@Test(dependsOnMethods = "modifycontact")
	public void deleteContactTest()
	{
		//System.out.println("create UPI Contact");
		//System.out.println("execute deleteContactTest-->UPI");
		System.out.println("execute deletecontacttest ICCI");
	}

}
