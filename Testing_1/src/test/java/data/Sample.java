package data;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class Sample {
@Test(dataProvider = "Data")

	public  void Sample(String Name,String position) {
	System.out.println("Name:" +Name+",Postion:"+position);
		// TODO Auto-generated method stub

	}
@DataProvider
 public Object[][] Data() throws EncryptedDocumentException, IOException
 {
	ExcelUtility ej =new ExcelUtility();
	int lastrow =ej.getLastrow("Sheet4");
	System.out.println(lastrow);
	Object[][]o=new Object[lastrow][2];
	for(int i=0;i<lastrow;i++) {
		o[i][0]=ej.readdatafromexcel("Sheet4", i+1, 0);
		o[i][1]=ej.readdatafromexcel("Sheet4", i+1, 1);
	}
	return o;
	
	
 }

}
