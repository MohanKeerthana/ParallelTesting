package com.nov30.testngAnnotationsGroups;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demoannotations {

	@BeforeSuite
	public void b_suite() {
		System.out.println("this is before suite");
	}

	@AfterSuite
	public void a_suite() {
		System.out.println("this is after suite");
	}

	@BeforeTest
	public void b_Test() {
		System.out.println("this is before test");
	}

	@AfterTest
	public void a_Test() {
		System.out.println("this is after test");
	}

	@BeforeClass
	public void b_Class() {
		System.out.println(" this is @BeforeClass .");
	}

	@AfterClass
	public void a_Class() {
		System.out.println(" this is @AfterClass .");
	}

	@BeforeMethod
	public void setUp() {
		System.out.println("this is before method.");
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("after method.");
	}

	@Test
	public void test1() {
		System.out.println("this is test1 method.");
	}

	@Test
	public void test2() {
		System.out.println("this is test2 method.");
	}

	@Test
	public void test3() {
		System.out.println("this is test3 method.");
	}

	@Test
	public void test4() {
		System.out.println("this is test4 method.");
	}
}
