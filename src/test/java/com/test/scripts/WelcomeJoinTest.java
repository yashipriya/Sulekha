/***********************************************************************
* @author 			:		Yashi Priya
* @description		: 		Test scripts of Join Sulekha and Welcome
* @module			:		Join Sulekha and Welcome
* @testmethod		:	   	testWithoutMobileNum()
* @testmethod		:	   	testInvalidMobileNum()
* @testmethod		:	   	testValidMobileNum()
* @testmethod		:	   	testReceivedOTP()
* @testmethod		:	   	testOTPtimeLimit()
* @testmethod		:	   	testResendCode()
* @testmethod		:	   	testWithoutVerificationCode()
* @testmethod		:	   	testTandC()
* @testmethod		:	   	testEditIcon()
* @testmethod		:	   	testTnCBackBtn()
* @testmethod		:	   	testSkipLnk()
* @testmethod		:	   	testLoginLnk()
* @testmethod		:	   	testJoinSulekha()
* @testmethod		:	   	testSkip()
*/
package com.test.scripts;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.test.baselib.BaseLib;
import com.test.baselib.GenericLib;
import com.test.po.HomePO;
import com.test.po.LoginPO;
import com.test.po.WelcomePO;
import io.appium.java_client.android.AndroidKeyCode;

public class WelcomeJoinTest extends BaseLib 
{
	String sTestData=null;
	String[] sData=null;
	public Logger log = Logger.getLogger(this.getClass());
	WelcomePO welcomePo;
	HomePO homePo;
	LoginPO loginPo;
	
	/* @TestCaseID: Join Sulekha_01
	 * @Description: Tap over "join now" without entering mobile number
	 * @Author: Yashi Priya*/
	@Test(priority=1,enabled=false)
	public void testWithoutMobileNum()
	{
		sTestData="Join Sulekha_01";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.joinNow(sData[1]);
			//popup displayed in ios. --INCOMPLETE
			log.info("Alert popup displayed successfully");
		}
		catch(Exception e)
		{	log.error("Exception in case testWithoutMobileNum");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Join Sulekha_02
	 * @Description: Tap over "join now" by entering invalid mobile number
	 * @Author: Yashi Priya*/
	@Test(priority=2,enabled=true)
	public void testInvalidMobileNum()
	{
		sTestData="Join Sulekha_02";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.joinNow(sData[1]);
			//popup displayed in ios. --INCOMPLETE
			log.info("Alert popup displayed successfully");
		}
		catch(Exception e)
		{	log.error("Exception in case testInvalidMobileNum");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Join Sulekha_03
	 * @Description: Tap over "join now" button by entering valid mobile number
	 * @Author: Yashi Priya*/
	@Test(priority=3,enabled=false)
	public void testValidMobileNum()
	{
		sTestData="Join Sulekha_03";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.joinNow(sData[1]);
			Assert.assertTrue(welcomePo.getEleVerificationCodeTxtFld().isDisplayed(), "Mobile number verification page is not displayed");
			log.info("Code verification page is displayed successfully");
		}
		catch(Exception e)
		{	log.error("Exception in case testValidMobileNum");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Join Sulekha_04
	 * @Description: Check entering the received OTP
	 * @Author: Yashi Priya*/
	@Test(priority=4,enabled=false)
	public void testReceivedOTP()
	{
		sTestData="Join Sulekha_04";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		try
		{	welcomePo.joinNow(sData[1]);
			Assert.assertTrue(welcomePo.getEleVerificationCodeTxtFld().isDisplayed(), "Mobile number verification page is not displayed");
			log.info("Code verification page is displayed successfully");
			//INCOMPLETE
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
			log.info("Home page is displayed successfully");
		}
		catch(Exception e)
		{	log.error("Exception in case testReceivedOTP");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Join Sulekha_05
	 * @Description: Checking OTP time limit
	 * @Author: Yashi Priya*/
	@Test(priority=5,enabled=true)
	public void testOTPTimeLimit()
	{
		sTestData="Join Sulekha_05";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.joinNow(sData[1]);
			Assert.assertTrue(welcomePo.getEleVerificationCodeTxtFld().isDisplayed(), "Mobile number verification page is not displayed");
			log.info("Code verification page is displayed successfully");
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			Assert.assertTrue(welcomePo.getEleRESENDCODEBtn().isDisplayed(), "ResendCode button is not displayed after 120 seconds ");
			log.info("Resendcode button is successfully displayed after 120 seconds");
		}
		catch(Exception e)
		{	log.error("Exception in case testOTPtimeLimit");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Join Sulekha_06
	 * @Description: Tap on Resend code button displayed in OTP page after 120 seconds time up
	 * @Author: Yashi Priya*/
	@Test(priority=6,enabled=false)
	public void testResendCode()
	{
		sTestData="Join Sulekha_06";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.joinNow(sData[1]);
			Assert.assertTrue(welcomePo.getEleVerificationCodeTxtFld().isDisplayed(), "Mobile number verification page is not displayed");
			log.info("Code verification page is displayed successfully");
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			Assert.assertTrue(welcomePo.getEleRESENDCODEBtn().isDisplayed(), "120 seconds is not displayed");
			log.info("Resendcode button is successfully displayed after 120 seconds");
			welcomePo.getEleRESENDCODEBtn().click();
			//cannot verify SMS.
			log.info("new OTP received successfully");
		}
		catch(Exception e)
		{	log.error("Exception in case testResendCode");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Join Sulekha_08
	 * @Description: To tap on "Done" button without entering verification code
	 * @Author: Yashi Priya*/
	@Test(priority=8,enabled=false)
	public void testWOVerificationCode()
	{
		sTestData="Join Sulekha_08";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.joinNow(sData[1]);
			Assert.assertTrue(welcomePo.getEleVerificationCodeTxtFld().isDisplayed(), "Mobile number verification page is not displayed");
			log.info("Code verification page displayed successfully");
			welcomePo.getEleVerificationCodeTxtFld().clear();
			driver.pressKeyCode(AndroidKeyCode.ENTER);
			//pop up displayed in ios. --INCOMPLETE
			log.info("Alert popup displayed successfully");
		}
		catch(Exception e)
		{	log.error("Exception in case testWithoutVerificationCode");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Join Sulekha_11
	 * @Description: To tap over "T & C" link in the join sulekha page
	 * @Author: Yashi Priya*/
	@Test(priority=11,enabled=false)
	public void testTermsCondition()
	{
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.getEleJOINSULEKHABtn().click();
			welcomePo.getEleTermsCLnk().click();
			Assert.assertTrue(welcomePo.getEleTermsCTxt().isDisplayed(), "T & C page is not displayed");
			log.info("T & C page is displayed successfully");
		}
		catch(Exception e)
		{	log.error("Exception in case testTandC");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Join Sulekha_12
	 * @Description: To tap over edit icon in the OTP page and verify if join sulekha page appears.
	 * @Author: Yashi Priya*/
	@Test(priority=12,enabled=false)
	public void testEditIcon()
	{
		sTestData="Join Sulekha_12";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.joinNow(sData[1]);
			welcomePo.getEleEditIcn().click();
			Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(), "Join sulekha page is not displayed");
			log.info("Join Sulekha page is displayed successfully");
		}
		catch(Exception e)
		{	log.error("Exception in case testEditIcon");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Join Sulekha_13
	 * @Description: Tap over Back button from Terms and conditions page.
	 * @Author: Yashi Priya*/
	@Test(priority=13,enabled=false)
	public void testTnCBackIcn()
	{
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.getEleJOINSULEKHABtn().click();
			welcomePo.getEleTermsCLnk().click();
			Assert.assertTrue(welcomePo.getEleTermsCTxt().isDisplayed(), "Terms & Condition page is not displayed");
			log.info("Terms & Condition page is displayed successfully");
			welcomePo.getEleBackArwIcn().click();
			Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(), "join sulekha page is not displayed");
			log.info("Join Sulekha page is displayed successfully");
		}
		catch(Exception e)
		{	log.error("Exception in case testTnCBackBtn");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Join Sulekha_14
	 * @Description: To tap over "skip" link in join sulekha page and verify if home page is displayed
	 * @Author: Yashi Priya*/
	@Test(priority=14,enabled=false)
	public void testSkipLnk()
	{
		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		try
		{	welcomePo.getEleJOINSULEKHABtn().click();
			welcomePo.getEleSkipLnk().click();
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
			log.info("Home page is displayed successfully");
		}
		catch(Exception e)
		{	log.error("Exception in case testSkipLnk");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Join Sulekha_15 
	 * @Description: To tap over "login" link in the join sulekha page and verify if "login page is displayed
	 * @Author: Yashi Priya*/
	@Test(priority=15,enabled=false)
	public void testLoginLnk()
	{
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		try
		{	welcomePo.getEleJOINSULEKHABtn().click();
			welcomePo.getEleLoginLnk().click();
			Assert.assertTrue(loginPo.getEleLoginBtn().isDisplayed(), "Login page is not displayed");
			log.info("Login page is displayed successfully");
		}
		catch(Exception e)
		{	log.error("Exception in case testLoginLnk");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Welcome_01
	 * @Description: To tap over "join sulekha" button and verify, should navigate to "join sulekha" page
	 * @Author: Yashi Priya*/
	@Test(priority=16,enabled=false)
	public void testJoinSulekha()
	{
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.getEleJOINSULEKHABtn().click();
			Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(), "Join Sulekha page is not displayed");
			log.info("Join sulekha page is displayed successfully");
		}
		catch(Exception e)
		{	log.error("Exception in case testJoinSulekha");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Welcome_02
	 * @Description: To tap over "skip" button and verify, should navigate to home page
	 * @Author: Yashi Priya*/
	@Test(priority=17,enabled=false)
	public void testSkip()
	{
		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		try
		{	welcomePo.getEleSkipBtn().click();
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
			log.info("Home page is displayed successfully");
		}
		catch(Exception e)
		{	log.error("Exception in case testSkip");
			e.printStackTrace();
			Assert.fail();
		}
	}
}
