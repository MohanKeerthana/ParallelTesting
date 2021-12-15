package com.dec13.actionsClass;

import static org.testng.Assert.expectThrows;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentDemo {
	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();

		String eTitle = "Demo Guru99 Page";
		String aTitle = "";
		WebDriver driver = new ChromeDriver();
		// launch Chrome and redirect it to the Base URL
		driver.get("http://demo.guru99.com/test/guru99home/");
		// Maximizes the browser window
		driver.manage().window().maximize();
		// get the actual value of the title
		aTitle = driver.getTitle();
		// compare the actual title with the expected title
		if (aTitle.contentEquals(eTitle)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}

		WebElement test = driver.findElement(By.id(""));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(test));
//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//			       .withTimeout(30, TimeUnit.SECONDS)
//			       .pollingEvery(5, TimeUnit.SECONDS)
//			       .ignoring(NoSuchElementException.class);
			 
		test.click();

	}
}
