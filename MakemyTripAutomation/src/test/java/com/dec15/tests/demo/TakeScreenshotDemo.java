package com.dec15.tests.demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshotDemo {

	public void takeSnapShot(WebDriver driver, String fileWithPath) throws IOException {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(fileWithPath);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}

	static WebDriver driver;
	static String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

	@Test
	public void demoTest() throws Exception {
		
		try {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		// Call take screenshot function
		String filepath = ".//screenshots//";
		// E:\ExamplesTest\MakemyTripAutomation
//		takeSnapShot(driver, filepath+"test.png");

		WebElement email = driver.findElement(By.id("txtUsername"));
		email.clear();
		email.sendKeys("sasi");

		WebElement pass = driver.findElement(By.id("txtPassword"));
		pass.clear();
		pass.sendKeys("sasi");

		//take the screenshot for a webelement.
		File scrFile = pass.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(filepath + "password.png"));
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("write teh screnshot method here.");
		}

	}

}
