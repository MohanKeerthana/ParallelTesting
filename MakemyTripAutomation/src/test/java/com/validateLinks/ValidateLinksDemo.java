package com.validateLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Get all the links from a webpage and validate the link is broken or not.
 */
public class ValidateLinksDemo {
	// initiate webdriver and launch browser and launch the application.
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

	public static void verifyLinks(String link) {

		try {
			URL url = new URL(link);

			// Now we will be creating url connection and getting the response code
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() >= 400) {
				System.out.println(link + " - " + httpURLConnect.getResponseMessage() + "  is a broken link");
			}

			// Fetching and Printing the response code obtained
			else {
				System.out.println(link + " - " + httpURLConnect.getResponseMessage());
			}
		} catch (Exception e) {
			System.out.println("Error found : " + e);
		}
	}

	public void validateLinks(String userName, String password) throws InterruptedException {

		WebElement email = driver.findElement(By.id("txtUsername"));
		email.clear();
		email.sendKeys(userName);

		WebElement pwd = driver.findElement(By.id("txtPassword"));
		pwd.clear();
		pwd.sendKeys(password);

		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		loginBtn.click();

		Thread.sleep(3000);
		// Click Admin tab
		WebElement adminTab = driver.findElement(By.id("menu_admin_viewAdminModule"));
		adminTab.click();

		Thread.sleep(3000);
		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("number of link in the Admin tab : " + links.size());

		for (WebElement link : links) {
			System.out.println(link.getAttribute("href"));

			verifyLinks(link.getAttribute("href"));

		}

	}

	@Test
	public void test() throws InterruptedException {
		validateLinks("Admin", "admin123");
//		validateLinks("user1", "user1pwd");
	}

	@AfterMethod
	public void tearDown() {
		// closing the browser.
		driver.close();
	}
}
