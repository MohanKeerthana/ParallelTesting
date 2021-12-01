package com.xpathdemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class xPathDemo1 {
	static WebDriver driver;
	static String url = "https://yandex.com/";

	@BeforeMethod
	public void setUp() {
		// webdriver manger setup to use the browser driver.
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// launch the application.
		driver.get(url);
	}

	@Test
	public void testPrintList() {
		WebElement el = driver.findElement(By.xpath("//*[@class='worldwide__list']"));
		System.out.println(el.getText());
		List<WebElement> li = driver.findElements(By.xpath("//*[@class='worldwide__list']/child::a"));
		for (WebElement child : li) {
			System.out.println("child : " + child.getText());
		}
		for (int i = 1; i <= li.size(); i++) {

//	String childname = driver.findElement(By.xpath("//*[@class='worldwide__list']/child::a["+i+"]")).getText();
//			
//	System.out.println("child name from anoterh for loop : "+childname);

			System.out.println(
					driver.findElement(By.xpath("//*[@class='worldwide__list']/child::a[" + i + "]")).getText());
		}

	}

}
