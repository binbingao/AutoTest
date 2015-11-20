package com.qunar.pageobject.flight.flightListPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class ScreeningPage {
	public ScreeningPage(AndroidDriver driver){
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="仅直达")
	public WebElement onlyDirect;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_onOffButton")
	public WebElement switchDirectButton;
	@FindBy(name="起飞时段")
	public WebElement departureTimeSwitch;
	@FindBy(name="航空公司")
	public WebElement airlineCompany;
	@FindBy(name="机型")
	public WebElement aircraftModel;
	@FindBy(name="舱位")
	public WebElement cabinType;
}
