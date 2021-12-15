package com.dec14.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropDemo {
	@Test
	public void test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("http://demo.guru99.com/test/drag_drop.html");
Thread.sleep(6000);
		// Element which needs to drag.
		WebElement From = driver.findElement(By.xpath("//*[@id='credit2']/a"));

		// Element on which need to drop.
		WebElement To = driver.findElement(By.xpath("//*[@id='bank']/li"));

		// Using Action class for drag and drop.
		Actions act = new Actions(driver);

		// Dragged and dropped.
		act.dragAndDrop(From, To).build().perform();
		WebElement From2 = driver.findElement(By.xpath("//*[@id='credit2']/a"));

		// Using Action class for drag and drop.
//		         Actions act=new Actions(driver);					

		// Drag and Drop by Offset.
		act.dragAndDropBy(From2, 135, 40).build().perform();

	}
}
