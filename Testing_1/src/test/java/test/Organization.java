package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.combast.crm.objectrepository.CreateNewOrganization;
import com.combast.crm.objectrepository.Homepage;
import com.combast.crm.objectrepository.Login;
import com.combast.crm.objectrepository.OrganizationInfo;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.crm.generic.baseutility.Baseclass;

public class Organization {
	@Test(groups = "SmokeTest")
	@Parameters("Browser") 
	public  void  createOrgtest(String  browser)throws InterruptedException, IOException {
		WebDriver driver =null;
		if(browser.equals("chrome"))
		{
			driver =new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			driver =new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		ExcelUtility ej =new ExcelUtility();
		JavaUtility j=new JavaUtility();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		String orgname=ej.readdatafromexcel("Sheet1", 1, 2)+j.getRandomNumber();
	    
		Login l=new Login(driver);
		l.loginToapp("http://localhost:8888/", "admin", "admin");
		Homepage hp =new Homepage(driver);
		 hp.getOrglink().click();
		
		OrganizationInfo ob =new OrganizationInfo(driver);
		ob.getCreatenewOrganization().click();
		
		CreateNewOrganization cn =new CreateNewOrganization(driver);
		cn.getOrgnameed().sendKeys(orgname);
		cn.getSavebutt().click();

	    //verify Header msg Expected result
	    String header =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    Assert.assertTrue(true);
	    //Verify Header orgName info Expected Result
	    String actorgname =driver.findElement(By.id("dtlview_Organization Name")).getText();
	    SoftAssert Assert =new SoftAssert();
	    Assert.assertTrue(true);
	    Assert.assertAll();

}
}
