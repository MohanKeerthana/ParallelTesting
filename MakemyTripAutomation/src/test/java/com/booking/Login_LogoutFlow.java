package com.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_LogoutFlow {

	public static void main(String[] args) throws InterruptedException {
		String url_orgHRM_login = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
		String userName = "Admin";
		String password = "admin123";

		String linkTest_Welcome = "Welcome";
		String actualValue_LoggedUser;

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get(url_orgHRM_login);
		WebElement input_email = driver.findElement(By.id("txtUsername"));

		WebElement input_pwd = driver.findElement(By.id("txtPassword"));

		WebElement btn_login = driver.findElement(By.id("btnLogin"));

		input_email.clear();
		input_email.sendKeys(userName);

		input_pwd.clear();
		input_pwd.sendKeys(password);

		btn_login.click();
		Thread.sleep(3000);

		// Print PAge title after login
		System.out.println(driver.getTitle());

		// print welcome user name from dashboard page.

		WebElement loggedInUser = driver.findElement(By.partialLinkText(linkTest_Welcome));

		actualValue_LoggedUser = loggedInUser.getText();
		
		System.out.println("print loggedin user name : " + actualValue_LoggedUser);
		
		String getAttributeValue = loggedInUser.getAttribute("id");
		System.out.println("print value by using get Attribute : "+getAttributeValue);
		
		// click on user profile to logout
		loggedInUser.click();
		Thread.sleep(3000);
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		// click logout
		logout.click();

		driver.close();

	}

}
