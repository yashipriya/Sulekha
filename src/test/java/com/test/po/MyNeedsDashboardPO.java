package com.test.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;

public class MyNeedsDashboardPO {
AndroidDriver driver=null;
	
	public MyNeedsDashboardPO(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//android.widget.TextView[@resource-id='sulekha.yellowpages.lcf:id/tv_needtitle'])[1]")
	private WebElement eleNeedsLstItm;
	public WebElement getEleNeedsLstItm()
	{
		return eleNeedsLstItm;
	}
	
	@FindBy(xpath="(//android.widget.TextView[@resource-id='sulekha.yellowpages.lcf:id/tv_business_name'])[1]")
	private WebElement eleResponseLstItm;
	public WebElement getEleResponseLstItm()
	{
		return eleResponseLstItm;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/tv_businessname")
	private WebElement eleBusinessNameLstItm;
	public WebElement getEleBusinessNameLstItm()
	{
		return eleBusinessNameLstItm;
	}
	
	@FindBy(id="sulekha.yellowpages.lcf:id/iv_shortlist")
	private WebElement eleRemoveShortlstIcn;
	public WebElement getEleRemoveShortlstIcn()
	{
		return eleRemoveShortlstIcn;
	}
	
	
	
}
