package com.qunar.pageobject.flight;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qunar.utils.CheckBaseInfoTool;

import io.appium.java_client.android.AndroidDriver;

public class FillOrderPage {
	AndroidDriver driver;
	AddPassengerPage addPassengerPage;
	public FillOrderPage(AndroidDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_btn_add_passenger")
	public WebElement addPassengerButton;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_passenger_name")
	public WebElement passengerName;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_et_contact_name")
	public WebElement contactName;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_et_contact_phone")
	public WebElement contactPhone;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_btn_next_step")
	public WebElement creatOrder;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_price_info")
	public WebElement priceInfo;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_flight_info_one")
	public WebElement flightinfors;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_passenger_card")
	public WebElement passengerCard;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_ticket_total_price")
	public WebElement totalPrice;
	//fill order info
	public  void addPassenger(){
		addPassengerButton.click();
		addPassengerPage=new AddPassengerPage(driver);
		addPassengerPage.selectPassenger();	
	}
	//add contact person
	public void addContactInfo(String name,String phone){
		if("".equals(contactName.getText())){
			contactName.sendKeys(name);
		}
		if("".equals(contactPhone.getText())){
			contactPhone.sendKeys(phone);
		}
	}
	//fill order
	public void fillOrder(){
		if("".equals(passengerName.getText())){
			addPassenger();
		}
		addContactInfo("小明", "13522467786");
	}
	//creat order 
	public GoPayPage creatOrder(){
		fillOrder();
		creatOrder.click();
		return new GoPayPage(driver);
	}
	public String getFillOrderPageTicketPrice(){
		String info=priceInfo.getText();
		String[] infors=info.split("¥");
		return infors[1];
	}
	public Map<String,String> getFlightInfors(){
		flightinfors.click();
		FillOrderPageTips fillOrderPageTips=new FillOrderPageTips(driver);
		Map<String,String> flightInfors=fillOrderPageTips.getAllFlightInfo();
		fillOrderPageTips.closeTips();
		return flightInfors;
	}
	public Map<String,String> getPassengerInfoAndTotalPrice(){
		Map<String,String> passengerInfoAndTotalPrice=new HashMap<String,String>();
		passengerInfoAndTotalPrice.put("passengerName", getPassengerName());
		passengerInfoAndTotalPrice.put("passengerCardID", getPassengerCardID());
		passengerInfoAndTotalPrice.put("contactName", contactName.getText());
		passengerInfoAndTotalPrice.put("contactPhone", CheckBaseInfoTool.trim(contactPhone.getText()," "));
		passengerInfoAndTotalPrice.put("totalPrice", totalPrice.getText());
		return passengerInfoAndTotalPrice;
	}
	public String getPassengerName(){
		String passengerInfo=passengerName.getText();
		String[] infors=passengerInfo.split(" ");
		String name=infors[0];
		return name;
	}
	public String getPassengerCardID(){
		String passengerInfo=passengerCard.getText();
		String[] infors=passengerInfo.split("    ");
		return CheckBaseInfoTool.trim(infors[1]," ");
	}
}
