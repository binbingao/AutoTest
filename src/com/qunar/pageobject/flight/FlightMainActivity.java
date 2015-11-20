package com.qunar.pageobject.flight;

import java.util.HashMap;
import java.util.Map;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qunar.pageobject.flight.flightListPage.SingleResultPage;
import com.qunar.pageobject.flight.roundway.RoundResultPage;
import com.qunar.utils.WaitElement;

public class FlightMainActivity {
	AndroidDriver driver;
	public FlightMainActivity(AndroidDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	//flight homepage title
	@FindBy(id="com.mqunar.patch:id/pub_pat_auto_scale_textview")
	public WebElement flightTitle;
	//single tab
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_rb_sigle")
	public WebElement singleTab;
	//round tab
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_rb_round")
	public WebElement roundTab;
	//destination city
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_dep_city")
	public WebElement dCity;
	//arrive city
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_arr_city")
	public WebElement aCity;
	//change dCity and aCity
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_btn_swap")
	public WebElement changeCity;
	//single flight date
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_dep_date")
	public WebElement changeDate;
	//search button
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_btn_search")
	public WebElement searchButton;
	//change flight city
	public void changeTripCitys(String dCity,String aCity){
		SelectCity selectCity=new SelectCity(driver);
		this.dCity.click();
		selectCity.selectDCity(dCity);
		this.aCity.click();
		selectCity.selectACity(aCity);
	}
	//single trip
	public SingleResultPage singleSearch(){
		searchButton.click();
		return new SingleResultPage(driver);
	}
	public Map<String,String> getFlightInfo(){
		Map<String,String> flightInfo=new HashMap<String,String>();
		flightInfo.put("dCity", dCity.getText());
		flightInfo.put("aCity", aCity.getText());
		//flightInfo.put("date", changeDate.getText());
		return flightInfo;
	}
	public RoundResultPage roundSearch(){
		roundTab.click();
		searchButton.click();
		return new RoundResultPage(driver);
	}
}
