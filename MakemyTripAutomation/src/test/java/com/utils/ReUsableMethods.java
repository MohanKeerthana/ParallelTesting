package com.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReUsableMethods {

	public void selectListItem(WebElement role, String roletype) {
		Select se = new Select(role);
		se.selectByVisibleText(roletype);
	}
}
