package com.crm.Generic.utilites;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LisImpClass extends BaseClass implements ITestListener {
	
	public void onFinish(ITestContext arg0) {
		
	}
	public void onStart(ITestContext arg0) {
		
	}
	
	public void onTestFailure(ITestResult result) {
		String currentDate = jLib.getFinalDateFormat();
		String testName = result.getMethod().getMethodName();
		System.out.println(testName+"*******execute listner*****");
		
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.sDriver);
		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File("./screenshot/"+testName+currentDate+".png"));
	
		} catch (IOException e) {
	
		}
		
	}

}
