package com.qunar.pageobject.flight;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
public class AddPassengerPage {
	AndroidDriver driver;
	List<WebElement> passengerList;
	public AddPassengerPage(AndroidDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
		passengerList=driver.findElements(By.id("com.mqunar.atom.flight:id/atom_flight_cb"));
	}
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_title_sure")
	public WebElement sureButton;
	
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_ll_add_passenger")
	public WebElement addNewPassenger;
	
	
	public void selectPassenger(){
		if(passengerList.size()>0){
			//passenger list >0 select a passenger
			boolean hasPassengerSelected =false;
			Iterator<WebElement> it=passengerList.iterator();
			while(it.hasNext()){
				WebElement checkBox=it.next();
				if(checkBox.isEnabled()){
					hasPassengerSelected=true;
				}
			}
			if(!hasPassengerSelected){
				passengerList.get(0).click();
			}
			sureButton.click();
		}
		else{
			//passenger is null add a new 
			AddNewPassenger addNew=new AddNewPassenger(driver);
			addNew.addNewPassenger("方元", "130731198904090319");
			sureButton.click();	
		}
	}
}
