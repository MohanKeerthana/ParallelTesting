package com.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
//	static WebDriver driver;

@Test
public void test() {

//		System.setProperty("Webdriver.chrome.driver", "browser driver path");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	
				
		
		
		driver.get("http://www.fb.com");
		
		try {

			WebElement email_id = driver.findElement(By.id("email"));
			
			WebElement pwd  = driver.findElement(By.id("pass"));
			
			
//			driver.findElement(By.id("pass")).clear();
//			driver.findElement(By.id("pass")).sendKeys("fasd");
			
			driver.findElement(By.name("pass"));
			driver.findElement(By.linkText("Forgotten password?")).click();
			driver.findElement(By.partialLinkText("Forgotte")).click();
			
			driver.findElement(By.tagName("button")).click();
			
			
			WebElement count_searchResult = driver.findElement(By.id("fasdf"));
			System.out.println(count_searchResult);
			
			
			pwd.clear();
			pwd.sendKeys("fasdf");
			email_id.sendKeys("selenium");
			driver.close();

		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}
	}
}
