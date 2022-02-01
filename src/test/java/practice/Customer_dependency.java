package practice;

import org.testng.annotations.Test;

public class Customer_dependency {
	
	@Test(dependsOnMethods = "modifyCustomerTest")
	public void createCustomerTest() {
		System.out.println("create customer Amazon Test");
	}
	
	@Test(dependsOnMethods = "deleteCustomerTest")
	public void modifyCustomerTest() {
		System.out.println("modify the customerd details test");
	}
	
	@Test
	public void deleteCustomerTest() {
		System.out.println("delete the customerData test");
	}

}


