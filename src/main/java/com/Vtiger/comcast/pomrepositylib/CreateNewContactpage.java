package com.Vtiger.comcast.pomrepositylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Generic.utilites.WebDriverUtility;

public class CreateNewContactpage extends WebDriverUtility {
	WebDriver driver;
	public CreateNewContactpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(name ="lastname")
	private WebElement lastNameEdt;
	
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgLookUoImg;
	
	
	
	public WebElement getImgBtn() {
		return orgLookUoImg;
	}
	public void createContact(String lastName)
	{
		lastNameEdt.sendKeys(lastName);
	    saveBtn.click();
	}

	public void createContact(String lastName,String orgName)
	{   
		getLastNameEdt().sendKeys(lastName);
	     orgLookUoImg.click();
	    switchToWindow(driver, "Accounts&action");
	    Organizations op=new Organizations(driver);
	    op.getSearchEdt().sendKeys(orgName);
	    op.getSearchBtn().click();
	    driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	    switchToWindow(driver, "Contacts&action");
	    saveBtn.click();
	    
	    
	}
	
	

}
