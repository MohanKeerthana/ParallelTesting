package com.dec14.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDemoParallel2 {
	static WebDriver driver;
	static String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	@Test
	public void test1() {
		System.out.println("this is test1 : "+ Thread.currentThread().getId());
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// launch the application.
		driver.get(url);
	}
	
	@Test
	public void test2() {
		System.out.println("this is test2 : "+ Thread.currentThread().getId());
		WebDriverManager.edgedriver().setup();

		driver = new EdgeDriver();
		driver.manage().window().maximize();
		// launch the application.
//		driver.get("http://fb.com");
		driver.get(url);
	}
}
