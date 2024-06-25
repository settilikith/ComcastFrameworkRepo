package data;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Contact {
	@Test(dataProvider = "getData")
	public void createcontacttest(String firstname,String lastname,long phoneno)
	{
		System.out.println("Firstname:"+firstname+",Lastname:"+lastname+",phoneno:"+phoneno);
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][]obj=new Object[3][3];
		obj[0][0]="deepak";
		obj[0][1]="hr";
		obj[0][2]=817927345l;
		
		obj[1][0]="sam";
		obj[1][1]="sh";
		obj[1][2]=962865458l;
		
		obj[2][0]="Jhon";
		obj[2][1]="smith";
		obj[2][2]=910646677l;
		return obj;
	}

}
