package com.qunar.pageobject.flight.flightListPage;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import com.qunar.pageobject.flight.SingleOTAPage;
public class SingleResultPage {
	AndroidDriver  driver;
	public SingleResultPage(AndroidDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_list_city_name_tv")
	public WebElement singlePageTitle;
	@FindBy(id="android:id/list")
	public WebElement flightList;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_domestic_flight_list_item1")
	public List<WebElement> flights;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_btn_filter")
	public WebElement goFilter;
	public SingleOTAPage selectFlight(){
		flights.get(2).click();
		return new SingleOTAPage(driver);
	}
	public String getFlightInfo(){
		WebElement flight=flights.get(2);
		String flightInfo=flight.findElement(By.id("com.mqunar.atom.flight:id/atom_flight_tv_other_info")).getText();
		String[] flightInformation=flightInfo.split(" ");
		String infors=flightInformation[0]+" "+flightInformation[1];
		return infors;
	}
	
}
