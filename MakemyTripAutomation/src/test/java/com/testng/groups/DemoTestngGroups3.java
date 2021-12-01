package com.testng.groups;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoTestngGroups3 {

	
	@Test(groups= {"Regression"})
	public void chrome() {
		//Login with admin user
		System.out.println("Chrome browser opened successfully.");
	}
	
	@Test(groups= {"Regression"})
	public void edge() {
		//Go to Admint tab. 
		System.out.println("edge browser opened successfully");
		
		
			
	}
	
	@Test(groups= {"Regression"})
	public void firefox() {
		//Go to Leave Tab
		System.out.println("firefox browser opened successfully");
		
	}
	
	@Test(groups= {"Regression"})
	public void safari() {
		//Go to my info page and check the personal details.
		System.out.println("safari browser opened successfully.");
	}
	
	@Test (groups= {"Regression"})
	public void opera() {
		//user logout
		System.out.println("opera browser opened successfully.");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
