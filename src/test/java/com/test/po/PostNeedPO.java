package com.test.po;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;

public class PostNeedPO {
	String[] sData=null;
	public Logger log = Logger.getLogger(this.getClass());
	AndroidDriver driver=null;
	HomePO homePo=null;
	LoginPO loginPo=null;
	
	public PostNeedPO(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	/* @Description- To post a need via search field in the home page
	 * @Author- Yashi Priya*/
	
	public void postNeedviaSearch(HomePO homePo, String sNeed)
	{
		try
		{
			homePo.getEleSearchTxtFld().sendKeys(sNeed);
			driver.hideKeyboard();
			Assert.assertTrue(homePo.getEleSearchResultLst().isDisplayed(), "Search result is not displayed");
			log.info("Search result is displayed successfully");
		}
		catch(Exception e)
		{
			log.info("Exception in method postNeedviaSearch");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @Description- To post a need by selecting an option from popular categories List
	 * @Author- Yashi Priya*/
	
	public void postNeedviaPopularCtgrs(HomePO homePo,String[] sData)
	{
		try
		{
			switch(sData[6])
			{
				case "Home Appliances" :
					homePo.getEleHomeAppliancesLnk().click();
					break;
					
				case "Interior Decoration" :
					homePo.getEleInteriorDecorationLnk().click();
					break;
					
				case "Pest Control" :
					homePo.getElePestControlLnk().click();
					break;
					
				case "Security Services" :
					homePo.getEleSecurityServicesLnk().click();
					break;
					
				case "Modular Kitchen" :
					homePo.getEleModularKitchenLnk().click();
					break;
					
				case "Event Organizers" :
					homePo.getEleEventOrganizersLnk().click();
					break;
					
				case "Computer Training" :
				homePo.getEleComputerTrainingLnk().click();
					break;
					
				case "Packers & Movers" :
					homePo.getElePackersMoversLnk().click();
					break;
					
				case "Catering Services" :
					homePo.getEleCateringServicesLnk().click();
					break;
					
				case "Website Services" :
					homePo.getEleWebsiteServicesLnk().click();
					break;
					
				case "Coaching & Tuitions" :
					homePo.getEleCoachingTuitionsLnk().click();
					break;
					
				case "Electrical Repairs" :
					homePo.getEleElectricalRepairs().click();
					break;
			}
			Assert.assertTrue(homePo.getEleChooseOptionTxt().isDisplayed(), "Choose option popup is not displayed");
			log.info("Choose option popup is successfully displayed");
			
		}
		catch(Exception e)
		{
			log.info("Exception in method postNeedviaPlrCtgrs");
			e.printStackTrace();
			Assert.fail();
		}
	}

}
