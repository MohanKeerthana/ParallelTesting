package com.deleteCookies;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * Check box operations.
 */
public class DemoCheckBoxs {

	@Test
	public void selectCheckBoxes() throws InterruptedException {
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
		// how many check boxes in the web page.
		List<WebElement> ch_boxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
		int numberOfCheckBoxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).size();
		System.out.println("total number of check boxes in the page : " + numberOfCheckBoxes);
		System.out.println("size : " + ch_boxes.size());
		// select red color checkbox.
		WebElement red_Ck_Box = driver.findElement(By.xpath("//input[@value='red']"));
		red_Ck_Box.click();
		//if red check is not selected then select red check box. if red check box already selected then unselect 
		// the red checkbox and select yellow check box.
		if (!red_Ck_Box.isSelected()) {
			System.out.println("check box is not selected.");
			red_Ck_Box.click();
		} else {
			System.out.println("red color check box is already selected. ");
			red_Ck_Box.click();
			driver.findElement(By.xpath("//input[@value='yellow']")).click();
		}
	}
}
