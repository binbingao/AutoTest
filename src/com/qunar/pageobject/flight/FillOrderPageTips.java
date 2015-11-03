package com.qunar.pageobject.flight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

import com.qunar.utils.CheckBaseInfoTool;

public class FillOrderPageTips {
	AndroidDriver driver;
	public FillOrderPageTips(AndroidDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_date")
	public WebElement flightDate;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_depCity")
	public WebElement depCity;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_arrCity")
	public WebElement arrCity;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_depTime")
	public WebElement depTime;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_arrTime")
	public WebElement arrTime;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_flightTime")
	public WebElement flightTime;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_depAirport")
	public WebElement depAirport;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_arrAirport")
	public WebElement arrAirport;
	@FindBy(id="com.mqunar.atom.flight:id/atom_flight_tv_baseInfo")
	public WebElement baseInfo;
	public Map<String,String> getAllFlightInfo(){
		Map<String,String> allInfo=new HashMap<String,String>();
		allInfo.put("depDate", flightDate.getText());
		allInfo.put("depTime", depTime.getText());
		allInfo.put("flightTime", flightTime.getText());
		allInfo.put("arrTime", arrTime.getText());
		allInfo.put("depAirport", depAirport.getText());
		allInfo.put("arrAirport", arrAirport.getText());
		allInfo.put("baseInfo", CheckBaseInfoTool.trim(baseInfo.getText(), "  "));
		allInfo.put("depCity", depCity.getText());
		allInfo.put("arrCity", arrCity.getText());
		allInfo.put("flightCode", getFlightCode().get("flightCode"));
		return allInfo;
	}
	public Map<String,String> getFlightCode(){
		Map<String,String> flightCode=new HashMap<String,String>();
		String baseInfos=baseInfo.getText();
		String[] infors=baseInfos.split("  ");
		flightCode.put("flightCode", infors[0]);
		return flightCode;
	}
	public void closeTips(){
		driver.navigate().back();
	}
}
