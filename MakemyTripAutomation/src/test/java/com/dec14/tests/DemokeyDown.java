package com.dec14.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemokeyDown {
	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		String baseUrl = "http://www.facebook.com/";
		driver.get(baseUrl);
		WebElement txtUsername = driver.findElement(By.id("email"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder.moveToElement(txtUsername)
				.click().keyDown(txtUsername, Keys.SHIFT)
				.sendKeys(txtUsername, "iqst")
				.keyUp(txtUsername, Keys.SHIFT)
				.doubleClick(txtUsername).contextClick()
				.build();
		seriesOfActions.perform();
		
	}
}