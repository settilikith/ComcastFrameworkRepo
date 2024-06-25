package data;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest {
	@Test(dataProvider = "getData")
	public void getProduct(String brandname,String productname)
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
      WebElement wb  =driver.findElement(By.xpath("//span[text()='"+productname+"']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small'and not(contains(.,'Sponsored'))]/descendant::span[@class='a-price-whole']"));
      System.out.println(wb.getText());
      driver.quit();
	    
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		ExcelUtility ej =new ExcelUtility();
		int rowcount=ej.getLastrow("product");
		Object[][] obj =new Object[rowcount][2];
		for(int i=0;i< rowcount;i++)
		{
			obj[i][0]= ej.readdatafromexcel("product", i+1, 0);
			obj[i][1]= ej.readdatafromexcel("product", i+1, 1);
		}
		return obj;
	}

}
