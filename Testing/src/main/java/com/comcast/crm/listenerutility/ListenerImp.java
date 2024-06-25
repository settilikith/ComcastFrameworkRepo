package com.comcast.crm.listenerutility;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import baseutility.Exampleclass;

public class ListenerImp implements ITestListener,ISuiteListener {
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		// TODO Auto-generated method stu
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+">=====start===");

		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+">====END====");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname=result.getMethod().getMethodName();
		EventFiringWebDriver e =new EventFiringWebDriver(Exampleclass.sdriver);
		File se=e.getScreenshotAs(OutputType.FILE);
		String time =new Date().toString().replace(" ", "_").replace(":", " ");
		try
		{
			FileUtils.copyFile(se,new File("./screenshot/"+testname+""+time+".png"));
		}
		catch (Exception ec) {
			ec.printStackTrace()	;
			}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}
