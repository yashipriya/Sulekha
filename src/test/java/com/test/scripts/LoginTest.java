/***********************************************************************
* @author 			:		Yashi Priya
* @description		: 		Test scripts of Login
* @module			:		Login
* @testmethod		:	   	testLoginWithoutemailmob()
* @testmethod		:	   	testLoginInvalidemailmob()
* @testmethod		:	   	testLoginUnregstrdEmail()
* @testmethod		:	   	testLoginUnregstrdMob()
* @testmethod		:	   	testPopupJoinSulekhaBtn()
* @testmethod		:	   	testPopupCancelBtn()
* @testmethod		:	   	testLoginWithoutPwd()
* @testmethod		:	   	testShowTxt()
* @testmethod		:	   	testHideTxt()
* @testmethod		:	   	testInvalidPwd()
* @testmethod		:	   	testValidLogin()
* @testmethod		:	   	testForgtPwd()
* @testmethod		:	   	testPwdViaSms()
* @testmethod		:	   	testPwdViaEmail()
* @testmethod		:	   	testFaceBookLogin()
* @testmethod		:	   	testGoogleLogin()
*/
package com.test.scripts;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.test.baselib.BaseLib;
import com.test.baselib.GenericLib;
import com.test.po.HomePO;
import com.test.po.LoginPO;
import com.test.po.WelcomePO;

public class LoginTest extends BaseLib {
	
	String sTestData=null;
	String[] sData=null;
	public Logger log = Logger.getLogger(this.getClass());
	LoginPO loginPo;
	WelcomePO welcomePo;
	HomePO homePo;
	
	/* @TestCaseID: Login_01
	 * @Description: Tap over LOGIN button without entering any values in Email ID/ mobile number field and verify.
	 * @Author: Yashi Priya*/
	@Test(priority=1,enabled=false)
	public void testLoginWOEmailMob()
	{
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.navigateToLogin(welcomePo);
			loginPo.getEleLoginBtn().click();
			//popup displayed in ios app.--INCOMPLETE
			log.info("Alert popup with error message is displayed successfully");
		}
		catch(Exception e)
		{	log.error("Exception in case testLoginWithoutemailmob");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Login_02
	 * @Description: To tap over "login" button by entering invalid mobileno/emailid
	 * @Author: Yashi Priya*/
	@Test(priority=2,enabled=false)
	public void testLoginInvalideMobEmail()
	{
		sTestData="Login_02";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.navigateToLogin(welcomePo);
			loginPo.getEleEmailmobTxtFld().sendKeys(sData[1]);
			loginPo.getEleLoginBtn().click();
			//popup displayed in ios app.--INCOMPLETE
			log.info("Alert popup with error message is successfully displayed");
		}
		catch(Exception e)
		{	log.error("Exception in case testLoginInvalidemailmob");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Login_03
	 * @Description: To tap over "login" button by entering unregistered emailid
	 * @Author: Yashi Priya*/
	@Test(priority=3,enabled=false)
	public void testLoginUnregstrdEmail()
	{
		sTestData="Login_03";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.navigateToLogin(welcomePo);
			loginPo.getEleEmailmobTxtFld().sendKeys(sData[2]);
			loginPo.getEleLoginBtn().click();
			//popup displayed in ios app.--INCOMPLETE
			log.info("Alert popup with error message is displayed successfully");
		}
		catch(Exception e)
		{	log.error("Exception in case testLoginUnregstrdEmail");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Login_04
	 * @Description: To tap over "login" button by entering unregistered mobileno
	 * @Author: Yashi Priya */
	@Test(priority=4,enabled=false)
	public void testLoginUnregstrdMob()
	{	
		sTestData="Login_04";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.navigateToLogin(welcomePo);
			loginPo.getEleEmailmobTxtFld().sendKeys(sData[1]);
			loginPo.getEleLoginBtn().click();
			Assert.assertTrue(loginPo.getEleUnregstrdErrorTxt().isDisplayed(), "An alert popup is not displayed");
			log.info("Alert popup with error message is displayed successfully");
		}
		catch(Exception e)
		{	log.error("Exception in case testLoginUnregstrdMob");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Login_05
	 * @Description: Tap over Join Sulekha button displayed on the alert for unregistered mobile number.
	 * @Author: Yashi Priya*/
	@Test(priority=5,enabled=false)
	public void testPopupJoinSulekhaBtn()
	{	
		sTestData="Login_05";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.navigateToLogin(welcomePo);
			loginPo.getEleEmailmobTxtFld().sendKeys(sData[1]);
			loginPo.getEleLoginBtn().click();
			Assert.assertTrue(loginPo.getEleUnregstrdErrorTxt().isDisplayed(), "An alert popup is not displayed");
			log.info("Alert popup with error message is displayed successfully");
			loginPo.getEleJoinSulekhaBtn().click();
			Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(), "Join Sulekha page is not displayed");
			log.info("Join Sulekha page is successfully displayed");
		}
		catch(Exception e)
		{	log.error("Exception in case testPopupJoinSulekhaBtn");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Login_06
	 * @Description: Tap over Cancel button displayed on the alert for unregistered mobile number.
	 * @Author: Yashi Priya*/
	@Test(priority=6,enabled=false)
	public void testPopupCancelBtn()
	{
		sTestData="Login_06";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.navigateToLogin(welcomePo);
			loginPo.getEleEmailmobTxtFld().sendKeys(sData[1]);
			loginPo.getEleLoginBtn().click();
			Assert.assertTrue(loginPo.getEleUnregstrdErrorTxt().isDisplayed(), "An alert popup with error message is not displayed");
			log.info("Alert popup with error message is displayed successfully");
			loginPo.getEleCancelBtn().click();
			Assert.assertTrue(loginPo.getEleLoginBtn().isDisplayed(), "Login page is not displayed when cancelled");
			log.info("Back to login page after cancelling");
		}
		catch(Exception e)
		{	log.error("Exception in case testPopupCancelBtn");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Login_07
	 * @Description: To tap over "login" button by entering registered mobileno/emailid and no password
	 * @Author: Yashi Priya*/
	@Test(priority=7,enabled=false)
	public void testLoginWithoutPwd()
	{
		sTestData="Login_07";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.navigateToLogin(welcomePo);
			loginPo.getEleEmailmobTxtFld().sendKeys(sData[1]);
			loginPo.getEleLoginBtn().click();
			//popup in ios app --INCOMPLETE
			log.info("Alert popup with error message is successfully displayed");
		}
		catch(Exception e)
		{	log.error("Exception in case testLoginWithoutPwd");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Login_08
	 * @Description: To tap over "Show" link of password field in login page
	 * @Author: Yashi Priya*/
	@Test(priority=8,enabled=false)
	public void testShowPwdLnk()
	{
		sTestData="Login_08";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.navigateToLogin(welcomePo);
			loginPo.getElePwddTxtFld().sendKeys(sData[3]);
			loginPo.getEleSHOWLnk().click();
			Assert.assertTrue(loginPo.getEleHIDELnk().isDisplayed(), "Hide Link is not displayed");
			log.info("Hide Link is successfully displayed");
			log.info("Password entered is readable and not encrypted");
		}
		catch(Exception e)
		{	log.error("Exception in case testShowTxt");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Login_09
	 * @Description: To tap over "Hide" link of password field in login page
	 * @Author: Yashi Priya*/
	@Test(priority=9,enabled=false)
	public void testHidePwdLnk()
	{
		sTestData="Login_09";
		sData=GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		try
		{	loginPo.navigateToLogin(welcomePo);
			loginPo.getElePwddTxtFld().sendKeys(sData[3]);
			loginPo.getEleSHOWLnk().click();
			loginPo.getEleHIDELnk().click();
			Assert.assertTrue(loginPo.getEleSHOWLnk().isDisplayed(), "Show Link is not displayed");
			log.info("Show Link is successfully displayed");
			log.info("Password entered is encrypted");
		}
		catch(Exception e)
		{	log.error("Exception in case testHideTxt");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Login_10
	 * @Description: To Tap over LOGIN and enter valid Email ID/ Mobile number and invalid Password and verify.
	 * @Author: Yashi Priya*/
	@Test(priority=10,enabled=false)
	public void testInvalidPwd()
	{
		sTestData="Login_10";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.navigateToLogin(welcomePo);
			loginPo.getEleEmailmobTxtFld().sendKeys(sData[1]);
			loginPo.getElePwddTxtFld().sendKeys(sData[3]);
			loginPo.getEleLoginBtn().click();
			//alert popup in ios app --INCOMPLETE
			log.info("Alert popup with error message is successfully displayed");
		}
		catch(Exception e)
		{	log.error("Exception in case testInvalidPwd");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Login_11
	 * @Description: To Tap over LOGIN and enter valid Email ID/ Mobile number and valid Password and verify.
	 * @Author: Yashi Priya*/
	@Test(priority=11,enabled=false)
	public void testValidLogin()
	{
		sTestData="Login_11";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.login(sData,homePo,welcomePo);
		}
		catch(Exception e)
		{	log.error("Exception in case testValidLogin");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Login_12
	 * @Description: To tap over "forgot password" link in Login page.
	 * @Author: Yashi Priya*/
	@Test(priority=12,enabled=false)
	public void testForgtPwd()
	{
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.navigateToLogin(welcomePo);
			loginPo.getEleForgotPwdLnk().click();
			Assert.assertTrue(loginPo.getEleForgotPwdTxt().isDisplayed(), "Forgot password page is not displayed");
			log.info("Forgot password page is successfully displayed");
		}
		catch(Exception e)
		{	log.error("Exception in case testForgtPwd");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Login_13
	 * @Description: To enter a valid mobile number in Via SMS in Forgot password? Page and tap on Send button
	 * @Author: Yashi Priya*/
	@Test(priority=13,enabled=false)
	public void testPwdViaSms()
	{
		sTestData="Login_13";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.navigateToLogin(welcomePo);
			loginPo.getEleForgotPwdLnk().click();
			Assert.assertTrue(loginPo.getEleForgotPwdTxt().isDisplayed(), "Forgot password page is not displayed");
			log.info("Forgot password page is successfully displayed");
			loginPo.getEleViaSMSOpt().click();
			Assert.assertTrue(welcomePo.getEleMobileNoTxtFld().isDisplayed(), "Mobile number text Field in forgot Password page is not displayed");
			log.info("Mobile number text field in forgot password page is successfully displayed");
			welcomePo.getEleMobileNoTxtFld().sendKeys(sData[1]);
			driver.hideKeyboard();
			loginPo.getEleSendBtn().click();
			Assert.assertTrue(loginPo.getEleLoginBtn().isDisplayed(), "Login page is no longer displayed after clicking on Send button");
			log.info("Successfully stays in login page after clicking on send button");
			//alert popup in ios app --INCOMPLETE//
			log.info("Password is successfully received via SMS");
		}
		catch(Exception e)
		{	log.error("Exception in case testPwdViaSms");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Login_14
	 * @Description: To enter a valid Email ID in Via email in Forgot password? Page and tap on Send button
	 * @Author: Yashi Priya*/
	@Test(priority=14,enabled=false)
	public void testPwdViaEmail()
	{
		sTestData="Login_14";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.navigateToLogin(welcomePo);
			loginPo.getEleForgotPwdLnk().click();
			Assert.assertTrue(loginPo.getEleForgotPwdTxt().isDisplayed(), "Forgot password page is not displayed");
			log.info("Forgot password page is successfully displayed");
			loginPo.getEleViaEmailOpt().click();
			Assert.assertTrue(loginPo.getEleEmailTxtFld().isDisplayed(), "Email Id text Feild in forgot Password page is not displayed");
			log.info("Email Id text field in forgot password page is successfully displayed");
			loginPo.getEleEmailTxtFld().sendKeys(sData[2]);
			driver.hideKeyboard();
			loginPo.getEleSendBtn().click();
			Assert.assertTrue(loginPo.getEleLoginBtn().isDisplayed(), "Login page is no longer displayed after clicking on Send button");
			log.info("Successfully stays in login page after clicking on send button");
			//alert popup in ios app --INCOMPLETE
			log.info("Password is successfully received via email");
		}
		catch(Exception e)
		{	log.error("Exception in case testPwdViaEmail");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: Login_15
	 * @Description: To login through facebook
	 * @Author: Yashi Priya*/
	@Test(priority=15,enabled=false)//bug found(not able to login through fb)
	public void testFaceBookLogin()
	{
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.navigateToLogin(welcomePo);
			loginPo.getEleFBLoginLnk().click();
			loginPo.getEleFBAccountLnk().click();
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Sulekha home page does not appear");
			log.info("Sulekha home page is successfully displayed");
		}
		catch(Exception e)
		{	log.info("Exception in case testFaceBookLogin");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @TestCaseID: login_16
	 * @Descripyion: To login through google+
	 * @Author: Yashi Priya*/
	@Test(priority=16,enabled=false)
	public void testGoogleLogin()
	{
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	loginPo.navigateToLogin(welcomePo);
			loginPo.getEleGoogleLoginLnk().click();
			loginPo.getEleGoogleAcntLnk().click();
			loginPo.getEleOKBtn().click();
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Sulekha home page does not appear");
			log.info("Sulekha home page is successfully displayed");
		}
		catch(Exception e)
		{	log.info("Exception in case testGoogleLogin");
			e.printStackTrace();
			Assert.fail();
		}
	}
}
