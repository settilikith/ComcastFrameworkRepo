package advancedreport;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentScreen {
	@Test
	public void createContactTest() 
	{
		WebDriver driver =new ChromeDriver();
		driver.get("http://localhost:8888");
		
			//spark report config
				ExtentSparkReporter spark =new ExtentSparkReporter("./AdvanceReport/report.html");
				spark.config().setDocumentTitle("CRM Test Suite Results");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.STANDARD);
				
				//adds Env information & create test
				ExtentReports report =new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("os","Window-10");
				report.setSystemInfo("Browser","Chrome-100");
				
				TakesScreenshot ts =(TakesScreenshot)driver;
				String file =ts.getScreenshotAs(OutputType.BASE64);

				
				ExtentTest test =report.createTest("createContactTest");
				test.log(Status.INFO, "Login to APP");
				if("HDFE".equals("HDFS"))
				{
					test.log(Status.PASS, "Contact is created");
					
				}
				else
				{
					test.addScreenCaptureFromBase64String(file,"Errorfile");
				}
				report.flush();
		        driver.close();

}
}