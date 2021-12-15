package com.selenium.dev.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectRadioButton {
//	isSelected(): Checks whether a radio button is selected or not.
//	isDisplayed(): Checks whether a radion button is displayed on the web page or not.
//	isEnabled(): Checks whether a radion button is enabled or not
	@Test
	public void test() throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// how do you maximize window
		driver.manage().window().maximize();
		driver.get("http://cleartrip.com");
		Thread.sleep(3000);
		List<WebElement> radios = driver.findElements(By.xpath("//*[@type='radio']"));

		System.out.println(radios.size());

		for (int i = 0; i < radios.size(); i++) {
			String radioname = radios.get(i).getAttribute("value");

			System.out.println(radioname);

//			String expRadio = "return";
			/*
			 * boolean selectState = false; // radioElement.isSelected();
			 * 
			 * // performing click operation only if element is not selected
			 * 
			 * if (expRadio.equalsIgnoreCase(radioname)) { selectState = true; break;
			 * 
			 * }if(selectState) { System.out.println("test pass"); }else {
			 * System.out.println("test fail"); }
			 */
		}
	}

}
