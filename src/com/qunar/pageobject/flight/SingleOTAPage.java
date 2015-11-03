package com.qunar.pageobject.flight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import com.qunar.utils.CheckBaseInfoTool;

import io.appium.java_client.android.AndroidDriver;

public class SingleOTAPage {
	AndroidDriver driver;
	public SingleOTAPage(AndroidDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_baseInfo")
	public WebElement baseInfo;
	//@FindBy(id="com.mqunar.atom.flight:id/atom_flight_booking")
	//public List<WebElement> bookingButtons;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_depData")
	public WebElement depDate;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_depTime")
	public WebElement depTime;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_flightTime")
	public WebElement flightTime;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_arrTime")
	public WebElement arrTime;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_depAirport")
	public WebElement depAirport;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_arrAirport")
	public WebElement arrAirport;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_ota_list_right")
	public List<WebElement> priceAndBooking;
	public FillOrderPage bookingFlight(){
		WebElement bookingButton=priceAndBooking.get(3).findElement(By.id("com.mqunar.atom.flight:id/atom_flight_booking"));
		bookingButton.click();
		return new FillOrderPage(driver);
	}
	public String getFLightInfo(){
		String info=baseInfo.getText();
		String[] infoList=info.split("   ");
		String flightInformation=infoList[0]+" "+infoList[1];
		return flightInformation;
	}
	public String getFlightPrice(){
		WebElement bookingPrice=priceAndBooking.get(3).findElement(By.id("com.mqunar.atom.flight:id/atom_flight_tv_ota_price"));
		String price=bookingPrice.getText();
		return price;
	}
	public Map<String,String> getAllFlightInfo(){
		Map<String,String> allInfo=new HashMap<String,String>();
		allInfo.put("depDate", depDate.getText());
		allInfo.put("depTime", depTime.getText());
		allInfo.put("flightTime", flightTime.getText());
		allInfo.put("arrTime", arrTime.getText());
		allInfo.put("depAirport", depAirport.getText());
		allInfo.put("arrAirport", arrAirport.getText());
		allInfo.put("price", getFlightPrice());
		allInfo.put("baseInfo", CheckBaseInfoTool.trim(baseInfo.getText(), "   "));
		return allInfo;
	}
}
