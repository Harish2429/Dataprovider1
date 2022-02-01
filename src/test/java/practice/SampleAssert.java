package practice;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Generic.utilites.BaseClass;
public class SampleAssert extends BaseClass {
	
	@Test
	
	public void homePage() {
		String ExpectedRes="Home";
		String actHome = driver.getTitle();
		Assert.assertEquals(ExpectedRes,actHome );
	
		
	     
		
		
		
		
	}
	

}
