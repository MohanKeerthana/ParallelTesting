package com.validateLinks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoListVaues {
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

	@Test
	public void getRole() throws InterruptedException {
		login("Admin", "admin123");

		// locate the Admin tab and click Admin tab.
		WebElement adminTab = driver.findElement(By.xpath("//*[@id='mainMenu']/ul/li[1]"));
		adminTab.click();

		printselect("searchSystemUser_userType");
		printselect("searchSystemUser_status");
		
		
		/*
		 * // print list items Select li = new
		 * Select(driver.findElement(By.id("searchSystemUser_userType")));
		 * List<WebElement> userRole = li.getOptions();
		 * System.out.println("user role list count" + userRole.size());
		 * 
		 * for (WebElement e : userRole) { System.out.println("role : " + e.getText());
		 * }
		 * 
		 * // print status list items Select li2 = new
		 * Select(driver.findElement(By.id("searchSystemUser_status")));
		 * List<WebElement> userstatus = li2.getOptions();
		 * System.out.println("user status list count" + userstatus.size());
		 * 
		 * for (WebElement e : userstatus) { System.out.println("role : " +
		 * e.getText()); }
		 */
	}

	public void printselect(String listname) {
		Select li2 = new Select(driver.findElement(By.id(listname)));
		List<WebElement> userstatus = li2.getOptions();
		System.out.println("list count" + userstatus.size());

		for (WebElement e : userstatus) {
			System.out.println("item : " + e.getText());
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
