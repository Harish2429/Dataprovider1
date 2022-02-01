package com.Vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationpage {
	    WebDriver driver;
		public ContactInformationpage(WebDriver driver)
		{
            this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement contactHeaderMsg;
		public WebElement getContactHeaderMsg() {
			return contactHeaderMsg;
		}
	
		
		

}
