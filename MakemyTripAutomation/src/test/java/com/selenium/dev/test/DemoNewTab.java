package com.selenium.dev.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoNewTab {

	@Test
	public void test() throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// how do you maximize window
		driver.manage().window().maximize();
		driver.get("http://naukri.com");		
		Thread.sleep(3000);
		driver.quit();
//		driver.close();

	}
}
