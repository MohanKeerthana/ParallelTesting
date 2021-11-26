package com.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginLogoutFlow3 {

	@Test
	public void LoginLogout() throws InterruptedException {
		String url_orgHRM_login = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

		WebDriverManager.chromedriver().setup();
//		System.setProperty("", "")
		WebDriver driver = new ChromeDriver();

		driver.get(url_orgHRM_login);

		// Print page title
		String loginPageTitle = driver.getTitle();
		System.out.println("page title : " + loginPageTitle);

		String loginPageURL = driver.getCurrentUrl();
		System.out.println("page url : " + loginPageURL);

		String getTextValue = driver.findElement(By.cssSelector("#content > div:nth-child(3) > span")).getText();
		System.out.println("get the text : " + getTextValue);
		driver.close();
	}
}
