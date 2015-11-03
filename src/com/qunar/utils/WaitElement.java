package com.qunar.utils;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
public class WaitElement {
	public static AndroidDriver driver;
	public static boolean waitElement(WebElement webElement){
		return webElement.isDisplayed();
	}
	public static void waitElement(AndroidDriver driver,final String elementIdentification){
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver d) {
	            return d.getTitle().toLowerCase().startsWith(elementIdentification);
	        }
	    });
	}
}
