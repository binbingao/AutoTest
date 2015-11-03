package com.qunar.testcase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import com.qunar.pageobject.HomePage;
import com.qunar.pageobject.flight.FlightMainActivity;

public class BaseTestCase {
	public AndroidDriver driver;
	public FlightMainActivity mainActivy;
	public HomePage homePage;
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() throws Exception {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");//设置系统版本
	  caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//设置平台为安卓
	  caps.setCapability(MobileCapabilityType.DEVICE_NAME,"e4998228");//设备名称，需要和appium设置中对应
	  caps.setCapability(MobileCapabilityType.APP_PACKAGE,"com.Qunar");//app package信息
	  caps.setCapability(MobileCapabilityType.APP_ACTIVITY,"com.mqunar.splash.SplashActivity");//要启动的activity
	  driver = new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"),caps);//调用appium的url  appium在本机所以是127.0.0.1
	  mainActivy=new FlightMainActivity(driver);
	  homePage=new HomePage(driver);
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);//超时时间
	  homePage.closeUpdateDialogMethod();
	  homePage.closeNewsDialogMethod();
	  homePage.goFlight.click();
  }

  @AfterSuite
  public void afterSuite() {
	  driver.closeApp();
  }
}
