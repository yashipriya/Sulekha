package com.test.po;

import org.apache.log4j.Logger;
import org.jfree.util.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;

public class WelcomePO{
	public Logger log = Logger.getLogger(this.getClass());
	AndroidDriver driver=null;
	public WelcomePO(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="JOIN SULEKHA")
	private WebElement eleJOINSULEKHABtn;
	public WebElement getEleJOINSULEKHABtn()
	{
		return eleJOINSULEKHABtn;
	}
	
	@FindBy(name="SKIP")
	private WebElement eleSkipBtn;
	public WebElement getEleSkipBtn()
	{
		return eleSkipBtn;
	}

	@FindBy(name="Log in")
	private WebElement eleLoginLnk;
	public WebElement getEleLoginLnk()
	{
		return eleLoginLnk;
	}
	
	@FindBy(name="Skip")
	private WebElement eleSkipLnk;
	public WebElement getEleSkipLnk()
	{
		return eleSkipLnk;
	}
	
	@FindBy(name="JOIN NOW")
	private WebElement eleJOINNOWBtn;
	public WebElement getEleJOINNOWBtn()
	{
		return eleJOINNOWBtn;
	}
	
	@FindBy(name="Welcome!")
	private WebElement eleWelcomeTxt;
	public WebElement getEleWelcomeTxt()
	{
		return eleWelcomeTxt;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/iv_mobileno_edit")
	private WebElement eleEditIcn;
	public WebElement getEleEditIcn()
	{
		return eleEditIcn;
	}
	
	@FindBy(name="Verification code")
	private WebElement eleVerificationCodeTxtFld;
	public WebElement getEleVerificationCodeTxtFld()
	{
		return eleVerificationCodeTxtFld;
	}
	
	@FindBy(name="RESEND CODE")
	private WebElement eleRESENDCODEBtn;
	public WebElement getEleRESENDCODEBtn()
	{
		return eleRESENDCODEBtn;
	}
	
	@FindBy(name="*T&C apply")
	private WebElement eleTermsCLnk;
	public WebElement getEleTermsCLnk()
	{
		return eleTermsCLnk;
	}
	
	@FindBy(name="Terms & conditions of Sulekha")
	private WebElement eleTermsCTxt;
	public WebElement getEleTermsCTxt()
	{
		return eleTermsCTxt;
	}
	
	@FindBy(name="Navigate up")
	private WebElement eleBackArwIcn;
	public WebElement getEleBackArwIcn()
	{
		return eleBackArwIcn;
	}
	@FindBy(name="Mobile number")
	private WebElement eleMobileNoTxtFld;
	public WebElement getEleMobileNoTxtFld()
	{
		return eleMobileNoTxtFld;
	}
	
	/* @Description- To register into the app
	 * @Author- Yashi Priya*/
	
	public void joinNow(String sMobileNo)
	{
		try
		{
			getEleJOINSULEKHABtn().click();
			Assert.assertTrue(getEleJOINNOWBtn().isDisplayed(), "Join Sulekha page is not displayed");
			log.info("Join Sulekha page is successfully displayed");
			getEleMobileNoTxtFld().sendKeys(sMobileNo);
			getEleJOINNOWBtn().click();
		}
		catch(Exception e)
		{
			log.info("Exception in method joinNow()");
			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
	
}
