package com.dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DP_Demo {
	
	/*
	 * @Parameters({"v1_name", "v2_name", "v3_name"})
	 * 
	 * @Test public void test(String v1, String v2, String v3) {
	 * System.out.println("print v1 : "+v1); System.out.println("print v2 : "+v2);
	 * System.out.println("print v3 : "+ v3);
	 * 
	 * }
	 */
	
	@DataProvider(name = "mytestdata")
	public Object[][] testdata(){
		Object[][] d = new Object[2][3];
		
		d[0][0] = "domnic";
		d[0][1] = "u1";
		d[0][2] = "p1";
		d[1][0] = "dom2";
		d[1][1] = "u2";
		d[1][2] = "p2";
				
		return d;
	}
//	* what is the return type of dataprovider ?
//			 it will return 2d object array.
	@DataProvider(name = "testdata1")
	public Object[][] testd1(){
						
		return new Object[][] {{"domnic1", "u1", "p1"},{"domnic2", "u2", "p2"},{"domnic3", "u3", "p3"},{"domnic4", "u4", "p4"
				+ ""} };
	}
	
	@Test(dataProvider = "testdata1")
	public void testDP(String r1, String r2, String r3) {
		System.out.println(r1 + " : "+ r2 +" : "+ r3);
		
	}

}
