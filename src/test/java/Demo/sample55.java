package Demo;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Vtiger.comcast.pomrepositylib.CreateNewOrganization;
import com.Vtiger.comcast.pomrepositylib.Home;
import com.Vtiger.comcast.pomrepositylib.OrganizationInfo;
import com.Vtiger.comcast.pomrepositylib.Organizations;
import com.crm.Generic.utilites.BaseClass;

public class sample55 extends BaseClass {
	@Test(dataProvider = "addOrgWithIndust")
		public void addOrgWithIndust(String orgname, String indust) {
	/*step3: navigate to organization*/
		
		Home hp=new Home(driver);
		hp.getOrganizationLnk().click();
		
		/* step4: navigate to crate organization page*/
	  Organizations org=new Organizations(driver);
	  org.getCreateorgImg().click();  
	  /*  step5: create an organization with industry*/
	  CreateNewOrganization cnop=new CreateNewOrganization(driver);
	  cnop.createOrg(orgname);
	  WebElement s = cnop.getIndustryEdt();
	  wLib.select(indust,s);
         /*step6: verification*/
	  
	  OrganizationInfo oinfop=new OrganizationInfo(driver);
	  wLib.waitForElementVisibility(driver, oinfop.getSuccessHeaderMsg());
	  String actsuccMsg = oinfop.getSuccessHeaderMsg().getText();
	Assert.assertTrue(actsuccMsg.contains(orgname));
	System.out.println("*****pass*****");
	}
@DataProvider
public Object[][] addOrgWithIndust() throws Throwable, Throwable{
   Object[][] objArr=new Object[4][2];
        int count = eLib.getRowCount("Sheet3");
        System.out.println(count);
        for(int i=0; i<count; i++) {
   objArr[i][0]=eLib.getDataFromExcel("Sheet3",i+1,0)+jLib.getRandomNumber();
   objArr[i][1]=eLib.getDataFromExcel("Sheet3",i+1, 1);
        }
   return objArr;
}	
}


	


