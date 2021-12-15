package com.dec14.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {
	@Test
	public void mouseHoveronWebElement() {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login"); // organce rml application login url
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement email = driver.findElement(By.id("txtUsername"));
		email.clear();
		email.sendKeys("Admin");
		WebElement pwd = driver.findElement(By.id("txtPassword"));
		pwd.clear();
		pwd.sendKeys("admin123");

		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		loginBtn.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_pim_viewPimModule")));
		
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		
		Actions action = new Actions(driver);
		WebElement config_ele = driver.findElement(By.id("menu_pim_Configuration"));
		
	
		
		
		List<WebElement> li = driver.findElements(By.xpath("//*[@id='menu_pim_Configuration']/../ul/li"));
		
		for(WebElement el : li) {
			System.out.println(el.getText());
		}
		
		
		
	}

}
