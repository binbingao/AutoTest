package com.qunar.pageobject.flight.roundway;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class RoundResultPage {
	AndroidDriver driver;
	public RoundResultPage(AndroidDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv")
	public WebElement changeMode;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_domestic_flight_list_item1")
	public List<WebElement> flightList;
	public RoundWayOTAPage selectFlight(){
		if(changeMode.getText().equals("组合模式")){
			changeMode.click();
		}
		WebElement flight=flightList.get(1);
		flight.click();
		return new RoundWayOTAPage(driver);
	}
}
