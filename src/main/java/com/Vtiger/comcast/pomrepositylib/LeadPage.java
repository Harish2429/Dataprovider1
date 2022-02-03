package com.Vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {
	public LeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}


}
