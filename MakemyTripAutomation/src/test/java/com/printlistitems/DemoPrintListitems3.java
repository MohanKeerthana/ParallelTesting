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
public class DemoPrintListitems3 {

	static WebDriver driver;
	static String url = "app login page url";

	@BeforeMethod
	public void setUp() {
		// open browser and open the hrm applicaiton login page.
	}

//select emp "Sara Tencrady" from emp search list.
	@Test
	public void test(String empName) throws InterruptedException {
		login("Admin", "admin123"); // call login method to login as admin.
		// navigate to admin tab
		selectEmp("Sara Tencrady");

	}

	public void selectEmp(String empName) {
		WebElement e_name_ele = driver.findElement(By.id("searchSystemUser_employeeName_empName"));
		// type sa ( sa is a substring of employee )
		e_name_ele.sendKeys("sara");
		List<WebElement> eName_li = driver.findElements(By.xpath("//*[@class='ac_results']/ul/li"));
		System.out.println("size of list : " + eName_li.size()); // print size list.
//print items witn index of 1. 2. 3.
		for (int i = 0; i < eName_li.size(); i++) {
			int j = i + 1;

			System.out.println(j + "." + eName_li.get(i).getText());
		}
// verify emp name is displayed in the list. if it is displayed then select an employee.
		for (int i = 0; i < eName_li.size(); i++) {
			String str_name = eName_li.get(i).getText();
			if (str_name.equalsIgnoreCase(empName)) {
				System.out.println(" Sara Tencrady is displayed in the list.");
				eName_li.get(i).click();
				break;
			}
		}
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
