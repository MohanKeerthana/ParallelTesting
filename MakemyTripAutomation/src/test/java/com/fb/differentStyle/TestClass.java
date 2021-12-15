package com.fb.differentStyle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {

	@Test
	public void test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		WebElement firstname = driver.findElement(By.name("email"));
		WebElement lastname = driver.findElement(By.name("pass"));
		sendKeys(driver, firstname, 10, "Edureka");
		sendKeys(driver, lastname, 20, "Edureka");
		WebElement forgotAccount = driver.findElement(By.linkText("Forgotten account?"));
		clickOn(driver, forgotAccount, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void sendKeys(WebDriver driver1, WebElement element, int timeout, String value) {
		new WebDriverWait(driver1, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	public static void clickOn(WebDriver driver1, WebElement element, int timeout) {
		new WebDriverWait(driver1, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
}
