package com.validateLinks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoWebtableData {
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

	@Test
	public void getRole() throws InterruptedException {
		login("Admin", "admin123");

		// locate the Admin tab and click Admin tab.
		WebElement adminTab = driver.findElement(By.xpath("//*[@id='mainMenu']/ul/li[1]"));
		adminTab.click();

		String u_name = "CarlosEspinoza";
		List<WebElement> userNames = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr/td[2]"));

		for (WebElement str : userNames) {

			WebElement role_ele = driver
					.findElement(By.xpath("//*[contains(text(), '" + str.getText() + "')]/../../td[3]"));
			String actualRole = role_ele.getText();
			
			
			WebElement role_status = driver
					.findElement(By.xpath("//*[contains(text(), '" + str.getText() + "')]/../../td[5]"));
			String actualstatus = role_status.getText();

			System.out.println(str.getText() + " : " + actualRole + " : "+ actualstatus);

		}

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
