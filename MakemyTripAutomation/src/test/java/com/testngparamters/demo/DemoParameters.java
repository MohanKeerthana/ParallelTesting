package com.testngparamters.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoParameters {

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

	@Parameters({ "name", "pwd" })
	@Test(enabled = false)
	public void getRole(String uName, String PWD) throws InterruptedException {
//		login("Admin", "admin123");
		login(uName, PWD); // get the values from xlm file.

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
