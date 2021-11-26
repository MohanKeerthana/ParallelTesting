package com.booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoBrowsers {

	public static void main(String[] args) {

		String browser = "firefox";
		String url = "https://www.fb.com/";
		WebDriver driver;
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
		WebDriverManager.edgedriver().setup();

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			driver.get(url);
			System.out.println("Open Google Chrome browser");
			break;
		case "firefox":
			driver = new FirefoxDriver();
			driver.get(url);
			System.out.println("Open Firefox browser");
			break;
		case "edge":
			driver = new EdgeDriver();
			driver.get(url);
			System.out.println("Open edge browser");
		default:
			driver = new ChromeDriver();
			driver.get(url);
			System.out.println("Google chrome browser");
		}
		driver.quit();
		

	}
}
