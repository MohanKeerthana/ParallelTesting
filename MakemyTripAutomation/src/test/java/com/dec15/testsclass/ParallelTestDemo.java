package com.dec15.testsclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTestDemo {
	
	static WebDriver driver;
	static String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

	@Test
	public void test1() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("chrome page title : "+ driver.getTitle());
		driver.close();
	}

	@Test
	public void test2() {
		WebDriverManager.firefoxdriver().setup();

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("friefox page title : "+ driver.getTitle());
		driver.close();
	}

	
	@Test(enabled = false)
	public void test3() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("page title : "+ driver.getTitle());
		driver.close();
	}

}
