package practice;

import org.testng.annotations.Test;

public class Customer_priority {
	@Test(priority = 1)
	public void createCustomerTest() {
		System.out.println("create customer Amazon Test");
	}
	
	@Test(priority = 3)
	public void modifyCustomerTest() {
		System.out.println("modify the customerd details test");
	}
	
	@Test(priority = 2)
	public void deleteCustomerTest() {
		System.out.println("delete the customerData test");
	}



}
