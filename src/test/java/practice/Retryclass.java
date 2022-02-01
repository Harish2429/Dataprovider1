package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Retryclass {
	@Test(retryAnalyzer = com.crm.Generic.utilites.ReTryImpClass.class)
	
	public void amazontest() {
		
		Assert.assertEquals("A", "B");
	}

}
