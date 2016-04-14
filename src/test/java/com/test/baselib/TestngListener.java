/***********************************************************************
* @author 			:		LAKSHMI BS
* @description		: 		Implemented ITestListener interface and overrided methods as per requirement. It listenes to all the events performed by Testng and keep track of it.
* @method			:		onTestStart()
* @method			:		onTestSuccess()
* @method			:		onTestFailure()
* @method 			:		onTestSkipped()
* @method			:		onTestFailedButWithinSuccessPercentage()		
* @method 			:		onStart()
* @method 			:		onFinish()
* @method 
*/
package com.test.baselib;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.xmlbeans.impl.tool.XSTCTester.TestCase;
import org.apache.xmlbeans.impl.tool.XSTCTester.TestCaseResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestException;
import org.testng.internal.TestResult;
import org.testng.reporters.TestHTMLReporter;
import org.testng.xml.XmlSuite;
import org.uncommons.reportng.JUnitXMLReporter.TestClassResults;
public class TestngListener implements ITestListener 
{
	public Logger qrLog;
	public static int iPassCount=0;
	public static int iFailCount=0;
	public static int iSkippedCount=0;
	public static ArrayList sTestName= new ArrayList<String>();
	public static ArrayList sStatus= new ArrayList<String>();
	public static String sSheet1="Results";
	public static String sSheet2="Test Status";
	public static File reportLocation;
	public static File sResults;
	public static File sLogs;
	public static File sScreenShots;
	public static String pdfngreportPath=BaseLib.sDirPath+"\\pdfngreport.properties";
	public static String pdfScreenShotsPAth;
	int cnt=0;
	static int i=0;

	public  TestngListener() throws IOException 
	{
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss");
		String sdate1 = sdf.format(date);
		System.setProperty("sFileName",sdate1);
		
		reportLocation=new File(BaseLib.sDirPath+"\\..\\Reports\\TestHouzifyReports"+sdate1);
		sResults=new File(reportLocation.getAbsolutePath()+"\\Results");
		sLogs=new File(reportLocation.getAbsolutePath()+"\\Logs");
		sScreenShots=new File(reportLocation.getAbsolutePath()+"\\ScreenShots");
		GenericLib.sFile=sResults.getAbsolutePath()+"\\TestResult_"; 
	
		FileUtils.forceMkdir(reportLocation);
		FileUtils.forceMkdir(sResults);
		FileUtils.forceMkdir(sLogs);
		FileUtils.forceMkdir(sScreenShots);
		qrLog= Logger.getLogger(this.getClass());
	try{
		System.out.println();
		GenericLib.setCongigValue(pdfngreportPath,"pdfreport.outputdir",reportLocation.getAbsolutePath().replace("\\","/"));
		GenericLib.setCongigValue(pdfngreportPath,"pdfreport.selenium.failed.test.screenshot.outputdir",sScreenShots.getAbsolutePath().replace("\\","/"));
		GenericLib.setCongigValue(pdfngreportPath,"pdfreport.pie.chart.type","normal");
		GenericLib.sFile=GenericLib.sFile+sdate1+".xlsx";
		
		OutputStream fos = new FileOutputStream(GenericLib.sFile);
		HSSFWorkbook hwb = new HSSFWorkbook();
		HSSFSheet sheet = hwb.createSheet(sSheet1);
		hwb.createSheet(sSheet2);
		FileOutputStream fileOut = new FileOutputStream(GenericLib.sFile);
		hwb.write(fos);
		fileOut.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void onTestStart(ITestResult result) 
	{
		qrLog.info("TESTCASE ID  =  	"+result.getName().toString()+"                    ");
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		GenericLib.setStatus(result.getName().toString(), "Passed",sTestName,sStatus);
		qrLog.info("TEST STATUS  =   	PASSED"+"                    ");
		qrLog.info("___________________________________________________");
		qrLog.info("                                                                    ");
		
	}

	public void onTestFailure(ITestResult result) 
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss");
		String sdate = sdf.format(date);
		
		String sClass=result.getTestClass().getRealClass().toString();
		sClass= sClass.replace("class ", "");
		
		String sPackage=result.getTestClass().getRealClass().getPackage().toString();
		sPackage = sPackage.replace("package ", "");
	
		String sImage = sClass.replace(sPackage+".","");
		sImage = sImage+"_"+result.getName().toString();
		
		Object obj=result.getInstance();
		BaseLib baseLib = (BaseLib)obj;
		qrLog.error("TEST STATUS  =   	FAILED"+"                    ");
		qrLog.info("___________________________________________________");
		qrLog.info("                                                                    ");
		File imgFile = ((TakesScreenshot) baseLib.driver).getScreenshotAs(OutputType.FILE);
		System.out.println(imgFile.getAbsolutePath());
        try
        {
        	FileUtils.copyFile(imgFile, new File(sScreenShots.getAbsolutePath()+"\\"+sImage+".png"));
		} catch (IOException e) {
				e.printStackTrace();
		}
        GenericLib.setStatus(result.getName().toString(), "Failed",sTestName,sStatus);          
	}

	public void onTestSkipped(ITestResult result) 
	{
		qrLog.error("TEST STATUS  =   	SKIPPED"+"                    ");
		qrLog.info("___________________________________________________");
		qrLog.info("                                                                    ");
		GenericLib.setStatus(result.getName(), "Skipped",sTestName,sStatus);
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		qrLog.warn("");
	}

	public void onStart(ITestContext context) 
	{
		String suiteName = context.getCurrentXmlTest().toString();
		suiteName=suiteName.substring(suiteName.lastIndexOf("scripts"), suiteName.lastIndexOf("Test] ")).replace("scripts.","");
		qrLog.info("######################     START OF THE -"+ suiteName+"Test    ######################");
	}
	
	public void onFinish(ITestContext context) 
	{
		String suiteName = context.getCurrentXmlTest().toString();
		suiteName=suiteName.substring(suiteName.lastIndexOf("scripts"), suiteName.lastIndexOf("Test] ")).replace("scripts.","");
		GenericLib.toWriteIntoExcel(sTestName,sStatus);
		qrLog.info("######################     END OF THE -"+ suiteName+"Test    ######################");
		qrLog.info("                                                                    ");
		qrLog.info("                                                                    ");
	}
	

			
	
}
