package com.qunar.testcase.mainstream;

import java.util.Map;
import org.testng.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qunar.pageobject.flight.FillOrderPage;
import com.qunar.pageobject.flight.GoPayPage;
import com.qunar.pageobject.flight.SingleOTAPage;
import com.qunar.pageobject.flight.flightListPage.SingleResultPage;
import com.qunar.testcase.BaseTestCase;

public class DomesticSingleTest extends BaseTestCase{
	SingleResultPage singleResultPage;
	SingleOTAPage singleOTAPage;
	FillOrderPage fillOrderPage;
	Map<String,String> fillOrderPageAllFlightInfo;
	GoPayPage goPayPage;
	//String dCity="上海";
	//String aCity="重庆";
	@Parameters({"dCity","aCity"})
	@Test
	public void testFlightInfo(String dCity,String aCity){
		mainActivy.changeTripCitys(dCity, aCity);
		Map<String,String> flightInfos=mainActivy.getFlightInfo();
		Assert.assertEquals(flightInfos.get("dCity"),dCity);
		Assert.assertEquals(flightInfos.get("aCity"),aCity);
	}
	@Parameters({"dCity","aCity"})
	@Test
	public void testGoSingleFlightList(String dCity,String aCity){
		singleResultPage=mainActivy.singleSearch();
		Assert.assertEquals(singleResultPage.singlePageTitle.getText(), dCity+"  "+aCity);
	}
	@Test(dependsOnMethods={"testGoSingleFlightList"})
	public void testGoOta(){
		String flightInfo=singleResultPage.getFlightInfo();
		singleOTAPage=singleResultPage.selectFlight();
		String otaInfo=singleOTAPage.getFLightInfo();
		Assert.assertEquals(otaInfo, flightInfo);
	}
	@Test(dependsOnMethods={"testGoOta"})
	public void testBooking(){
		Map<String,String> otaPageAllFlightInfo=singleOTAPage.getAllFlightInfo();
		fillOrderPage=singleOTAPage.bookingFlight();
		fillOrderPageAllFlightInfo=fillOrderPage.getFlightInfors();
		Assert.assertEquals(fillOrderPage.getFillOrderPageTicketPrice(), otaPageAllFlightInfo.get("price"));
		Assert.assertEquals(fillOrderPageAllFlightInfo.get("depTime"), otaPageAllFlightInfo.get("depTime"));
		Assert.assertEquals(fillOrderPageAllFlightInfo.get("flightTime"), otaPageAllFlightInfo.get("flightTime"));
		Assert.assertEquals(fillOrderPageAllFlightInfo.get("arrTime"), otaPageAllFlightInfo.get("arrTime"));
		Assert.assertEquals(fillOrderPageAllFlightInfo.get("depAirport"), otaPageAllFlightInfo.get("depAirport"));
		Assert.assertEquals(fillOrderPageAllFlightInfo.get("depAirport"), otaPageAllFlightInfo.get("depAirport"));
		Assert.assertEquals(fillOrderPageAllFlightInfo.get("baseInfo"), otaPageAllFlightInfo.get("baseInfo"));	
	}
	@Test(dependsOnMethods={"testBooking"})
	public void testCreateOrder(){
		Map<String,String> passengerInfoAndTotalPrice=fillOrderPage.getPassengerInfoAndTotalPrice();
		goPayPage=fillOrderPage.creatOrder();
		Map<String,String> flightAndPassengerInfo=goPayPage.getFlightAndPassengerInfo();
		Assert.assertEquals(flightAndPassengerInfo.get("airCode"),fillOrderPageAllFlightInfo.get("flightCode"));
		Assert.assertEquals(flightAndPassengerInfo.get("depTime"),fillOrderPageAllFlightInfo.get("depTime"));
		Assert.assertEquals(flightAndPassengerInfo.get("arrTime"),fillOrderPageAllFlightInfo.get("arrTime"));
		Assert.assertEquals(flightAndPassengerInfo.get("depAirport"),fillOrderPageAllFlightInfo.get("depAirport"));
		Assert.assertEquals(flightAndPassengerInfo.get("arrAirport"),fillOrderPageAllFlightInfo.get("arrAirport"));
		Assert.assertEquals(flightAndPassengerInfo.get("name"),passengerInfoAndTotalPrice.get("passengerName"));
		Assert.assertEquals(flightAndPassengerInfo.get("cardID"),passengerInfoAndTotalPrice.get("passengerCardID"));
		Assert.assertEquals(flightAndPassengerInfo.get("contactName"),passengerInfoAndTotalPrice.get("contactName"));
		Assert.assertEquals(flightAndPassengerInfo.get("contactPhone"),passengerInfoAndTotalPrice.get("contactPhone"));
		Assert.assertEquals(flightAndPassengerInfo.get("totalPrice"),passengerInfoAndTotalPrice.get("totalPrice"));
		Assert.assertEquals(flightAndPassengerInfo.get("depDate"),fillOrderPageAllFlightInfo.get("depDate"));
	}	
}
