package com.dec15.tests.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListenerMainClass  {
	static WebDriver driver;
	static String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

	@Test
	public void demoTest() throws Exception {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// goto url

		driver.get(url);
//		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver);
		EventCapture ecapture = new EventCapture();

		eventHandler.register(ecapture); 
		eventHandler.navigate().to("http://www.google.com");
		WebElement element = eventHandler.findElement(By.name("q"));
		element.sendKeys("iqst");
		element.submit();
		System.out.println(driver.getTitle());
		eventHandler.unregister(ecapture);
		driver.quit();
}
}