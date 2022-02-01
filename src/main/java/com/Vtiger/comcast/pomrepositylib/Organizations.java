package com.Vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
	public Organizations(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createorgImg;

	public WebElement getCreateorgImg() {
		return createorgImg;
	}
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	@FindBy(name = "search")
	private WebElement searchBtn;
	
	
	
	

}
