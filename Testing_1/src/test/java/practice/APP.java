package practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class APP {
	@Test
	public void amazontest() throws IOException
	{
		WebDriver driver =new ChromeDriver();
		driver.get("http://amazon.in");
		//step1:create an object to EvenFiringWebdriver
		EventFiringWebDriver e =new EventFiringWebDriver(driver);
		//step2:use getscreenshotAs method to get file type of screenshot
		File f=e.getScreenshotAs(OutputType.FILE);
		//File fu =new File("");
		//step3: store screen on local driver
		FileUtils.copyFile(f, new File("./screenshot/test.png"));
	}

}
