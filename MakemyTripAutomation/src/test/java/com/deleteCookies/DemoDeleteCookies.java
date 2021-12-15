package com.deleteCookies;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * How to delete cookies.
 */
public class DemoDeleteCookies {

	@Test
	public void deleteCookies() throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// how do you maximize window
		driver.manage().window().maximize();

		// how to delete cookies before start testing.
		driver.manage().deleteAllCookies();
		/*
		 * driver.get("http://fb.com"); Thread.sleep(3000);
		 * driver.navigate().to("https://www.makemytrip.com/flights/");
		 * Thread.sleep(3000); // how do you goback to the previously navigated page
		 * driver.navigate().back();
		 * 
		 * // how do you refresh the browser driver.navigate().refresh();
		 * 
		 * // how do you click browser foward driver.navigate().forward();
		 */

//		how to seledt a check box?
		
		driver.get("https://www.ironspider.ca/forms/checkradio.htm");
		
		
		
		Thread.sleep(3000);
		
		WebElement red_Ck_Box =driver.findElement(By.xpath("//input[@value='red']"));
		red_Ck_Box.click();
		
		//how many check boxes in the web page.
		List<WebElement> ch_boxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
		int numberOfCheckBoxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).size();
		System.out.println("total number of check boxes in the page : "+ numberOfCheckBoxes);
	}

}
