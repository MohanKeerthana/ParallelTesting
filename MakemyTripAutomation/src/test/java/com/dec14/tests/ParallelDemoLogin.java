package com.dec14.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utils.ReUsableMethods;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelDemoLogin {
	static WebDriver driver;
	static String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

	@BeforeMethod
	public void setUp() throws InterruptedException {
		// webdriver manger setup to use the browser driver.
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// launch the application.
		driver.get(url);
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider = "loginData", dataProviderClass = DP_d1.class)
	public void loginTest(String s1, String s2) throws InterruptedException {
		login(s1, s2 );
		Thread.sleep(5000);
		// locate the Admin tab and click Admin tab.
		WebElement adminTab = driver.findElement(By.xpath("//*[@id='mainMenu']/ul/li[1]"));
		adminTab.click();
		Thread.sleep(5000);
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
