package com.dataProvider;

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

public class DemoLogin_DP {
	static WebDriver driver;
	static String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

	@BeforeClass
	public void setUp() throws InterruptedException {
		// webdriver manger setup to use the browser driver.
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// launch the application.
		driver.get(url);
		login("Admin", "admin123");
		// locate the Admin tab and click Admin tab.
		WebElement adminTab = driver.findElement(By.xpath("//*[@id='mainMenu']/ul/li[1]"));
		adminTab.click();
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

//	@Parameters({ "e_name", "u_name", "u_pwd" })
	@Test(dataProvider = "newUserTestData", dataProviderClass = DP_d1.class)
	public void getRole(String v1, String v2, String v3, String v4, String v5) throws InterruptedException {

		String employeeName = v1;
		String userName = v2;
		String pwd_value = v3;
		String status = v4;
		String role_type = v5;

		ReUsableMethods rs = new ReUsableMethods();
		// Click Add
		driver.findElement(By.id("btnAdd")).click();
		Thread.sleep(5000);
		// select role
		WebElement role = driver.findElement(By.name("systemUser[userType]"));
		rs.selectListItem(role, role_type);
		Thread.sleep(3000);
		// enter emp name
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(employeeName);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='ac_results']/ul/li/strong")).click();
		Thread.sleep(3000);
		// enter user name
		driver.findElement(By.id("systemUser_userName")).sendKeys(userName);
		// select status
		WebElement selectStatus = driver.findElement(By.id("systemUser_status"));
		rs.selectListItem(selectStatus, status);
		// enter pwd
		driver.findElement(By.id("systemUser_password")).sendKeys(pwd_value);
		// enter confirm pwd
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(pwd_value);
		Thread.sleep(5000);
		// click submit
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(5000);
		// verify the newly added user
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(userName);
		// click search button
		driver.findElement(By.id("searchBtn")).click();
		Thread.sleep(3000);
		String getUserName = driver
				.findElement(By.xpath("//*[@id='resultTable']//tr/td/a[contains(text(),'" + userName + "')]"))
				.getText();
		System.out.println("created user with user name as : " + getUserName);
		Assert.assertEquals(getUserName, userName);
	}

	@AfterClass
	public void tearDown() {
		System.out.println("test completed.");
//		driver.close();
	}

}
