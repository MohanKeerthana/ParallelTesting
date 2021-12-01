package com.validateLinks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoHardAsserts {
	static WebDriver driver;
	static String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

	@BeforeMethod
	public void setUp() {
		// webdriver manger setup to use the browser driver.
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// launch the application.
		driver.get(url);
	}

	@Test
	public void test() {
		String ActualTitle = driver.getTitle();
		String verifyAssertNull = null;
		String ExpectedTitle = "orange HRM";
		Boolean verifyTitleIsPresent = driver.getTitle().equalsIgnoreCase("HRM");
		Boolean verifyTitleIsChanged = driver.getTitle().equalsIgnoreCase("Orange HRM");
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		Assert.assertNotEquals(ExpectedTitle, "HRM");
		Assert.assertTrue(verifyTitleIsPresent);
		Assert.assertFalse(verifyTitleIsChanged);
		Assert.assertNotNull(verifyTitleIsPresent);
		Assert.assertNull(verifyAssertNull);

	}
}
