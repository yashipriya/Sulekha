/***********************************************************************
* @author 			:		LAKSHMI BS
* @description		: 		Generic library with reusable methods that can be used only for QuickRide app.
* @method			:		setobjects()
* @method			:		setUp()
* @method			:		tearDown()
* @method 			:		
* @method 
*/
package com.test.baselib;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FilenameUtils;
import org.apache.velocity.texen.util.FileUtil;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.sun.jna.platform.*;
import io.appium.java_client.android.AndroidDriver;

public class BaseLib 
{	  
	public AndroidDriver driver;
	static public String sDirPath=System.getProperty("user.dir");
	static public String sConfigFile=sDirPath+"\\Capabilities.Properties";
	static public String sAPKPath = sDirPath+"\\Sulekha.apk";
	File file = new File(sAPKPath);
	public DesiredCapabilities capabilities=null;
	GenericLib genericLib;
	
	@BeforeTest
	public void setobjects()
	{		
		genericLib = new GenericLib();
	}
	@BeforeMethod
	public void setUp() throws MalformedURLException{
		File app = new File(sAPKPath);
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName",genericLib.getCongigValue(sConfigFile, "AUTOMATIONNAME") );
		capabilities.setCapability("platformName",genericLib.getCongigValue(sConfigFile, "PLATFORMNAME") );
		capabilities.setCapability("platformVersion",genericLib.getCongigValue(sConfigFile, "PLATFORMVERSION"));
		capabilities.setCapability("deviceName",genericLib.getCongigValue(sConfigFile, "DEVICENAME") );
		capabilities.setCapability("app",app.getAbsolutePath());
		capabilities.setCapability("apppackage", genericLib.getCongigValue(sConfigFile, "APPPACKAGE") );
		capabilities.setCapability("appactivity", genericLib.getCongigValue(sConfigFile, "APPACTIVITY") );
		capabilities.setCapability("unicodekeyboard",true);
		driver=new AndroidDriver(new URL(genericLib.getCongigValue(sConfigFile, "URL")), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
