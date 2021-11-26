package com.Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Get the text for user creds by using .getText() method.
 */
public class DemoGetText {

//Create TestNG Test annotation 
	@Test
	public void test1() throws InterruptedException {
		// Driver and Browser initialization
		String url = "http://www.fb.com";
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		// Open Application
		driver.get(url);
		Thread.sleep(10000);
//		driver.navigate().to(url);
		// how do you maximize the window. **

//		What is the diff b/w driver.get(method and driver.navigate().to() method);
		driver.manage().window().maximize();

//		driver.manage().window().maximize();
		// Find WebElement to get the text and create a WebElement
		WebElement createBtn = driver.findElement(By.linkText("Create New Account"));
		// Print the text value
		System.out.println("this is get Text value : "+createBtn.getText());
		
		
		WebElement forgotPwdLink = driver.findElement(By.partialLinkText("Forgotten"));
		
		
		//use getAttribute
		System.out.println("this is get link url  : "+forgotPwdLink.getAttribute("href"));
		
		
		WebElement emailID = driver.findElement(By.id("email"));
		String placeHolderVale_Email = emailID.getAttribute("placeholder");
		System.out.println("print placeholder value : "+placeHolderVale_Email);
		// close the browser
		driver.close();

	}

	//print title and current url
	@Test
	public void test2() throws InterruptedException {
		// Driver and Browser initialization
		String url = "http://www.fb.com";
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		// Open Application
		driver.get(url);
		Thread.sleep(10000);
//		driver.navigate().to(url);
		// how do you maximize the window. **

//		What is the diff b/w driver.get(method and driver.navigate().to() method);
		driver.manage().window().maximize();

		String pageTitle = driver.getTitle();
		System.out.println("current page title : "+pageTitle);
		
		
		// go to forgot password page.
		WebElement forgotPwdLink = driver.findElement(By.partialLinkText("Forgotten"));
		
		forgotPwdLink.click();
		Thread.sleep(10000);
		// current url
		String c_url = driver.getCurrentUrl();
		System.out.println("current url for forgot pwd page : "+ c_url);
		
		// close the browser
//		driver.close();
		driver.quit();

	}
}
