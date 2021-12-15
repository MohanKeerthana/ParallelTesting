package com.selenium.dev.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoAlert {
	@Test
	public void test() throws InterruptedException {

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// how do you maximize window
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();
		Alert ale = driver.switchTo().alert();
		String x = ale.getText();
//		alert.accept();
//		alert.dismiss();
		System.out.println(x);
		ale.dismiss();
		System.out.println(driver.switchTo().alert().getText());
		// it will throw exception. because we dismissed the alert so there is not alert
		// present in the window.

	}
}