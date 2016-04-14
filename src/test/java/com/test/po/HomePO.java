package com.test.po;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;

public class HomePO {
	public Logger log = Logger.getLogger(this.getClass());
	AndroidDriver driver=null;

	public HomePO(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="Popular categories")
	private WebElement elePopularCtgrsTxt;
	public WebElement getElePopularCtgrsTxt()
	{
		return elePopularCtgrsTxt;
	}

	@FindBy(id="sulekha.yellowpages.lcf:id/et_city")
	private WebElement eleLocationTxtFld;
	public WebElement getEleLocationTxtFld()
	{
		return eleLocationTxtFld;
	}
	
	@FindBy(name="What service do you need?")
	private WebElement eleSearchTxtFld;
	public WebElement getEleSearchTxtFld()
	{
		return eleSearchTxtFld;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/lv_needresult")
	private WebElement eleSearchResultLst;
	public WebElement getEleSearchResultLst()
	{
		return eleSearchResultLst;
	}
	
	@FindBy(name="Home Appliances Repairs & Services")
	private WebElement eleHomeAppliancesLnk;
	public WebElement getEleHomeAppliancesLnk()
	{
		return eleHomeAppliancesLnk;
	}
	
	@FindBy(name="Interior Decoration")
	private WebElement eleInteriorDecorationLnk;
	public WebElement getEleInteriorDecorationLnk()
	{
		return eleInteriorDecorationLnk;
	}
	
	@FindBy(name="Pest Control")
	private WebElement elePestControlLnk;
	public WebElement getElePestControlLnk()
	{
		return elePestControlLnk;
	}
	
	@FindBy(name="Security Services")
	private WebElement eleSecurityServicesLnk;
	public WebElement getEleSecurityServicesLnk()
	{
		return eleSecurityServicesLnk;
	}
	
	@FindBy(name="Modular Kitchen")
	private WebElement eleModularKitchenLnk;
	public WebElement getEleModularKitchenLnk()
	{
		return eleModularKitchenLnk;
	}
	
	@FindBy(name="Event Organizers")
	private WebElement eleEventOrganizersLnk;
	public WebElement getEleEventOrganizersLnk()
	{
		return eleEventOrganizersLnk;
	}
	
	@FindBy(name="Computer Training")
	private WebElement eleComputerTrainingLnk;
	public WebElement getEleComputerTrainingLnk()
	{
		return eleComputerTrainingLnk;
	}
	
	@FindBy(name="Packers & Movers")
	private WebElement elePackersMoversLnk;
	public WebElement getElePackersMoversLnk()
	{
		return elePackersMoversLnk;
	}
	
	@FindBy(name="Catering Services")
	private WebElement eleCateringServicesLnk;
	public WebElement getEleCateringServicesLnk()
	{
		return eleCateringServicesLnk;
	}
	
	@FindBy(name="Website Services")
	private WebElement eleWebsiteServicesLnk;
	public WebElement getEleWebsiteServicesLnk()
	{
		return eleWebsiteServicesLnk;
	}
	
	@FindBy(name="Coaching & Tuitions")
	private WebElement eleCoachingTuitionsLnk;
	public WebElement getEleCoachingTuitionsLnk()
	{
		return eleCoachingTuitionsLnk;
	}
	
	@FindBy(name="Electrical Repairs")
	private WebElement eleElectricalRepairs;
	public WebElement getEleElectricalRepairs()
	{
		return eleElectricalRepairs;
	}
	
	@FindBy(name="Choose an option to get")
	private WebElement eleChooseOptionTxt;
	public WebElement getEleChooseOptionTxt()
	{
		return eleChooseOptionTxt;
	}
	
	@FindBy(name="Close")
	private WebElement eleCloseBtn;
	public WebElement getEleCloseBtn()
	{
		return eleCloseBtn;
	}
	
	@FindBy(name="Open navigation drawer")
	private WebElement eleHamburgerMenu;
	public WebElement getEleHamburgerMenu()
	{
		return eleHamburgerMenu;
	}
	
	@FindBy(name="My needs dashboard")
	private WebElement eleMyNeedsDshbrdLnk;
	public WebElement getEleMyNeedsDshbrdLnk()
	{
		return eleMyNeedsDshbrdLnk;
	}
	
	@FindBy(name="Shortlist")
	private WebElement eleShortlistTab;
	public WebElement getEleShortlistTab()
	{
		return eleShortlistTab;
	}
	
	@FindBy(name="Reviews")
	private WebElement eleReviewsLnk;
	public WebElement getEleReviewsLnk()
	{
		return eleReviewsLnk;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/txt_popular")
	private List<WebElement> elePopularCategoriesLstItms;
	public List<WebElement> geteElePopularCategoriesLstItms()
	{
		return elePopularCategoriesLstItms;
	}
	
	
	/* @Description- to navigate to application home page vis skip button.
	 * @Author- Yashi Priya
	 */
	
	public void navigateToHomeWithoutLogin(WelcomePO welcomePo, HomePO homePo)
	{	try
		{	welcomePo.getEleSkipBtn().click();
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
			log.info("Home page is successfully displayed");
		}
		catch(Exception e)
		{	log.info("Exception in method navigateToHomeWithoutLogin");
			e.printStackTrace();
			Assert.fail();
		}
	}
}

