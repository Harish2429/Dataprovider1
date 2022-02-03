package com.crm.comcast.orgnizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.Vtiger.comcast.pomrepositylib.CreateNewOrganization;
import com.Vtiger.comcast.pomrepositylib.Home;
import com.Vtiger.comcast.pomrepositylib.Login;
import com.Vtiger.comcast.pomrepositylib.OrganizationInfo;
import com.Vtiger.comcast.pomrepositylib.Organizations;
import com.crm.Generic.utilites.ExcelUtility;
import com.crm.Generic.utilites.FileUtility;
import com.crm.Generic.utilites.JavaUtility;
import com.crm.Generic.utilites.WebDriverUtility;

public class CreateOrganization1Test {
	public static void main(String[] args) throws Throwable {
		/* create object */
		JavaUtility jLib=new JavaUtility();
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		WebDriver driver;
		
		/* read common data*/
		String browser = fLib.getPropertyKeyValue("browser");
		String url = fLib.getPropertyKeyValue("url");
		String userName = fLib.getPropertyKeyValue("userName");
		String password = fLib.getPropertyKeyValue("password");
		
		/* read test data*/
		String orgName = eLib.getDataFromExcel("Sheet2", 2, 0)+"_"+jLib.getRandomNumber();
		
		/* steps1 to launch the browser*/
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else {
			driver=new FirefoxDriver();
			
		}
		
		/*steps2 to login to app*/
		driver.get(url);
		Login lp=new Login(driver);
		lp.loginToApp(userName, password);
		
		/*step3: navigate to org*/
		
		Home hp=new Home(driver);
		hp.getOrganizationLnk().click();
		
		/* step4: navigate to crate org page*/
	  Organizations org=new Organizations(driver);
	  org.getCreateorgImg().click();
	  
	  /*  step5: create an org*/
	  CreateNewOrganization cnop=new CreateNewOrganization(driver);
	  cnop.createOrg(orgName);
	  
	  /*step6: verify*/
	  
	  OrganizationInfo oinfop=new OrganizationInfo(driver);
	  wLib.waitForElementVisibility(driver, oinfop.getSuccessHeaderMsg());
	  String actsuccMsg = oinfop.getSuccessHeaderMsg().getText();
	  if(actsuccMsg.contains(orgName))
	  {
		  System.out.println("org is created successfully******pass");
	  }
	  else
	  {
		  System.out.println("org is not created successfully*****Fail***");
		  
	  }

		  /* step:7 logout*/
	   hp.logout();
	   
	   /*step8: close browser*/
	   
	   driver.quit();	
				
				
	}

}
