package com.validateLinks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testAssertFunctions {
	static String url = "https://www.browserstack.com/";
	static String url1 = "https://www.facebook.com/";
	static WebDriver driver;

	@BeforeMethod
	public void setUp() {
		// webdriver manger setup to use the browser driver.
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// launch the application.

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(enabled = false)
	public void test1() {
		driver.get(url1);
		String ActualTitle = driver.getTitle();
		String expTitle = "Facebook – log in or sign up";
		String ExpectedTitle = "fb plogin page";
//		Assert.assertNotEquals(ActualTitle, ExpectedTitle);
		Assert.assertEquals("sasi", "sasi");
		System.out.println("this is after assertion failue case");
		Assert.assertEquals(ActualTitle, expTitle);
		Assert.assertNotEquals(ActualTitle, ExpectedTitle);
	}

	@Test(enabled = true)
	public void test2() {
		driver.get(url1);		
		Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Facebook – log in or sign up");
		Assert.assertTrue(verifyTitle);
	}

	@Test(enabled = false)
	public void test3() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.browserstack.com/");

		Boolean verifyTitle = driver.getTitle()
				.equalsIgnoreCase("Most Reliable App & Cross Browser Testing Platform | BrowserStack");
		Assert.assertTrue(verifyTitle);
	}

	@Test(enabled = false)
	public void test4() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.browserstack.com/");

		Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Most Reliable App & Cross Browser Testing Platform");
		Assert.assertFalse(verifyTitle);
	}

	@Test(enabled = false)
	public void test5() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.browserstack.com/");

		String verifyAssertNull = null;
		Assert.assertNull(verifyAssertNull);
	}

	@Test(enabled = false) 
	public void test6() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.browserstack.com/");

		Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Most Reliable App & Cross Browser Testing Platform");
		Assert.assertNotNull(verifyTitle);
	}

}
