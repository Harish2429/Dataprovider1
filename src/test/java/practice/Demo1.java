package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Generic.utilites.BaseClass;

@Listeners(com.crm.Generic.utilites.LisImpClass.class)

public class Demo1  extends BaseClass {
	@Test
	
	public void happpy() {
		System.out.println(" ****** start*****");
		
		Assert.assertEquals(false, true);
	
		System.out.println("****** enddd*******");
	}
	
	

}
