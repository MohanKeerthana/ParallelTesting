package com.validateLinks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoSoftAsserts {
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

	@Test( description = "this is sample test")
	public void test() {
		
		String ActualTitle = driver.getTitle();
		String verifyAssertNull = null;
		String ExpectedTitle = "orange HRM";
		Boolean verifyTitleIsPresent = driver.getTitle().equalsIgnoreCase("HRM");
		Boolean verifyTitleIsChanged = driver.getTitle().equalsIgnoreCase("Orange HRM");
		SoftAssert sf = new SoftAssert();
		
		sf.assertEquals("as", "ab");
		
		sf.assertEquals("ab", "ab");
		
		sf.assertNotNull("dd");
		sf.assertNull(null);
		
		sf.assertTrue(false);
		
		sf.assertFalse(false);
		
//		sf.assertAll();
		
//		Assert.assertEquals(ExpectedTitle, ActualTitle);
//		Assert.assertNotEquals(ExpectedTitle, "HRM");
//		Assert.assertTrue(verifyTitleIsPresent);
//		Assert.assertFalse(verifyTitleIsChanged);
//		Assert.assertNotNull(verifyTitleIsPresent);
//		Assert.assertNull(verifyAssertNull);

	}
}
