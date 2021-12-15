package com.dec14.tests.keerthana;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDing {
	@Test
	public void MouseHoverOnWebelement() throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		WebDriverWait ww = new WebDriverWait(driver, 10);

		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("lovelykeerthi693@gmail.com");

		WebElement password = driver.findElement(By.id("pass"));
		password.clear();
		password.sendKeys("Keer@2804");

		WebElement login = driver.findElement(By.name("login"));
		login.click();
		String x_timeline = "//a[@aria-label=\"Keerthana Mohan's timeline\"]/following-sibling::div/div/span";
		ww.until(ExpectedConditions.presenceOfElementLocated(By.xpath(x_timeline)));
		driver.findElement(By.xpath(x_timeline));
		Actions action = new Actions(driver);
Thread.sleep(3000);
		driver.findElement(By.xpath(x_timeline)).click();
		Thread.sleep(5000);
		String y_timeline = "//form//div[contains(@id,\"placeholder\")]";
		ww.until(ExpectedConditions.presenceOfElementLocated(By.xpath(y_timeline)));
//		driver.findElement(By.xpath(y_timeline)).click();
		driver.findElement(By.xpath(y_timeline)).sendKeys(y_timeline);
	}

}
