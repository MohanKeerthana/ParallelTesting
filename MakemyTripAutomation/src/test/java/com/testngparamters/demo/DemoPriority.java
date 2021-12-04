package com.testngparamters.demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class DemoPriority {
	
	@BeforeClass
	public void login() {
		System.out.println("This is login method.");
	}
	
	@Test(dependsOnMethods = "vcreateNewUser")
	public void updateUser() {
		System.out.println("Update user data method.");
	}
	
	@Test( description = "craeting new users")
	public void vcreateNewUser() {
		System.out.println("Create new user method.");
	}
	
	
	@AfterClass
	public void logout() {
		System.out.println("logout method.");
	}

}
