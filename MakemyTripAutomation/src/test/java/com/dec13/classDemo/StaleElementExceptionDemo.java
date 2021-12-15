package com.dec13.classDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementExceptionDemo {
	@Test
	public void testStaleElementException() throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// implicit wait and it will applicable for all
																		// elements.
		driver.get("http:/www.fb.com");
		WebElement email_id = driver.findElement(By.id("email"));
		email_id.sendKeys("iqst");
		WebElement pass = driver.findElement(By.id("pass"));
		pass.sendKeys("iqst123");
		driver.manage().window().maximize();
//		driver.navigate().to("http://www.google.com");
//		driver.navigate().back();
		driver.navigate().refresh();
//		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(email_id)));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(email_id))); // this is not working /
	// supporting to overcome the stale eleement. hence we are using try catch blocks.
//		When we catch the staleelemeentreferenceexception then we will reinitialize the webelement.
		try {

			email_id.sendKeys("sasi");
			System.out.println("I am here.");

		} catch (StaleElementReferenceException e) {
			System.out.println("this is stale element exception.");
			email_id = driver.findElement(By.id("email"));
			email_id.sendKeys("sasi");

		}

	}
}