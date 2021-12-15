package com.dec13.actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dataProvider.DP_d1;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElement {
	static WebDriver driver;
	static String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

	@BeforeMethod
	public void setUp() throws InterruptedException {
		// webdriver manger setup to use the browser driver.
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// launch the application.

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void loginTest() throws InterruptedException {
		driver.get(url);
//		try {
		WebElement email = driver.findElement(By.id("txtUsername"));
		email.clear();
		email.sendKeys("hello");
		WebElement el = driver.findElement(By.linkText("Forgot your password?"));
		if (el.isDisplayed()) {
			System.out.println("i am here");
		} else {
			System.out.println("i not here");
		}
		
//		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.navigate().to("http://www.fb.com");
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.alertIsPresent());
//		wait.until(ExpectedConditions.elementToBeClickable(email));
//		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(email)));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(email)));
		email.sendKeys("its me");
		Thread.sleep(3000);
		//}
//		catch (Exception e) {
//		System.out.println("error : "+ e.getMessage());
//		}

	}

	

}
