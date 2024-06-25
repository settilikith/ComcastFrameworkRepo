package test;

import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class Javaut {

	public static void main(String[] args) {
		JavaUtility js =new JavaUtility();
		String data=js.getSystemDateYYYYDDMM();
		String d =js.getRequiredDate(30);
		System.out.println(data);
		System.out.println(d);
		// TODO Auto-generated method stub

	}

}
