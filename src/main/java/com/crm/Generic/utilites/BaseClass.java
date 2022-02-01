package com.crm.Generic.utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Vtiger.comcast.pomrepositylib.Home;
import com.Vtiger.comcast.pomrepositylib.Login;

public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver sDriver=null;
	
	/* object creation for libraries*/
	
	public  JavaUtility jLib=new JavaUtility();
	public  ExcelUtility eLib=new ExcelUtility();
	public  FileUtility fLib=new FileUtility();
    public	WebDriverUtility wLib=new WebDriverUtility();
			
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBS() {
		System.out.println("***********connect data base******");
	}
	//@Parameters("browser")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBC() throws Throwable {
		                    //.xmlfile it will take browser
		
		System.out.println("*******launch the browser********");
		String browser = fLib.getPropertyKeyValue("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else {
			driver=new FirefoxDriver();
			
		}
	    wLib.waitUntilPageLoad(driver);
	    driver.manage().window().maximize();
	    
	}

	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		/* read common data*/
		String url = fLib.getPropertyKeyValue("url");
		String userName = fLib.getPropertyKeyValue("userName");
		String password = fLib.getPropertyKeyValue("password");
		
		/*navigate to app*/
		driver.get(url);
		sDriver=driver;
		
		/* step1: login*/
		Login lp=new Login(driver);
		lp.loginToApp(userName, password);
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAM() {
		
	/* logout the app*/
		Home hp=new Home(driver);
		hp.logout();
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("******close the Browser*****");
		driver.quit();
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAS() {
		System.out.println("********close the DB connection*****");
	}
	
	
	
	
}
