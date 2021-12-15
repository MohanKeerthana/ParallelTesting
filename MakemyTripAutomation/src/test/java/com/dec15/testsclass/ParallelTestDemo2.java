package com.dec15.testsclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTestDemo2 {
	
	static WebDriver driver;
	static String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

	@Test
	public void test1() {
		WebDriverManager.edgedriver().setup();

		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("Edge page title : "+ driver.getTitle());
		driver.close();
	}

	@Test
	public void test2() {
		WebDriverManager.operadriver().setup();

		driver = new OperaDriver();
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("Opera page title : "+ driver.getTitle());
		driver.close();
	}

	
	

}
