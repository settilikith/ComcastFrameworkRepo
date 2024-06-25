package practice;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomepageVerfy {
	@Test
	public void homepageTest(Method mtd)
	{
		Reporter.log(mtd.getName()+" Test Start");
		String exp="Home";
		Reporter.log("Step1",true);
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String acttitle =driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		//Hard Assert
		Assert.assertEquals(acttitle, exp);
		Reporter.log(mtd.getName()+"Test end");
		driver.close();
	}
	@Test
	public void Logohomepagetest(Method mtd)
	{
		Reporter.log(mtd.getName()+" Test Start");
		
		Reporter.log("Step1",true);
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		boolean status =driver.findElement(By.xpath("//img[@src='test/logo/vtiger-crm-logo.gif']")).isEnabled();
		//Assert.assertEquals(true,status);
		//softassert
		SoftAssert Assert=new SoftAssert();
		Assert.assertTrue(status);
		Assert.assertAll();
		Reporter.log(mtd.getName()+"Test end");
		driver.close();
	}

}
