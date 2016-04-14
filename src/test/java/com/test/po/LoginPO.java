package com.test.po;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;

public class LoginPO {
	
	public Logger log = Logger.getLogger(this.getClass());
	AndroidDriver driver=null;
	WelcomePO welcomePo=null;
	HomePO homePo=null;
	
	public LoginPO(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="LOG IN")
	private WebElement eleLoginBtn;
	public WebElement getEleLoginBtn()
	{
		return eleLoginBtn;
	}
	
	@FindBy(name="Email / mobile")
	private WebElement eleEmailmobTxtFld;
	public WebElement getEleEmailmobTxtFld()
	{
		return eleEmailmobTxtFld;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/txt_password")
	private WebElement elePwdTxtFld;
	public WebElement getElePwddTxtFld()
	{
		return elePwdTxtFld;
	}
	
	@FindBy(name="Forgot password?")
	private WebElement eleForgotPwdLnk;
	public WebElement getEleForgotPwdLnk()
	{
		return eleForgotPwdLnk;
	}
	
	@FindBy(name="Join Sulekha")
	private WebElement eleJoinSulekhaBtn;
	public WebElement getEleJoinSulekhaBtn()
	{
		return eleJoinSulekhaBtn;
	}

	@FindBy(name="CANCEL")
	private WebElement eleCancelBtn;
	public WebElement getEleCancelBtn()
	{
		return eleCancelBtn;
	}
	
	@FindBy(name="The mobile number you just entered does not belong to Sulekha's account.")
	private WebElement eleUnregstrdErrorTxt;
	public WebElement getEleUnregstrdErrorTxt()
	{
		return eleUnregstrdErrorTxt;
	}
	
	@FindBy(name="SHOW")
	private WebElement eleSHOWLnk;
	public WebElement getEleSHOWLnk()
	{
		return eleSHOWLnk;
	}
	
	@FindBy(name="HIDE")
	private WebElement eleHIDELnk;
	public WebElement getEleHIDELnk()
	{
		return eleHIDELnk;
	}
	
	@FindBy(name="Forgot password")
	private WebElement eleForgotPwdTxt;
	public WebElement getEleForgotPwdTxt()
	{
		return eleForgotPwdTxt;
	}
	
	@FindBy(name="Via SMS")
	private WebElement eleViaSMSOpt;
	public WebElement getEleViaSMSOpt()
	{
		return eleViaSMSOpt;
	}
	
	@FindBy(name="Via email")
	private WebElement eleViaEmailOpt;
	public WebElement getEleViaEmailOpt()
	{
		return eleViaEmailOpt;
	}
	
	@FindBy(name="Enter a valid email ID")
	private WebElement eleEmailTxtFld;
	public WebElement getEleEmailTxtFld()
	{
		return eleEmailTxtFld;
	}
	
	@FindBy(name="SEND")
	private WebElement eleSendBtn;
	public WebElement getEleSendBtn()
	{
		return eleSendBtn;
	}
	
	@FindBy(name="Facebook")
	private WebElement eleFBLoginLnk;
	public WebElement getEleFBLoginLnk()
	{
		return eleFBLoginLnk;
	}
	
	@FindBy(name="Google +")
	private WebElement eleGoogleLoginLnk;
	public WebElement getEleGoogleLoginLnk()
	{
		return eleGoogleLoginLnk;
	}
	
	@FindBy(id="com.facebook.katana:id/profile_pic_container")
	private WebElement eleFBAccountLnk;
	public WebElement getEleFBAccountLnk()
	{
		return eleFBAccountLnk;
	}
	
	@FindBy(id="android:id/text1")  // need to  verify
	private WebElement eleGoogleAcntLnk;
	public WebElement getEleGoogleAcntLnk()
	{
		return eleGoogleAcntLnk;
	}
	
	@FindBy(name="OK")
	private WebElement eleOKBtn;
	public WebElement getEleOKBtn()
	{
		return eleOKBtn;
	}
	
	@FindBy(name="Allow")
	private WebElement eleAllowBtn;
	public WebElement getEleAllowBtn()
	{
		return eleAllowBtn;
	}
	
	@FindBy(name="No")
	private WebElement eleNoBtn;
	public WebElement getEleNoBtn()
	{
		return eleNoBtn;
	}
	
	/* @Description- To navigate to Login page via Join Sulekha button
	 * @Author- Yashi Priya*/
	public void navigateToLogin(WelcomePO welcomePo)
	{
		try
		{
			welcomePo.getEleJOINSULEKHABtn().click();
			Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(), "Join Sulekha page is not displayed");
			log.info("Join Sulekha page is successfully displayed");
			welcomePo.getEleLoginLnk().click();
			Assert.assertTrue(getEleLoginBtn().isDisplayed(), "Login page is not displayed");
			log.info("Login page is displayed successfully");
		}
		catch(Exception e)
		{
			log.info("Exception in method navigateToLogin()");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/* @Description- To navigate to Login page via Join Sulekha button and Login to Sulekha
	 * @Author- Yashi Priya*/
	public void login(String[] sData,HomePO homePo, WelcomePO  welcomePo)
	{
		homePo=new HomePO(driver);
		try
		{
			navigateToLogin(welcomePo);
			Assert.assertTrue(getEleLoginBtn().isDisplayed(), "Login page is displayed");
			log.info("Login page is successfully displayed");
			getEleEmailmobTxtFld().sendKeys(sData[1]);
			getElePwddTxtFld().sendKeys(sData[3]);
			getEleLoginBtn().click();
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
			log.info("Home page is successfully displayed");
		}
		catch(Exception e)
		{
			log.info("Exception in method loginToSulekha()");
			e.printStackTrace();
			Assert.fail();
		}
		
	}
}
