package com.dec13.classDemo;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoImplicitWait {

	/*
	 * this is for implicit wait
	 */
	
	@Test
	public void testImplicitWait() {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// implicit wait and it will applicable for all elements.
		driver.get("http:/www.fb.com");		
		driver.findElement(By.id("email")).sendKeys("iqst");		
		driver.findElement(By.id("pass")).sendKeys("iqst123");
		//WebDriverWait is class or interface ? - > class
		//ChromeDriver is an interface or class ? -> class
		//WebDriveris interface or class ? - > interface
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement el = driver.findElement(By.name("login"));
		wait.until(ExpectedConditions.elementToBeClickable(el));
		el.click();
		
		FluentWait<WebDriver> wait2 = new FluentWait<WebDriver>(driver);
		wait2.withTimeout(10, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				
						
	}
	
}
