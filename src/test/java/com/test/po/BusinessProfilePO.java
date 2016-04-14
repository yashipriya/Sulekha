package com.test.po;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class BusinessProfilePO {
	public Logger log = Logger.getLogger(this.getClass());
	AndroidDriver driver=null;
	
	public BusinessProfilePO(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/tv_business_name")
	private WebElement eleBusinessNameTxt;
	public WebElement getEleBusinessNameTxt()
	{
		return eleBusinessNameTxt;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/tv_address")
	private WebElement eleAddressLnk;
	public WebElement getEleAddressLnk()
	{
		return eleAddressLnk;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/tv_email")
	private WebElement eleEmailIDLnk;
	public WebElement getEleEmailIDLnk()
	{
		return eleEmailIDLnk;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/tv_about")
	private WebElement eleAboutTxt;
	public WebElement getEleAboutTxt()
	{
		return eleAboutTxt;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/tv_service_offered")
	private WebElement eleServicesOfrdTxt;
	public WebElement getEleServicesOfrdTxt()
	{
		return eleServicesOfrdTxt;
	}
	
	@FindBy(xpath="//android.widget.ImageView")
	private List<WebElement> eleBusinessProfileIcnLst;
	public List<WebElement> getEleBusinessProfileIcnLst()
	{
		 //eleBusinessProfileIcnLst.get(9);
		 return eleBusinessProfileIcnLst;
	}
	
	@FindBy(xpath="//android.widget.ImageView")
	private List<WebElement> eleBusinessProfileLst;
	public WebElement getEleWebIcn()
	{
		return eleBusinessProfileIcnLst.get(1);
	}
	
	@FindBy(xpath="//(android.widget.ImageView/..//android.widget.TextView)[1]")
	private List<WebElement> eleBusinessProfileTxtLst;
	public List<WebElement> getEleBusinessProfileTxtLst()
	{
		return eleBusinessProfileTxtLst;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/tv_review")
	private WebElement eleReviewLnk;
	public WebElement getEleReviewLnk()
	{
		return eleReviewLnk;
	}
	
	@FindBy(name="VIEW MORE REVIEWS")
	private WebElement eleVIEWMOREREVIEWSBtn;
	public WebElement getEleVIEWMOREREVIEWSBtn()
	{
		return eleVIEWMOREREVIEWSBtn;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/float_write_review")
	private WebElement eleWriteReviewIcn;
	public WebElement getEleWriteReviewIcn()
	{
		return eleWriteReviewIcn;
	}
	
	@FindBy(name="score")
	private WebElement eleScoreTxt;
	public WebElement getEleScoreTxt()
	{
		return eleScoreTxt;
	}
	
	@FindBy(name="search")
	private WebElement eleSMSIcn;
	public WebElement getEleSMSIcn()
	{
		return eleSMSIcn;
	}
	
	@FindBy(name="Shortlist")
	private WebElement eleShortlistIcn;
	public WebElement getEleShortlistIcn()
	{
		return eleShortlistIcn;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/fab_call")
	private WebElement eleCallIcn;
	public WebElement getEleCallIcn()
	{
		return eleCallIcn;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/ll_content_panel")
	private WebElement eleImageLst;
	public WebElement getEleImageLst()
	{
		return eleImageLst;
	}
	
	@FindBy(name="search")
	private WebElement eleSearchIcn;
	public WebElement getEleSearchIcn()
	{
		return eleSearchIcn;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/ratingBar")
	private WebElement eleRatingBar;
	public WebElement getEleRatingBar()
	{
		return eleRatingBar;
	}
	
	@FindBy(xpath="(//android.widget.ImageView[contains(@resource-id,'lcf:id/img_load')])")
	private WebElement eleImageLstItm;
	public WebElement getEleImageLstItm()
	{
		return eleImageLstItm;
	}
	
	@FindBy(name="POST")
	private WebElement elePOSTBtn;
	public WebElement getElePOSTBtn()
	{
		return elePOSTBtn;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/tv_city_loc")
	private WebElement eleLocationTxt;
	public WebElement getEleLocationTxt()
	{
		return eleLocationTxt;
	}
	
	@FindBy(id="com.android.mms:id/recipients_editor_to")
	private WebElement eleSMSToTxtFld;
	public WebElement getEleSMSToTxtFld()
	{
		return eleSMSToTxtFld;
	}
	
	@FindBy(name="New message")
	private WebElement eleNewMsgTxt;
	public WebElement getEleNewMsgTxt()
	{
		return eleNewMsgTxt;
	}
	
	@FindBy(name="Search Google Maps")
	private WebElement eleGoogleMapSearchTxtFld;
	public WebElement getEleGoogleMapSearchTxtFld()
	{
		return eleGoogleMapSearchTxtFld;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/imgDisplay")
	private WebElement eleImageDisplay;
	public WebElement getEleImageDisplay()
	{
		return eleImageDisplay;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/btnClose")
	private WebElement eleCloseIcn;
	public WebElement getEleCloseIcn()
	{
		return eleCloseIcn;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/btn_service_offered_more")
	private WebElement eleShowMoreBtn;
	public WebElement getEleShowMoreBtn()
	{
		return eleShowMoreBtn;
	}
	
	@FindBy(name="View less")
	private WebElement eleViewLessBtn;
	public WebElement getEleViewLessBtn()
	{
		return eleViewLessBtn;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/tv_service_offered_more")
	private WebElement eleMoreServicesTxtView;
	public WebElement getEleMoreServicesTxtView()
	{
		return eleMoreServicesTxtView;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/fl_reviewlisting")
	private WebElement eleReviewLst;
	public WebElement getEleReviewLst()
	{
		return eleReviewLst;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/ll_content_panel")
	private WebElement eleReviewDetailView;
	public WebElement getEleReviewDetailView()
	{
		return eleReviewDetailView;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/ratingBar")
	private WebElement eleRateThisBusinessIcn;
	public WebElement getEleRateThisBusinessIcn()
	{
		return eleRateThisBusinessIcn;
	}
	
	@FindBy(name="Write your review")
	private WebElement eleWriteyourreviewTxtFld;
	public WebElement getEleWriteyourreviewTxtFld()
	{
		return eleWriteyourreviewTxtFld;
	}
	
	@FindBy(xpath="//android.widget.TextView[contains(@resource-id,'sulekha.yellowpages.lcf:id/tv_review')]")
	private WebElement eleReviewLstItm;
	public WebElement getEleReviewLstItm()
	{
		return eleReviewLstItm;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/toolbar")
	private WebElement eleToolBar;
	public WebElement getEleToolBar()
	{
		return eleToolBar;
	}
	
	
	/* @Description- To navigate to Business Profile Page
	 * @Author- Yashi Priya*/
	
	public void navigateToBusinessProfile(HomePO homePo,MyNeedsDashboardPO myneedsdashboardPo)
	{
		try
		{
			homePo.getEleHamburgerMenu().click();
			homePo.getEleMyNeedsDshbrdLnk().click();
			//driver.findElement(By.xpath("(//android.widget.TextView[contains(@resource-id,'tv_needtitle')])[1]")).click();
			//driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='sulekha.yellowpages.lcf:id/tv_needtitle'])[1]")).click();
			myneedsdashboardPo.getEleNeedsLstItm().click();
			myneedsdashboardPo.getEleResponseLstItm().click();
			Assert.assertTrue(getEleBusinessNameTxt().isDisplayed(), "Business Profile page is not displayed");
			log.info("Business Profile page is successfully displayed");
		}
		catch(Exception e)
		{
			log.info("Exception in method navigateToBusinessProfile");
			e.printStackTrace();
			Assert.fail();
		}
		
	}
}
