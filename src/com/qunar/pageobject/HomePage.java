package com.qunar.pageobject;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	AndroidDriver driver;
	public HomePage(AndroidDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	//go flight
	@FindBy(id="com.mqunar.atom.alexhome:id/atom_alexhome_mod_flight")
	public WebElement goFlight;
	@FindBy(id="com.mqunar.atom.attemper:id/atom_atte_ll_title")
	public WebElement updateDialog;
	@FindBy(id="com.mqunar.atom.attemper:id/atom_atte_iv_close")
	public WebElement closeUpdateDialog;
	@FindBy(id="com.mqunar.atom.alexhome:id/atom_alexhome_dialog_del")
	public WebElement closeNewsDialog;
	public boolean closeUpdateDialogMethod(){
		boolean flag=false;
		if(updateDialog.isDisplayed()){
			closeUpdateDialog.click();
			flag=true;
		}else{
			flag=true;
		}
		return flag;
	}
	public boolean closeNewsDialogMethod(){
		boolean flag=false;
		if(closeNewsDialog.isDisplayed()){
			closeNewsDialog.click();
			flag=true;
		}
		else{
			flag=true;
		}
		return flag;
	}
}
