package com.dec15.tests.demo;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(DemoListenerTest.class)
public class DemoLT {
	static WebDriver driver;
	static String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

	@Test
	public void demoTest() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// goto url
		driver.get(url);
		WebElement email = driver.findElement(By.id("txtUdsername"));
		email.clear();
		email.sendKeys("sasi");
	}
	
	@Test
	public void login() throws Exception {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// goto url
		driver.get("http://fb.com");
		System.out.println("page title : "+ driver.getTitle());
	}
}
