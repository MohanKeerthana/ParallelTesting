package com.dec15.tests.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.print.PrintOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoPrint {
	@Test
	public void demoTest() throws Exception {
		static WebDriver driver;
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev");
		printer = (PrintsPage) driver;

		PrintOptions printOptions = new PrintOptions();
		printOptions.setPageRanges("1-2");

		Pdf pdf = printer.print(printOptions);
		String content = pdf.getContent();
	}
}