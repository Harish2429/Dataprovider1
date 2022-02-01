package com.crm.comcast.ContactTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.comcast.pomrepositylib.ContactInformationpage;
import com.Vtiger.comcast.pomrepositylib.Contactspage;
import com.Vtiger.comcast.pomrepositylib.CreateNewContactpage;
import com.Vtiger.comcast.pomrepositylib.CreateNewOrganization;
import com.Vtiger.comcast.pomrepositylib.Home;
import com.Vtiger.comcast.pomrepositylib.OrganizationInfo;
import com.Vtiger.comcast.pomrepositylib.Organizations;
import com.crm.Generic.utilites.BaseClass;

public class CreateContactTest extends BaseClass {
		@Test(groups = "smokeTest")
		public void createContact() throws Throwable, Throwable {
			int randomInt = jLib.getRandomNumber();
			/* read test data*/
			String lastName = eLib.getDataFromExcel("Sheet2", 2, 2)+randomInt;
			
			/* step3:navigate to contact page*/
			Home hp=new Home(driver);
			hp.getContactsLnk().click();
			
			/* step4: click create new contatact */
			Contactspage cop=new Contactspage(driver);
			cop.getCreateNewBtn();
			
			/*step5: navigate create new Contact page*/
			CreateNewContactpage cno=new CreateNewContactpage(driver);
			cno.createContact(lastName);
			
			/*  step6: verification*/
			ContactInformationpage ciof=new ContactInformationpage(driver);
			String contMsg = ciof.getContactHeaderMsg().getText();
			Assert.assertTrue(contMsg.contains(lastName));	
			System.out.println("****pass****");
	}
	
		@Test(groups = "regressionTest")
		
		public void createWithOrg() throws Throwable, Throwable {
			
			int randomInt = jLib.getRandomNumber();

			/* read test data*/
			String lastName = eLib.getDataFromExcel("Sheet2", 5, 0)+randomInt;
			String orgName = eLib.getDataFromExcel("Sheet2", 2, 0)+randomInt;
			
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
		Assert.assertTrue(contMsg.contains(lastName));
		System.out.println("***pass****");
			
		}

}
