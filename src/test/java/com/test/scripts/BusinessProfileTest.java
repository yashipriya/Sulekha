/***********************************************************************
* @author 			:		Yashi Priya
* @description		: 		Test scripts of Business Profile page
* @module			:		Business Profile
* @testmethod		:	   	testBusinessProfilePage()
* @testmethod		:	   	testSMStap()
* @testmethod		:	   	testShortlistTap()
* @testmethod		:	   	testRemoveShortlistTap()
* @testmethod		:	   	testAddressTap()
* @testmethod		:	   	testBusinessImgDisplay()
* @testmethod		:	   	testServicesOffered()
* @testmethod		:	   	testAnyReview()
* @testmethod		:	   	testMoreReview()
* @testmethod		:	   	testWriteReview()
* @testmethod		:	   	testSubmitReview()
* @testmethod		:	   	testWebIcon()
*/
package com.test.scripts;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.test.baselib.BaseLib;
import com.test.baselib.GenericLib;
import com.test.po.BusinessProfilePO;
import com.test.po.HomePO;
import com.test.po.LoginPO;
import com.test.po.MyNeedsDashboardPO;
import com.test.po.WelcomePO;

public class BusinessProfileTest extends BaseLib {
	String sTestData=null;
	String[] sData=null;
	public Logger log = Logger.getLogger(this.getClass());
	HomePO homePo=null;
	MyNeedsDashboardPO myneedsdashboardPo=null;
	BusinessProfilePO businessprofilePo=null;
	LoginPO loginPo=null;
	WelcomePO welcomePo=null;

	/* @TestCaseID: BusinessProfile_01
	 * @Description: To check the Business Profile page and verify all the elements present in the page.
	 * @Author: Yashi Priya*/
	@Test(priority=1,enabled=true)
	public void testBusinessProfilePage()
	{
		int businessProfileIcnLstItmIndex=0;
		sTestData="BusinessProfile_01";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		int businessProfileIcnLstSize=0;
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	
			loginPo.login(sData, homePo, welcomePo);
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo);
			Assert.assertTrue(businessprofilePo.getEleLocationTxt().isDisplayed(), "Business location is not displayed");
			log.info("Business location is displayed successfully");
			Assert.assertTrue(businessprofilePo.getEleScoreTxt().isDisplayed(), "Business Score is not displayed");
			log.info("Business score is displayed successfully");
			Assert.assertTrue(businessprofilePo.getEleRatingBar().isDisplayed(), "Business rating is not displayed");
			log.info("Business rating is displayed successfully");
			Assert.assertTrue(businessprofilePo.getEleCallIcn().isDisplayed(), "Business Call icon is not displayed");
			log.info("Business call icon is displayed successfully");
			businessProfileIcnLstSize=businessprofilePo.getEleBusinessProfileIcnLst().size();
			System.out.println(businessProfileIcnLstSize);
			
			int j=1;
			for(int i=0;i<businessProfileIcnLstSize;i++)
			{
				Assert.assertTrue(businessprofilePo.getEleBusinessProfileIcnLst().get(i).isDisplayed(), "eleBusinessProfileIcnLstItm "+businessprofilePo.getEleBusinessProfileIcnLst().get(i)+" is not displayed");
				System.out.println(driver.findElement(By.xpath("(//android.widget.ImageView/..//android.widget.TextView[1])["+j+"]")).getText()+" icon is displayed");
				log.info(driver.findElement(By.xpath("(//android.widget.ImageView/..//android.widget.TextView[1])["+j+"]")).getText()+" icon is successfully displayed");
				j=j+1;
				/*try
				{				
					if(i==3)
					{
						j=1;
						driver.scrollTo("About");
						businessProfileIcnLstSize=businessprofilePo.getEleBusinessProfileIcnLst().size();
						System.out.println(driver.findElement(By.xpath("(//android.widget.ImageView/..//android.widget.TextView[1])["+j+"]")).getText());
						log.info(driver.findElement(By.xpath("(//android.widget.ImageView/..//android.widget.TextView[1])["+j+"]")).getText()+"icon is successfully displayed");
					j=j+1;
					}
				}
				catch(Exception e)
				{
					
				}*/
				System.out.println(businessProfileIcnLstSize);
				if(i==3)
				{
					j=1;
				toDisplayBuisnessFeatures("About",businessProfileIcnLstSize,j);
				j=j+1;
				}
				System.out.println(businessProfileIcnLstSize);
				
				
				
				if(i==6)
				{
					j=1;
					toDisplayBuisnessFeatures("Reviews",businessProfileIcnLstSize,j);
					i=--i;
					i=--i;
					i=--i;
					i=--i;
					i=--i;
					i=--i;
				}
				
				/*
				try
				{				
					if(i==6)
					{	
						j=1;
						driver.scrollTo("Reviews");
						businessProfileIcnLstSize=businessprofilePo.getEleBusinessProfileIcnLst().size();
						//System.out.println(businessProfileIcnLstSize);
						System.out.println(driver.findElement(By.xpath("(//android.widget.ImageView/..//android.widget.TextView[1])["+j+"]")).getText()+" is displayed.");
						log.info(driver.findElement(By.xpath("(//android.widget.ImageView/..//android.widget.TextView[1])["+j+"]")).getText()+" icon is successfully displayed");
						j=j+1;
						i=--i;
						i=--i;
						i=--i;
						i=--i;
						i=--i;
						i=--i;
					}
					
				
				}
				catch(Exception e)
				{
					
				}*/
				
				
				
			}
			//Assert.assertTrue(businessprofilePo.getEleBusinessProfileIcnLst().get(0).isDisplayed(), "Business work call icon is not displayed");
			//log.info("Business work call icon is displayed successfully");
			/*Assert.assertTrue(businessprofilePo.getEleAddressLnk().isDisplayed(), "Business Address link is not displayed");
			log.info("Business Address link is displayed successfully");
			Assert.assertTrue(businessprofilePo.getEleSMSIcn().isDisplayed(), "Business SMS icon is not displayed");
			log.info("Business SMS icon is displayed successfully");
			Assert.assertTrue(businessprofilePo.getEleEmailIDLnk().isDisplayed(), "Business email link is not displayed");
			log.info("Business email link is displayed successfully");
			Assert.assertTrue(businessprofilePo.getEleShortlistIcn().isDisplayed(), "Business shortlist icon is not displayed");
			log.info("Business shortlist icon is displayed successfully");
			driver.scrollTo("Website");
			Assert.assertTrue(businessprofilePo.getEleImageLst().isDisplayed(), "Business image list is not displayed");
			log.info("Business image list is displayed successfully");
			Assert.assertTrue(businessprofilePo.getEleWebIcn().isDisplayed(), "Business web link is not displayed");
			log.info("Business web link is displayed successfully");
			Assert.assertTrue(businessprofilePo.getEleServicesOfrdTxt().isDisplayed(), "Business services offered section is not displayed");
			log.info("Business services offered section is displayed successfully");
			Assert.assertTrue(businessprofilePo.getEleReviewLnk().isDisplayed(), "Business Review is not displayed");
			log.info("Business review is displayed successfully");
			Assert.assertTrue(businessprofilePo.getEleVIEWMOREREVIEWSBtn().isDisplayed(), "Business 'view more review' button is not displayed");
			log.info("Business 'view more review' button is displayed successfully");
			Assert.assertTrue(businessprofilePo.getEleAboutTxt().isDisplayed(), "Business about section is not displayed");
			log.info("Business about section is displayed successfully");
			businessprofilePo.getEleVIEWMOREREVIEWSBtn().click();
			Assert.assertTrue(businessprofilePo.getEleWriteReviewIcn().isDisplayed(), "Business WriteReview icon is not displayed");
			log.info("Business WriteReview icon is displayed successfully");
			Assert.assertTrue(businessprofilePo.getEleSearchIcn().isDisplayed(), "Business search icon is not displayed");
			log.info("Business search icon is displayed successfully");*/
		}
		catch(Exception e)
		{	log.info("Exception in case testBusinessProfilePage");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	public void toDisplayBuisnessFeatures(String scrollingEle,int businessProfileIcnLstSize, int j)
	{
	
		
	
				driver.scrollTo(scrollingEle);
				businessProfileIcnLstSize=businessprofilePo.getEleBusinessProfileIcnLst().size();
				System.out.println(businessProfileIcnLstSize);
				System.out.println(j);
				System.out.println(driver.findElement(By.xpath("(//android.widget.ImageView/..//android.widget.TextView[1])["+j+"]")).getText());
				log.info(driver.findElement(By.xpath("(//android.widget.ImageView/..//android.widget.TextView[1])["+j+"]")).getText()+"icon is successfully displayed");
			
	}
	
	/* @TestCaseID: BusinessProfile_02
	 * @Description: To tap on SMS icon and verify if message popup is displayed.
	 * @Author: Yashi Priya*/
	@Test(priority=2,enabled=false)
	public void testSMStap()
	{
		sTestData="BusinessProfile_02";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.login(sData, homePo, welcomePo);
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo);
			businessprofilePo.getEleSMSIcn().click();
			Assert.assertTrue(businessprofilePo.getEleNewMsgTxt().isDisplayed(), "Message popup is not displayed");
			log.info("Message popup is successfully displayed");
			Assert.assertTrue(businessprofilePo.getEleSMSToTxtFld().isDisplayed(), "Message popup is not displayed with the to field containing business number");
			log.info("Message popup with business number in 'To' field is successfully displayed");
		}
		catch(Exception e)
		{	log.info("Exception in case testSMStap" );
			e.printStackTrace();
			Assert.fail();
		}	
	}
	
	/* @TestCaseID: BusinessProfile_03
	 * @Description: To tap on Shortlist icon and verify.
	 * @Author: Yashi Priya*/
	@Test(priority=3,enabled=false)
	public void testShortlistTap()
	{
		sTestData="BusinessProfile_03";
		sData=GenericLib.toReadExcelData(sTestData);
		String sBusinessName=null;
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.login(sData, homePo, welcomePo);
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo);
			sBusinessName=businessprofilePo.getEleBusinessNameTxt().getText();
			businessprofilePo.getEleShortlistIcn().click();
			//toast message
			welcomePo.getEleBackArwIcn().click();
			welcomePo.getEleBackArwIcn().click();
			homePo.getEleShortlistTab().click();
			Assert.assertEquals(sBusinessName, myneedsdashboardPo.getEleBusinessNameLstItm().getText(),"Shortlisted business is not seen under shortlist tab");
			log.info("Shortlisted business is successfully reflected under shortlist tab");
		}
		catch(Exception e)
		{	log.info("Exception in case testShortlistTap" );
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: BusinessProfile_04
	 * @Description: To tap on Remove Shortlist icon and verify.
	 * @Author: Yashi Priya*/
	@Test(priority=4,enabled=false)
	public void testRemoveShortlistTap()
	{
		sTestData="BusinessProfile_04";
		sData=GenericLib.toReadExcelData(sTestData);
		String sBusinessName=null;
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.login(sData, homePo, welcomePo);
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo);
			sBusinessName=businessprofilePo.getEleBusinessNameTxt().getText();
			businessprofilePo.getEleShortlistIcn().click();
			//toast message
			welcomePo.getEleBackArwIcn().click();
			welcomePo.getEleBackArwIcn().click();
			homePo.getEleShortlistTab().click();
			myneedsdashboardPo.getEleRemoveShortlstIcn().click();
			Assert.assertNotEquals(sBusinessName,myneedsdashboardPo.getEleBusinessNameLstItm().getText(),"Shortlisted business is still seen under shortlist tab");
			log.info("The business is successfully removed from shortlist screen");
		}
		catch(Exception e)
		{	log.info("Exception in case testRemoveShortlistTap" );
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: BusinessProfile_05
	 * @Description: To tap on the address icon associated with Address
	 * @Author: Yashi Priya*/
	@Test(priority=5,enabled=false)
	public void testAddressTap()
	{
		sTestData="BusinessProfile_05";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.login(sData, homePo, welcomePo);
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo);
			businessprofilePo.getEleBusinessProfileIcnLst().get(1).click();
			Assert.assertTrue(businessprofilePo.getEleGoogleMapSearchTxtFld().isDisplayed(),"Business address is not displayed in google map");
			log.info("The business address is successfully displayed in google map");
		}
		catch(Exception e)
		{	log.info("Exception in case testAddressTap" );
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: BusinessProfile_06
	 * @Description: To tap on any photo of the business and verify if a bigger view with close icon appears.
	 * @Author: Yashi Priya*/
	@Test(priority=6,enabled=false)
	public void testBusinessImgDisplay()
	{
		sTestData="BusinessProfile_06";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.login(sData, homePo, welcomePo);
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo);
			driver.scrollTo("Photos / videos");
			businessprofilePo.getEleImageLstItm().click();
			Assert.assertTrue(businessprofilePo.getEleImageDisplay().isDisplayed(),"Business image bigger display is not seen");
			log.info("A bigger display og the business image appears successfully");
			Assert.assertTrue(businessprofilePo.getEleCloseIcn().isDisplayed(), "Close icon is not displayed in the business image view");
			log.info("Close icon is successfully displayed in the business image view");
		}
		catch(Exception e)
		{	log.info("Exception in case testBusinessImgDisplay" );
			e.printStackTrace();
			Assert.fail();
		}	
	}
	
	/* @TestCaseID: BusinessProfile_07
	 * @Description: To check the Services offered section
	 * @Author: Yashi Priya*/
	@Test(priority=7,enabled=false)
	public void testServicesOffered()
	{
		sTestData="BusinessProfile_07";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.login(sData, homePo, welcomePo);
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo);
			driver.scrollTo("Services offered");
			Assert.assertTrue(businessprofilePo.getEleServicesOfrdTxt().isDisplayed(),"Services offered section with the number of services is not displayed");
			log.info("Services offered section with the number of services is displayed");
			if(businessprofilePo.getEleShowMoreBtn().isDisplayed())
			{
				businessprofilePo.getEleShowMoreBtn().click();
				Assert.assertTrue(businessprofilePo.getEleMoreServicesTxtView().isDisplayed(), "More services text view is not displayed");
				log.info("More services text view is successfully displayed");
				Assert.assertTrue(businessprofilePo.getEleViewLessBtn().isDisplayed(), "View less button is not displayed");
				log.info("View less button is successfully displayed");
				businessprofilePo.getEleViewLessBtn().click();
				Assert.assertTrue(businessprofilePo.getEleServicesOfrdTxt().isDisplayed(),"Services offered section with the number of services is not displayed");
				log.info("Services offered section with the number of services is displayed");
				Assert.assertTrue(businessprofilePo.getEleShowMoreBtn().isDisplayed(),"Show more button is not displayed");
				log.info("Show more button is successfully displayed");
				}
			}
		catch(Exception e)
		{	log.info("Exception in case testServicesOffered" );
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: BusinessProfile_08
	 * @Description: To tap on any review
	 * @Author: Yashi Priya*/
	@Test(priority=8,enabled=false)
	public void testAnyReview()
	{
		sTestData="BusinessProfile_08";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.login(sData, homePo, welcomePo);
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo);
			driver.scrollTo("Reviews");
			businessprofilePo.getEleReviewLnk().click();
			Assert.assertTrue(businessprofilePo.getEleReviewDetailView().isDisplayed(), "A detailed view of the review is not displayed");
			log.info("A detailed view of the review is successfully displayed");
			}
		catch(Exception e)
		{	log.info("Exception in case testAnyReview" );
			e.printStackTrace();
			Assert.fail();
		}	
	}
	
	/* @TestCaseID: BusinessProfile_09
	 * @Description: To tap on More reviews link
	 * @Author: Yashi Priya*/
	@Test(priority=9,enabled=false)
	public void testMoreReview()
	{
		sTestData="BusinessProfile_09";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.login(sData, homePo, welcomePo);
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo);
			driver.scrollTo("Reviews");
			Assert.assertTrue(businessprofilePo.getEleVIEWMOREREVIEWSBtn().isDisplayed(), "VIEW MORE REVIEW button is not displayed");
			log.info("VIEW MORE REVIEW button is successfully displayed");
			businessprofilePo.getEleVIEWMOREREVIEWSBtn().click();
			Assert.assertTrue(businessprofilePo.getEleReviewLst().isDisplayed(), "More review list is not displayed");
			log.info("More review list is successfully displayed");
			Assert.assertTrue(businessprofilePo.getEleWriteReviewIcn().isDisplayed(), "Write review icon is not displayed");
			log.info("Write review icon is successfully displayed");
			}
		catch(Exception e)
		{	log.info("Exception in case testMoreReview" );
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: BusinessProfile_10
	 * @Description: To tap on "write review" icon and verify the popup.
	 * @Author: Yashi Priya*/
	@Test(priority=10,enabled=false)
	public void testWriteReview()
	{
		sTestData="BusinessProfile_10";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.login(sData, homePo, welcomePo);
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo);
			driver.scrollTo("Reviews");
			businessprofilePo.getEleVIEWMOREREVIEWSBtn().click();
			Assert.assertTrue(businessprofilePo.getEleWriteReviewIcn().isDisplayed(), "Write review icon is not displayed");
			log.info("Write review icon is successfully displayed");
			businessprofilePo.getEleWriteReviewIcn().click();
			Assert.assertTrue(businessprofilePo.getEleRatingBar().isDisplayed(), "a popup with a rating bar is not displayed");
			log.info("a popup with a rating bar is successfully displayed");
			Assert.assertTrue(businessprofilePo.getEleWriteyourreviewTxtFld().isDisplayed(), "a popup with a write your review text field is not displayed");
			log.info("A popup with a write your review text field is successfully displayed");
			Assert.assertTrue(businessprofilePo.getElePOSTBtn().isDisplayed(), "a popup with a post review button is not displayed");
			log.info("A popup with a post button is successfully displayed");
		}
		catch(Exception e)
		{	log.info("Exception in case testWriteReview" );
			e.printStackTrace();
			Assert.fail();
		}	
	}
	
	/* @TestCaseID: BusinessProfile_11
	 * @Description: To submit a review.
	 * @Author: Yashi Priya*/
	@Test(priority=11,enabled=false)
	public void testSubmitReview()
	{
		sTestData="BusinessProfile_11";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.login(sData, homePo, welcomePo);
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo);
			driver.scrollTo("Reviews");
			businessprofilePo.getEleVIEWMOREREVIEWSBtn().click();
			businessprofilePo.getEleWriteReviewIcn().click();
			businessprofilePo.getElePOSTBtn().click();
			//alert popup displayed in ios --INCOMPLETE
			businessprofilePo.getEleRatingBar().click();
			businessprofilePo.getElePOSTBtn().click();
			//defect-- no alert popup displayed, review gets posted
			businessprofilePo.getEleWriteyourreviewTxtFld().sendKeys(sData[7]);
			businessprofilePo.getElePOSTBtn().click();
			Assert.assertTrue(businessprofilePo.getEleReviewLstItm().isDisplayed(), "Posted review is not seen under reviews page");
			log.info("posted review is successfully displayed under reviews section");
			}
		catch(Exception e)
		{	log.info("Exception in case testSubmitReview" );
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: BusinessProfile_12
	 * @Description: To tap on the web icon of the business in the business profile page.
	 * @Author: Yashi Priya*/
	@Test(priority=12,enabled=false)
	public void testWebIcon()
	{
		sTestData="BusinessProfile_12";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.login(sData, homePo, welcomePo);
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo);
			driver.scrollTo("Website");
			businessprofilePo.getEleBusinessProfileIcnLst().get(8).click();
			Assert.assertTrue(businessprofilePo.getEleToolBar().isDisplayed(), "Business website page is not displayed");
			log.info("Business website page is successfully displayed");
			}
		catch(Exception e)
		{	log.info("Exception in case testWebIcon" );
			e.printStackTrace();
			Assert.fail();
		}
	}
}


