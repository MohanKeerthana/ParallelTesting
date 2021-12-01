package com.testng.groups;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class DemoTestngGroups {

	@BeforeGroups("smoketest")
	public void beforeGroup() {
		// before groups
		System.out.println("Before Smoke test groups it will execute..");
	}

	//{ from previous class test method }
	
	@Test(groups = { "smoketest" })
	public void test1() {
		// Login with admin user
		System.out.println("Loggedin as Admin user.");
	}

	@Test(groups = { "smoketest", "Regression", "inprogress" })
	public void test2() {
		// Go to Admint tab.
		System.out.println("Go to Admin Tab");
	}

	@Test(groups = { "Regression" })
	public void test3() {
		// Go to Leave Tab
		System.out.println("Leave tab opened");

	}

	@Test(groups = { "Regression" })
	public void test4() {
		// Go to my info page and check the personal details.
		System.out.println("My info page opened and verified Personal details.");
	}

	@Test(groups = { "Regression" })
	public void test5() {
		// user logout
		System.out.println("User Loggedout successfully.");
	}

	@AfterMethod
	public void tearDown() {
		// close the browser
		System.out.println("Browser closed.");
	}

}
