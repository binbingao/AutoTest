package com.qunar.pageobject.flight;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectCity {
	AndroidDriver  driver;
	public SelectCity(AndroidDriver driver){
		this.driver=driver;
	}
	public void selectDCity(String dCity){
		WebElement dcity=driver.findElement(By.name(dCity));
		dcity.click();
	}
	public void selectACity(String aCity){
		WebElement acity=driver.findElement(By.name(aCity));
		acity.click();
	}
}
