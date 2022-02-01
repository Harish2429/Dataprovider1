package Vtiger_comcast_organizationtest;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.Generic.utilites.ExcelUtility;
import com.crm.Generic.utilites.FileUtility;
import com.crm.Generic.utilites.JavaUtility;
import com.crm.Generic.utilites.WebDriverUtility;

public class CreateOrganization {
public static void main(String[] args) throws Throwable {
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	int randomNum = jLib.getRandomNumber();
	
	/* common Data*/
	String username = fLib.getPropertyKeyValue("username");
	String password = fLib.getPropertyKeyValue("password");
	String url = fLib.getPropertyKeyValue("url");
	String browser = fLib.getPropertyKeyValue("browser");
	
	/* test script Data*/
	String orgName = eLib.getDataFromExcel("Sheet2", 0,0)+randomNum;
	
	/*navigate to app*/
	WebDriver driver= new ChromeDriver();
	wLib.waitUntilPageLoad(driver);
	driver.get(url);
	
	/*step1: login*/
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	WebElement ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	String text = ele.getText();
	System.out.println(text);
	if(text.contains(orgName))
	{
		System.out.println(orgName+"***created successfully***");
		
	}
	else {
		System.out.println("***not created successfully**");
		
	}
	
}
}
