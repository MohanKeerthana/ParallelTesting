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
public class ValidateLinksDemo2 {
	// initiate browser and launch the application.

	String validateurl = "https://opensource-demo.orangehrmlive.com/index.php/admin/saveSystemfUser?userId=10";
	String validateurl2 = "https://opensource-demo.orangehrmlive.com/index.php/admin/saveSystemUser?userId=10";

	
	public static void verifyLinks(String link) {
		try {
			URL url = new URL(link);

			// Now we will be creating url connection and getting the response code
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			System.err.println("link status code : " + httpURLConnect.getResponseCode());
			Thread.sleep(5000);
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

	@Test
	public void testLinks() throws InterruptedException {
		verifyLinks(validateurl);
		verifyLinks(validateurl2);
//		login("user1", "user1pwd");
	}

}
