package com.Vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;
	public Home(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Calendar")
	private WebElement calendarLnk;
	
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText = "Documents")
	private WebElement documentsLnk;
	
     @FindBy(linkText = "Email")
     private WebElement emailLnk;
     
     @FindBy(linkText = "Trouble Tickets")
     private WebElement troubleLnk;
     
	
	@FindBy(linkText = "Dashboard")
	private WebElement dashboardLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/Home.PNG']")
    private WebElement homeIcon;
	
	
	public WebElement getCalendarLnk() {
		return calendarLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getDocumentsLnk() {
		return documentsLnk;
	}

	public WebElement getEmailLnk() {
		return emailLnk;
	}

	public WebElement getTroubleLnk() {
		return troubleLnk;
	}

	public WebElement getDashboardLnk() {
		return dashboardLnk;
	}

	public WebElement getHomeIcon() {
		return homeIcon;
	}

	public WebElement getLeadsLnk() {
		return leadsLnk;
	}

	public void setLeadsLnk(WebElement leadsLnk) {
		this.leadsLnk = leadsLnk;
	}
	@FindBy(linkText = "Leads")
	private WebElement leadsLnk;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;
	
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productLnk;

	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getProductLnk() {
		return productLnk;
	}

	public WebElement getAdminstatorImg() {
		return adminstatorImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstatorImg;
	
	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement signoutLnk;
	
	 public void logout() {
		 Actions act=new Actions(driver);
		 act.moveToElement(adminstatorImg).perform();
		 signoutLnk.click();
	 }
}
