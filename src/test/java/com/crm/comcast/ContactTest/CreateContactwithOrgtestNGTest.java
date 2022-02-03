package com.crm.comcast.ContactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Vtiger.comcast.pomrepositylib.ContactInformationpage;
import com.Vtiger.comcast.pomrepositylib.Contactspage;
import com.Vtiger.comcast.pomrepositylib.CreateNewContactpage;
import com.Vtiger.comcast.pomrepositylib.CreateNewOrganization;
import com.Vtiger.comcast.pomrepositylib.Home;
import com.Vtiger.comcast.pomrepositylib.Login;
import com.Vtiger.comcast.pomrepositylib.OrganizationInfo;
import com.Vtiger.comcast.pomrepositylib.Organizations;
import com.crm.Generic.utilites.ExcelUtility;
import com.crm.Generic.utilites.FileUtility;
import com.crm.Generic.utilites.JavaUtility;
import com.crm.Generic.utilites.WebDriverUtility;

public class CreateContactwithOrgtestNGTest {
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
		String lastName = eLib.getDataFromExcel("Sheet2", 5, 0)+"_"+jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("Sheet2", 2, 0)+"-"+jLib.getRandomNumber();
		
		/* steps1 to launch the browser*/
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else {
			driver=new FirefoxDriver();
			
		}
		
		/*steps2 to login to app*/
	   wLib.waitUntilPageLoad(driver);
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
	  OrganizationInfo oi=new OrganizationInfo(driver);
	  wLib.waitForElementVisibility(driver,oi.getSuccessHeaderMsg() );
	  
	  /*step6: navigate to Contact page*/
	  hp.getContactsLnk().click();
	  
		/* step4: click create new contatact */
		Contactspage cop=new Contactspage(driver);
		cop.getCreateNewBtn().click();
		
		/*step5: navigate create new Contact page*/
		CreateNewContactpage cno=new CreateNewContactpage(driver);
	    wLib.switchToWindow(driver, "Accounts");
		cno.createContact(lastName, orgName);
		
		/*  step6: verification*/
		ContactInformationpage ciof=new ContactInformationpage(driver);
		String contMsg = ciof.getContactHeaderMsg().getText();
		if(contMsg.contains(lastName))
		{
			System.out.println(lastName+"test case is successfully *** Pass***");
			
		}else {
			System.out.println(lastName+"test case is not verified****Fail");
		}
		
		
		/*step7: */
		hp.logout();
	  
	}

}
