package com.qunar.pageobject.flight;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class AddNewPassenger {
	AndroidDriver driver;
	public AddNewPassenger(AndroidDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_et_passenger_inland_name")
	public WebElement addNewPassengerName;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_et_credentials_num")
	public WebElement addNewPassengerId;
	@FindBy(name="完成")
	public WebElement finish;
	public void addNewPassenger(String name,String id){
		addNewPassengerName.clear();
		addNewPassengerName.sendKeys(name);
		addNewPassengerId.clear();
		addNewPassengerId.sendKeys(id);
		finish.click();
	}
}
