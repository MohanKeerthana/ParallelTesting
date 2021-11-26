package com.booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OneWayTicketBooking {

	static WebDriver driver; //

	public static void main(String[] args) {

//		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();

		driver = new FirefoxDriver();

		String url = "https://www.makemytrip.com/"; // Declared url
		String fb_url = "https://www.fb.com/"; // Declared url
		String irctc_url = "https://www.irctc.co.in/"; // Declared url

		driver.get(url);

		// print page title
		System.out.println(driver.getTitle() +" : "+ driver.getCurrentUrl() );

	
		driver.get(fb_url);
		// print page title
		System.out.println(driver.getTitle() +" : "+ driver.getCurrentUrl() );

	
		driver.get(irctc_url);
		// print page title
		System.out.println(driver.getTitle() +" : "+ driver.getCurrentUrl() );

		

	}

}
