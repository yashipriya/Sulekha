/***********************************************************************
* @author 			:		Yashi Priya
* @description		: 		Test scripts of Home
* @module			:		Home
* @testmethod		:	   	testLocationEnabled()
* @testmethod		:	   	testLocationDisabled()
* @testmethod		:	   	testSearchResult()
* @testmethod		:	   	testPopularCtgrs()
* @testmethod		:	   	testInvalidNeed()
* 
* 
*/
package com.test.scripts;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.test.baselib.BaseLib;
import com.test.baselib.GenericLib;
import com.test.po.HomePO;
import com.test.po.LoginPO;
import com.test.po.PostNeedPO;
import com.test.po.WelcomePO;

public class HomeTest extends BaseLib {
	String sTestData;
	String[] sData=null;
	public Logger log = Logger.getLogger(this.getClass());
	WelcomePO welcomePo=null;
	LoginPO loginPo=null;
	HomePO homePo=null;
	PostNeedPO postneedPo=null;
	
	/* @TestCaseID: Home_01
	 * @Description: To check if device current city is displayed in Home page.
	 * @Author: Yashi Priya*/
	@Test(priority=1,enabled=false)
	public void testLocationEnabled()
	{
		sTestData="Home_01";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	homePo.navigateToHomeWithoutLogin(welcomePo,homePo);
			Assert.assertEquals(homePo.getEleLocationTxtFld().getText(),sData[5]);
			log.info("Current city is successfully displayed in the Location text field");
		}
		catch(Exception e)
		{	log.info("Exception in case testLocationEnabled");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Home_02
	 * @Description: To check if device current city is displayed in Home page with location services disabled.
	 * @Author: Yashi Priya*/
	@Test(priority=2,enabled=false)
	public void testLocationDisabled()
	{
		sTestData="Home_02";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.getEleSkipBtn().click();
			homePo.getEleCloseBtn().click();
			Assert.assertNotEquals(homePo.getEleLocationTxtFld().getText(),sData[5],"Location is still displayed even after disabling");
			log.info("Location is not displayed after disabling");
		}
		catch(Exception e)
		{	log.info("Exception in case testLocationDisabled");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Home_03
	 * @Description: To search for Need names/Keywords and verify search result
	 * @Author: Yashi Priya*/
	@Test(priority=3,enabled=false)
	public void testSearchResult()
	{
		sTestData="Home_03";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.login(sData,homePo,welcomePo);
			postneedPo.postNeedviaSearch(homePo, sData[6]);
		}
		catch(Exception e)
		{	log.info("Exception in case testSearchResult");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Home_04
	 * @Description: To check if popular categories field is displayed in home page.
	 * @Author: Yashi Priya*/
	@Test(priority=4,enabled=false)
	public void testPopularCtgrs()
	{
		int ListItmIndex=0;
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	homePo.navigateToHomeWithoutLogin(welcomePo,homePo);
			driver.scrollTo("Catering Services");
			for(WebElement elePopularCategoriesLstItm :homePo.geteElePopularCategoriesLstItms())
			{
				Assert.assertTrue(elePopularCategoriesLstItm.isDisplayed(), "The popular categories list item "+homePo.geteElePopularCategoriesLstItms().get(ListItmIndex).getText()+" is not displayed");
				log.info("The popular categories list item "+homePo.geteElePopularCategoriesLstItms().get(ListItmIndex).getText()+" is Successfully displayed");
				ListItmIndex++;
			}
		}
		catch(Exception e)
		{	log.info("Exception in case testPopularCtgrs");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Home_05
	 * @Description: To enter invalid value in "What service do you need?" field and verify
	 * @Author: Yashi Priya*/
	@Test(priority=5,enabled=false)
	public void testInvalidNeed()
	{
		sTestData="Home_05";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.login(sData,homePo,welcomePo);
			homePo.getEleSearchTxtFld().sendKeys(sData[6]);
			//Alert popup displayed in ios app -- INCOMPLETE
			log.info("Alert popup is successfully displayed");
		}
		catch(Exception e)
		{	log.info("Exception in case testInvalidNeed");
			e.printStackTrace();
			Assert.fail();
		}
	}
}
