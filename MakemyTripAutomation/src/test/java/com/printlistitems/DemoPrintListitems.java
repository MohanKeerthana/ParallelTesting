package com.printlistitems;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
// DemoPrintUserRoleList
public class DemoPrintListitems {
	
	
	//intialize webdriver
		//open chrome browser
		
		//maximize the browser
		
		//open the application
	
	static WebDriver driver;
	static String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

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
	public void test() throws InterruptedException{
		login("Admin", "admin123"); // call login method to login as admin.
		
		String str1 = "All", Str2 = "Admin", Str3 = "ESS";
		
		WebElement adminTab = driver.findElement(By.xpath("//*[@id='mainMenu']/ul/li[1]"));
		adminTab.click();
		Thread.sleep(5000);		
		WebElement userRole_List = driver.findElement(By.id("searchSystemUser_userType"));
		//		Select se = new Select(userRole_List);
		Select se = new Select(driver.findElement(By.id("searchSystemUser_userType")));
		se.selectByIndex(2);		
		List<WebElement> li = se.getOptions();
		String actualVal = li.get(2).getText();
		System.out.println("selected value : "+ actualVal);
		Assert.assertEquals(Str3, actualVal, "failed. selected item not matched.");
//		Assert.assertEquals(Exp, actual, " descriotiopn")
		
		Thread.sleep(3000);
		
		WebElement e_name_ele = driver.findElement(By.id("searchSystemUser_employeeName_empName"));
		
		// type sa
		e_name_ele.sendKeys("sa");	
		
		se.selectByIndex(1);
		String actualVal2 = li.get(1).getText();
		System.out.println("selected value : "+ actualVal2);
		Thread.sleep(3000);
		
		
		se.selectByIndex(0);
		String actualVal3 = li.get(0).getText();
		System.out.println("selected value : "+ actualVal3);
		Thread.sleep(3000);
		
		//implement the below items like above.
		se.selectByValue("2");
		Thread.sleep(3000);
		se.selectByValue("1");
		Thread.sleep(3000);
		se.selectByValue("0");
		Thread.sleep(3000);
		
		se.selectByVisibleText("ESS");
		Thread.sleep(3000);
		se.selectByVisibleText("Admin");
		Thread.sleep(3000);
		se.selectByVisibleText("All");
		Thread.sleep(3000);
		
		
		
	}

	public void login(String userName, String password) throws InterruptedException {
		WebElement email = driver.findElement(By.id("txtUsername"));
		email.clear();
		email.sendKeys(userName);

		WebElement pwd = driver.findElement(By.id("txtPassword"));
		pwd.clear();
		pwd.sendKeys(password);

		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		loginBtn.click();
		Thread.sleep(3000);
	}
}
