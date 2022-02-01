package com.Vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfo {
	
		public OrganizationInfo(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			
		}
		
		public WebElement getSuccessHeaderMsg() {
			return successHeaderMsg;
		}

		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement successHeaderMsg;
		
		
		

}
