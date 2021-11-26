package com.getMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoGetMethods {
	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.fb.com");
		
	WebElement ss = driver.findElement(By.id("email"));
	System.out.println(ss.getTagName());
	
	System.out.println(ss.getCssValue("font-size"));
	
	System.out.println(ss.getTagName());
	System.out.println("page source : " + driver.getPageSource());
	
		System.out.println(ss.getTagName());
		
		
	
	
	}
}
