package com.qunar.pageobject.flight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class GoPayPage {
	AndroidDriver driver;
	public GoPayPage(AndroidDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_order_no")
	public WebElement orderNo;
	@FindBy(id="com.mqunar.patch:id/pub_pat_auto_scale_textview")
	public WebElement payPageTitle;
	@FindBy(id="com.mqunar.pay:id/pub_pay_btnFromDrag")
	public WebElement closeCashierButton;
	@FindBy(id="com.mqunar.pay:id/pub_pay_txTotalPrice")
	public WebElement totalPrice;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_value")
	public List<WebElement> passengerNameAndCardID;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_dep_date")
	public WebElement depDate;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_dep_arr_city")
	public WebElement depAndArrCity;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_aircode")
	public WebElement airCode;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_dep_time")
	public WebElement depTime;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_arr_time")
	public WebElement arrTime;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_dep_airport")
	public WebElement depAirport;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_arr_airport")
	public WebElement arrAirport;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_contact_name")
	public WebElement contactName;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_contact_phone")
	public WebElement contactPhone;
	
	
	public String getPageTitle(){
		return payPageTitle.getText();
	}
	
	public String getOrderNo(){
		return orderNo.getText();
	}
	public Map<String,String> getPassengerNameAndCardID(){
		Map<String,String> passengerNameAndCardIDList=new HashMap<String,String>();
		WebElement names=passengerNameAndCardID.get(0);
		String nameInfos=names.getText();
		String[] nameList=nameInfos.split("    ");
		String name=nameList[0];
		passengerNameAndCardIDList.put("name", name);
		passengerNameAndCardIDList.put("cardID", passengerNameAndCardID.get(1).getText());
		return passengerNameAndCardIDList;
	}
	public Map<String,String> getFlightAndPassengerInfo(){
		String totalPrices=totalPrice.getText();
		closeCashierButton.click();
		Map<String,String> passengerNameAndCardIDList=getPassengerNameAndCardID();
		Map<String,String> flightAndPassengerInfo=new HashMap<String,String>();
		flightAndPassengerInfo.put("totalPrice", totalPrices);
		flightAndPassengerInfo.put("depDate", depDate.getText());
		flightAndPassengerInfo.put("depAndArrCity", depAndArrCity.getText());
		flightAndPassengerInfo.put("airCode", airCode.getText());
		flightAndPassengerInfo.put("depTime", depTime.getText());
		flightAndPassengerInfo.put("arrTime", arrTime.getText());
		flightAndPassengerInfo.put("depAirport", depAirport.getText());
		flightAndPassengerInfo.put("arrAirport", arrAirport.getText());
		flightAndPassengerInfo.put("name", passengerNameAndCardIDList.get("name"));
		flightAndPassengerInfo.put("cardID", passengerNameAndCardIDList.get("cardID"));
		flightAndPassengerInfo.put("contactName", contactName.getText());
		flightAndPassengerInfo.put("contactPhone", contactPhone.getText());
		return flightAndPassengerInfo;
	}
}
