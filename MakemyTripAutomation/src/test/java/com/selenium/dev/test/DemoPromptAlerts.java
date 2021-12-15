package com.selenium.dev.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoPromptAlerts {
	@Test
	public void test() throws InterruptedException {

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// how do you maximize window
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Alerts.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='nav nav-tabs nav-stacked']/li[3]")).click();
		WebElement ab = driver.findElement(By.xpath("//*[@class='btn btn-info']"));
		if (ab.isDisplayed()) {
			ab.click();

//			String text = driver.switchTo().alert().getText();
			Alert a = driver.switchTo().alert();
			a.sendKeys("I am iqst");
			String str = a.getText();
			System.out.println("text from alert : " + str);
			a.accept();
//			String getValue = driver.findElement(By.id("demo1")).getText();
			if (driver.findElement(By.id("demo1")).getText().contains("iqst")) {
				System.out.println("name displayed.");
			} else {
				System.out.println("given name is not displayed");
			}

		} else {
			System.out.println("no button to promopting the alerts.");
		}

	}
}