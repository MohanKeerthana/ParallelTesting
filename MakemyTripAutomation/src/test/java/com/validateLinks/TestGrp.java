package com.validateLinks;

import org.testng.annotations.Test;

public class TestGrp {

	@Test(groups = { "smoke" })
	public void test1() {
		System.out.println("this is smoke");
	}

	@Test(groups = { "retest" })
	public void test2() {
		System.out.println("this is retest");
	}

}
