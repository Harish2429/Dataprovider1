package com.crm.comcast.ContactTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.Generic.utilites.ExcelUtility;
import com.crm.Generic.utilites.FileUtility;
import com.crm.Generic.utilites.JavaUtility;
import com.crm.Generic.utilites.WebDriverUtility;

public class CreateContactwithOrgTest {
	public static void main(String[] args) throws Throwable {
		JavaUtility jLib=new JavaUtility();
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
	    String browser = fLib.getPropertyKeyValue("browser");
		String url = fLib.getPropertyKeyValue("url");
		String username = fLib.getPropertyKeyValue("userName");
		String password = fLib.getPropertyKeyValue("password");
		 String orgName = fLib.getPropertyKeyValue("orgName");
		String firstname = fLib.getPropertyKeyValue("firstname");
		String lastName = fLib.getPropertyKeyValue("lastName");
		int ranNum = jLib.getRandomNumber();
    	WebDriver driver;
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else {
			driver= new FirefoxDriver();
			
		}
		wLib.waitUntilPageLoad(driver);
		
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName+ranNum);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
		wLib.switchToFrame(driver, "status");
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		
		
	}

}
