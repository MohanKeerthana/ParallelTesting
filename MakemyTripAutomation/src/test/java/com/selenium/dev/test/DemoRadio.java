package com.selenium.dev.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoRadio {

	@Test
	public void validateRadioButton() throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// how do you maximize window
		driver.manage().window().maximize();
		driver.get("http://fb.com");
		WebElement createNewAccount_ele = driver.findElement(By.linkText("Create New Account"));
		if (!createNewAccount_ele.isDisplayed()) {
			System.out.println("create account link is not displayed. ");
		} else {
			System.out.println("Create new link is displayed.");
			createNewAccount_ele.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='radio' and @value='1']")).click();
		}
		// validate the radio button - check female radio button is selected or not.
		// if not selected then select female option.
		WebElement female_ele = driver.findElement(By.xpath("//input[@typ='radio' and @value='1']"));
		if(!female_ele.isSelected()) {
			female_ele.click();
			System.out.println("female option now selected.");
		}else {
			System.out.println("female option already selected.");
		}
		

	}

}
