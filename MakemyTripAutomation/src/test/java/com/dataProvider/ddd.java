package com.dataProvider;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.ReUsableMethods;

public class ddd {
	//to read test data from xlsx file - use readData method from commonmethods.java file
	@DataProvider
	public Object[][] createNewUser() throws IOException {
		Object[][] c_value = ReUsableMethods.readData();
		return c_value;

	}
	
	@Test(dataProvider = "createNewUser" )
	public void userCreation(String a, String b, String c, String d, String e, String f) {
		
		System.out.println("a : "+a);
		System.out.println("b : "+b);
		System.out.println("c : "+c);
		System.out.println("d : "+d);
		System.out.println("e : "+e);
		System.out.println("f : "+f);
		
		
	}

	@DataProvider
	public Object[][] getLoginData() throws InvalidFormatException {
		Object[][] testData = ReUsableMethods.getTestData("login");
		return testData;

	}

	@Test(dataProvider = "getLoginData", description = " using data driver to get the data from xlsx file ",enabled = false)
	public void test(String a, String b) throws InterruptedException {
		System.out.println(a + b);

	}
	// Name Age Contact

}
