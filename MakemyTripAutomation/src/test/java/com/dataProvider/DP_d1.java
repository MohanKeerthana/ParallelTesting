package com.dataProvider;

import org.testng.annotations.DataProvider;

public class DP_d1 {
	/*
	 * @DataProvider(name = "testdata1") public Object[][] testd1() {
	 * 
	 * return new Object[][] { { "domnic1", "u1", "p1" }, { "domnic2", "u2", "p2" },
	 * { "domnic3", "u3", "p3" }, { "domnic4", "u4", "p4" + "" } }; }
	 * 
	 * @DataProvider(name = "newUserTestData") public Object[][] userTestData() {
	 * 
	 * return new Object[][] { { "John Smith", "seleniumA1", "selenium123",
	 * "Enabled", "Admin" }, { "Dominic Chase", "seleniumA2", "selenium123",
	 * "Disabled", "Admin" }, { "Charlie Carter", "seleniumA3", "selenium123",
	 * "Enabled", "ESS" }, { "Anthony Nolan", "seleniumA4", "selenium123",
	 * "Disabled", "ESS" } }; }
	 */

	@DataProvider(name = "loginData")
	public Object[][] loginTestData() {

		return new Object[][] { 
			{ "Admin", "admin123" },
			{ "seleniumA1", "selenium123" }, 
			{ "seleniumA2", "selenium123" },
			{ "seleniumA3", "selenium123" },
			{ "seleniumA4", "selenium123" } };
	}
}
