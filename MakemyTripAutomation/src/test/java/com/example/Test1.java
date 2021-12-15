package com.example;

import org.testng.annotations.Test;

public class Test1 {

	@Test
	public void test() {
		Boolean order = true;
		String Str1 ="b";
		String str2 = "a";
		if(Str1.compareToIgnoreCase(str2)<0) {
			order = false;
		System.out.println("it is in order");	
				
		}else {
			System.out.println("not in order");
		}
	
	}
}
