package com.dec15.tests.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSDemo {
	static WebDriver driver;
	static String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

	@Test
	public void demoTest() throws Exception {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// goto url

		driver.get(url);

		// Creating the JavascriptExecutor interface object by Type casting
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Button Element
		WebElement email = driver.findElement(By.id("txtUsername"));
		email.clear();
		email.sendKeys("sasi");
		WebElement button = driver.findElement(By.id("btnLogin"));
		// Executing JavaScript to click on element

		js.executeScript("arguments[0].click();", button);
		// Get return value from script
		String text = (String) js.executeScript("return arguments[0].innerText", button);
		// Executing JavaScript directly
		js.executeScript("console.log('hello world')");

	}
}
