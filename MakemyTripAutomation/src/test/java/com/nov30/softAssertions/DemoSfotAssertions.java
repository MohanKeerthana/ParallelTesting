package com.nov30.softAssertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * implement soft assertions with examples.
 */
public class DemoSfotAssertions {

	WebDriver driver;
	String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);

	}

	@Test
	public void test() throws InterruptedException {
		SoftAssert sf = new SoftAssert();

		String expTitle = "OrangeHR";
		String loginBtn_value = "LOGI";
		String verifyAssertNull = null;
		String actTitle = driver.getTitle();

		Boolean verifyTitleIsPresent = driver.getTitle().equalsIgnoreCase("HRM");
		Boolean verifyTitleIsChanged = driver.getTitle().equalsIgnoreCase("Orange HR");

		sf.assertTrue(verifyTitleIsPresent, "assert true failed. ");
		sf.assertFalse(verifyTitleIsChanged, "assert false failed.");

		sf.assertNotNull(verifyAssertNull, "assert not null failed.");
		sf.assertNull(verifyTitleIsPresent, "assert null failed. ");

		sf.assertEquals(actTitle, expTitle, "login page title is not matched.");
		sf.assertEquals(driver.findElement(By.id("btnLogin")).getAttribute("value"), loginBtn_value,
				"login button value does not matched.");
//		Assert.assertEquals(actTitle, expTitle, "login page title is not matched.");
//		login("Admin", "admin123");// create a login method to enter the username, password and click login
									// buttton.
		sf.assertAll();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	public void login(String userName, String password) throws InterruptedException {
		WebElement email = driver.findElement(By.id("txtUsername"));
		email.clear();
		email.sendKeys(userName);

		WebElement pwd = driver.findElement(By.id("txtPassword"));
		pwd.clear();
		pwd.sendKeys(password);

		WebElement loginBtn = driver.findElement(By.id("btnLogin"));

		loginBtn.click();
		Thread.sleep(3000);
	}

}
