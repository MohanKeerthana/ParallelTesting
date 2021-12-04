package com.testngparamters.demo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class DemoOptionParams {

	@Parameters("optional")
	@Test
	public void test(@Optional("i am default for optional ") String s1) {
		System.out.println("print param : " + s1);
	}
	//optional paramter is not declared in the xml configuration file.
}
