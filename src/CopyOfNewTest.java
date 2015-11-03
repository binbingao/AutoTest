

import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.qunar.pageobject.HomePage;
import com.qunar.pageobject.flight.FillOrderPage;
import com.qunar.pageobject.flight.FlightMainActivity;
import com.qunar.pageobject.flight.GoPayPage;
import com.qunar.pageobject.flight.SelectCity;
import com.qunar.pageobject.flight.SingleOTAPage;
import com.qunar.pageobject.flight.SingleResultPage;

public class CopyOfNewTest {
	AndroidDriver driver;
	FlightMainActivity mainActivy;
	HomePage homePage;
  @Test
  public void f() throws InterruptedException {
	  homePage.goFlight.click();
	  Thread.sleep(5000);//
	  mainActivy.changeTripCitys("上海", "重庆");
	  SingleResultPage singleResultPage=mainActivy.singleSearch();
	  Assert.assertEquals(singleResultPage.singlePageTitle.getText(), "上海  重庆");
	  SingleOTAPage singleOTAPage=singleResultPage.selectFlight();
	  System.out.println(singleOTAPage.getFLightInfo());
	  FillOrderPage fillOrderPage=singleOTAPage.bookingFlight();
	  GoPayPage goPayPage=fillOrderPage.creatOrder();
	  Assert.assertEquals("收银台", goPayPage.getPageTitle());
	  //Thread.sleep(3000);
	  
  }
  @BeforeClass
  public void beforeClass() throws Exception{
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
  }

  @AfterClass
  public void afterClass() {
	  driver.closeApp();//测试结束，关闭app
  }
}
