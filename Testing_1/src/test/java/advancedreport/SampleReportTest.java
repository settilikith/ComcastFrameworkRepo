package advancedreport;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	@Test
	public void createTest()
	{
		//spark report config
		ExtentSparkReporter spark =new ExtentSparkReporter("./AdvanceReporte/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.STANDARD);
		
		//adds Env information & create test
		ExtentReports report =new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os","Window-10");
		report.setSystemInfo("Browser","Chrome-100");
	     ExtentTest test=report.createTest("createTest");
		
		test.log(Status.INFO,"login to app");	
		test.log(Status.INFO,"navigate to connect page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HDFC"))
		{
			test.log(Status.PASS,"contact is  created");
		}
		else
		{
			test.log(Status.FAIL,"contact is not created");
		}
		report.flush();
		System.out.println("login to app");
	}

}
