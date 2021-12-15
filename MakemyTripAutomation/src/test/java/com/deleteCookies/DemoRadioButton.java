package com.deleteCookies;

import java.util.List;

import org.apache.tools.ant.taskdefs.condition.Not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Check box operations.
 */
public class DemoRadioButton {

	@Test
	public void selectRadio() throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// how do you maximize window
		driver.manage().window().maximize();
		// how to delete cookies before start testing.
		driver.manage().deleteAllCookies();
//		how to select a check box?
		driver.get("https://www.ironspider.ca/forms/checkradio.htm");
		Thread.sleep(3000);
		// how many radio buttons in the web page.
		List<WebElement> allRadio = driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println("size : " + allRadio.size());
		System.out.println(" print all radio buttons one by one.");
		// verify radio button is selected or not.
		for( int i=0; i<allRadio.size(); i++) {
//			String value = allRadio.get(i).getAttribute("value");
			String radio1 = allRadio.get(i).getText();
			System.out.println( radio1);
		}
		/*
		Type property value is 'Radio' for radio button element
		the following are the possible operations on radio button 
		
		. how do you select radio button
		Print the number of radio buttons in the web page
		Capture all radio button print total number of radio button the webpage.
		validate radio button - check radio button is selected or Not. 
		if not selected then select radio button
			
		*/
	}
}
