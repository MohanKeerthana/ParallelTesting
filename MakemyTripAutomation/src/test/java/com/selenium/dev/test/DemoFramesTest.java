package com.selenium.dev.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoFramesTest {

	String url = "https://www.monsterindia.com/";
	@Test
	public void validateFrames() throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// how do you maximize window
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(2000);
//print all frames 	
		List<WebElement> li = driver.findElements(By.tagName("iframe"));
		for(WebElement ref : li) {
			System.out.println(ref.getAttribute("id"));
			System.out.println(ref.getAttribute("name"));
			//switch to each and every frame
			driver.switchTo().frame(ref.getAttribute("id"));
			driver.switchTo().parentFrame();
			
			//get all the links from the frame
			List<WebElement> lis = driver.findElements(By.tagName("a"));
			System.out.println(lis.size());
			//print all the links from inside the frame
			for( WebElement ee : lis) {
				System.out.println("print link from frame : "+ ee.getAttribute("href"));
				System.out.println("print link from frame : "+ ee.getAttribute("href"));
			}
		}
		
	
	}
}
