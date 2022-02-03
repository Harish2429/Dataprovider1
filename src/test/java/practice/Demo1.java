package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtiger.comcast.pomrepositylib.Home;
import com.crm.Generic.utilites.BaseClass;

@Listeners(com.crm.Generic.utilites.LisImpClass.class)

public class Demo1  extends BaseClass {
	@Test
	
	public void happpy() {
		Home hp=new Home(driver);
		hp.getCalendarLnk().click();
		hp.getAdminstatorImg().click();
		hp.getContactsLnk().click();
		hp.getDashboardLnk().click();
		hp.getEmailLnk().click();
		hp.getHomeIcon().click();
		
	}
	
	

}
