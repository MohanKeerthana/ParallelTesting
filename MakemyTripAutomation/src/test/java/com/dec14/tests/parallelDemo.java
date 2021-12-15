package com.dec14.tests;

import org.testng.annotations.Test;

public class parallelDemo {

	@Test(threadPoolSize = 3, invocationCount = 10, timeOut = 10000, enabled = false)
	public void testServer() {
		System.out.println("hello " + Thread.currentThread().getId());

	}
}
