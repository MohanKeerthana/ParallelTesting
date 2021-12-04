package com.dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoDPInheritance {
	@DataProvider(name = "testdata1")
	public Object[][] testd1() {

		return new Object[][] {
			{ "domnic1", "u1", "p1" }, 
			{ "domnic2", "u2", "p2" }, 
			{ "domnic3", "u3", "p3" },
			{ "domnic4", "u4", "p4" } 
		};
	}
	
	@Test(dataProvider = "testdata1"  )
	public void test(String s1, String s2, String s3) {
		
		System.out.println("Print s1 : "+ s1);
		System.out.println("Print s2 : "+ s2);
		System.out.println("Print s3 : "+ s3);
	}
	
}
