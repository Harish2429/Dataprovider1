package practice;

import org.testng.annotations.Test;

public class Customer_invocation {
	@Test(invocationCount = 2)
	public void createCustomerTest() {
		System.out.println("create customer Amazon Test");
	}
	
	@Test(invocationCount = 1)
	public void modifyCustomerTest() {
		System.out.println("modify the customerd details test");
	
	
	}
}
