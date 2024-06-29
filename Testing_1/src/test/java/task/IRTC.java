package task;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class IRTC {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
	WebDriver driver =new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("https://www.irctc.co.in/nget/train-search");
	
    driver .findElement(By.xpath("//input[@aria-controls='pr_id_1_list']")).sendKeys(" KSR BENGALURU - SBC ");

    driver.findElement(By.xpath("//input[@aria-controls='pr_id_2_list']")).sendKeys("HYDERABAD DECAN - HYB (SECUNDERABAD)");
    
    driver.findElement(By.id("jDate")).click();
    driver.findElement(By.xpath("//tr[@class='ng-tns-c58-10 ng-star-inserted']/descendant::td[@class='ng-tns-c58-10 ng-star-inserted'and(contains(.,'29'))]/a[@class='ui-state-default ng-tns-c58-10 ng-star-inserted']")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right ng-tns-c65-11']")).click();
    driver.findElement(By.xpath("//li[@role='option']/ancestor::p-dropdownitem[@class='ng-tns-c65-11 ng-star-inserted'and(contains(.,'Sleeper (SL)'))]/descendant::li[@role='option']")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//button[text()= 'Search']")).click();
    
   List<WebElement> su =driver.findElements(By.xpath("//div[@class='dull-back no-pad col-xs-12'and(contains(.,'SAMPARK KRANTI'))]"));
   List<WebElement> se=driver.findElements(By.xpath("//div[@class='white-back no-pad col-xs-12'and(contains(.,'13:50 | '))]"));
   FileInputStream fi =new FileInputStream("./testdata/Book1.xlsx");
	Workbook wb = WorkbookFactory.create(fi);
	Sheet s =wb.createSheet();

   for(int i=0;i<9;i++)
	{
	   for(WebElement u:su)  
	{
		for(WebElement e:se)
		{
			String data =u.getText()+e.getText();
			System.out.println(u.getText());
			System.out.println(e.getText());
			if(data.startsWith("S"))
			{
                 s.createRow(i).createCell(1).setCellValue(data);
			}
		}
	}
  }
   FileOutputStream f =new FileOutputStream("./testdata/Book1.xlsx");
	wb.write(f);
	wb.close();
   
	}
	}

