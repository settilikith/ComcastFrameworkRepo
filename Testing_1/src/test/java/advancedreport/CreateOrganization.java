package advancedreport;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert; 
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.beust.jcommander.Parameters;
import com.combast.crm.objectrepository.CreateNewOrganization;
import com.combast.crm.objectrepository.Homepage;
import com.combast.crm.objectrepository.OrgInfor;
import com.combast.crm.objectrepository.OrganizationInfo;
import com.comcast.crm.generic.webdriverutility.Utilityclassobject;
import com.comcast.crm.listenerutility.Listener;

import baseutility.Exampleclass;

public class CreateOrganization extends Exampleclass {
	@Test
	public  void  createOrgtest()throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		Utilityclassobject.getTest().log(Status.INFO, "read the data from excel");
		String orgname=ej.readdatafromexcel("Sheet1", 1, 2)+j.getRandomNumber();
	    
		Utilityclassobject.getTest().log(Status.INFO, "enter in to org page");
		Homepage hp =new Homepage(driver);
		hp.getOrglink().click();
		
		Utilityclassobject.getTest().log(Status.INFO, "navigate to a org page");
		OrganizationInfo ob =new OrganizationInfo(driver);
		ob.getCreatenewOrganization().click();
		 
		Utilityclassobject.getTest().log(Status.INFO, "create the org page");
		CreateNewOrganization cn =new CreateNewOrganization(driver);
		cn.getOrgnameed().sendKeys(orgname);
		cn.getSavebutt().click();

	    //verify Header msg Expected result
	    String header =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    Assert.assertEquals(true, header.contains(orgname));
	    //Verify Header orgName info Expected Result
	    String actorgname =driver.findElement(By.id("dtlview_Organization Name")).getText();
	    Assert.assertEquals(true, actorgname.contains(orgname));

	}
	@Test
	public void CreateOrgWithphoneno() throws EncryptedDocumentException, IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Utilityclassobject.getTest().log(Status.INFO, "read data from the excel");
		String orgname =ej.readdatafromexcel("Sheet1", 7, 2)+j.getRandomNumber();
		String pho =ej.readdatafromexcel("Sheet1", 7, 3);
		
		Utilityclassobject.getTest().log(Status.INFO, "navigate to org page");
		Homepage h =new Homepage(driver);
		h.getOrglink().click();
		
		
		Utilityclassobject.getTest().log(Status.INFO, "create org page");
		OrganizationInfo op =new OrganizationInfo(driver);
		op.getCreatenewOrganization().click();
		
		Utilityclassobject.getTest().log(Status.INFO, "contact page");
		CreateNewOrganization cu =new CreateNewOrganization(driver);
		cu.getOrgnameed().sendKeys(orgname);
		cu.getPhoneed().sendKeys(pho);
		cu.getSavebutt().click();;
		 String ph =driver.findElement(By.id("dtlview_Phone")).getText();
		    if(ph.contains(pho))
		    {
		    	System.out.println("pass");
		    }
		    else
		    {
		    	System.out.println("fail");
		    }
		    

	}
	@Test
	public void createcontactwithindustry() throws EncryptedDocumentException, IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		String orgname =ej.readdatafromexcel("Sheet1", 4, 2)+j.getRandomNumber();
		String industry=ej.readdatafromexcel("Sheet1", 4, 3);
		Homepage h =new Homepage(driver);
		h.getOrglink().click();
		
		OrganizationInfo op =new OrganizationInfo(driver);
		op.getCreatenewOrganization().click();
		
		CreateNewOrganization cp =new CreateNewOrganization(driver);
		cp.createorgna(orgname, industry);
		 String actualindutries =driver.findElement(By.id("dtlview_Industry")).getText();
		    if(actualindutries.equals(industry))
		    {
		    	System.out.println("pass");
		    }
		    else
		    {
		    	System.out.println("Fail");
		    }
		    
		    String actualtype =driver.findElement(By.id("dtlview_Organization Name")).getText();
		    if(actualtype.equals(orgname))
		    {
		    	System.out.println("pass");
		    }
		    else
		    {
		    	System.out.println("fail");
		    }
	}

}
