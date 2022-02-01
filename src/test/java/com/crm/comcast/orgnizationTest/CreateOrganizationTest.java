package com.crm.comcast.orgnizationTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Vtiger.comcast.pomrepositylib.CreateNewOrganization;
import com.Vtiger.comcast.pomrepositylib.Home;
import com.Vtiger.comcast.pomrepositylib.OrganizationInfo;
import com.Vtiger.comcast.pomrepositylib.Organizations;
import com.crm.Generic.utilites.BaseClass;

        public class CreateOrganizationTest extends BaseClass {
	    @Test(groups = "smokeTest")
	    public void CreateOrgTest() throws Throwable, Throwable   {
		
		/*test script data*/
		String orgName = eLib.getDataFromExcel("Sheet2", 2, 0)+jLib.getRandomNumber();
			
	   /*step3: navigate to organization*/
		
		Home hp=new Home(driver);
		hp.getOrganizationLnk().click();
		
	  /* step4: navigate to crate organization page*/
	   Organizations org=new Organizations(driver);
	   org.getCreateorgImg().click();
		  
	 /*  step5: create an organization*/
	   CreateNewOrganization cnop=new CreateNewOrganization(driver);
	   cnop.createOrg(orgName);
		  
	 /*step6: verification*/
		  
		  OrganizationInfo oinfop=new OrganizationInfo(driver);
		  wLib.waitForElementVisibility(driver, oinfop.getSuccessHeaderMsg());
		  String actsuccMsg = oinfop.getSuccessHeaderMsg().getText();
		Assert.assertTrue(actsuccMsg.contains(orgName));
		System.out.println("***pass***");
	}
	
	
	@Test(groups = "regressionTest")
	public void createOrgWithIndustries() throws Throwable, Throwable {
		
		/* read test data*/
		String orgName = eLib.getDataFromExcel("Sheet2", 2, 0)+jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("Sheet2", 2, 1);
		
	/*step3: navigate to organization*/
		
		Home hp=new Home(driver);
		hp.getOrganizationLnk().click();
		
		/* step4: navigate to crate organization page*/
	  Organizations org=new Organizations(driver);
	  org.getCreateorgImg().click();
	  
	  /*  step5: create an organization with industry*/
	  CreateNewOrganization cnop=new CreateNewOrganization(driver);
	  cnop.createOrg(orgName);
	  WebElement s = cnop.getIndustryEdt();
	  wLib.select(industry,s);
	  
	  
         /*step6: verification*/
	  
	  OrganizationInfo oinfop=new OrganizationInfo(driver);
	  wLib.waitForElementVisibility(driver, oinfop.getSuccessHeaderMsg());
	  String actsuccMsg = oinfop.getSuccessHeaderMsg().getText();
	Assert.assertTrue(actsuccMsg.contains(orgName));
	System.out.println("*****pass*****");
	}

}
