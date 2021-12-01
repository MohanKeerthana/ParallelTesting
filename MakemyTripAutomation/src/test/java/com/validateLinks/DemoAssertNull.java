package com.validateLinks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoAssertNull {
	static String url = "https://www.facebook.com/";
	static WebDriver driver;

	@BeforeMethod
	public void setUp() {
		// webdriver manger setup to use the browser driver.
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// launch the application.

	}

	@Test(enabled = false)
	public void demoAssertNull() {
		driver.get(url);
		String verifyAssertNull = driver.getCurrentUrl();
		String exp = null;
		Assert.assertNull(exp);
	}

	@Test
	public void demoAssertNotNull() {
		driver.get(url);
		String v1 = driver.getCurrentUrl();
		String v2 = null;
		Assert.assertNotNull(v1);
	}
}
