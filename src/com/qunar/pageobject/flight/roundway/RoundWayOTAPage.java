package com.qunar.pageobject.flight.roundway;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import com.qunar.pageobject.flight.FillOrderPage;
public class RoundWayOTAPage {
	AndroidDriver driver;
	public RoundWayOTAPage(AndroidDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_booking")
	public List<WebElement> bookingButtons;
	public FillOrderPage booking(){
		WebElement booking=bookingButtons.get(1);
		booking.click();
		return new FillOrderPage(driver);
	}
}
