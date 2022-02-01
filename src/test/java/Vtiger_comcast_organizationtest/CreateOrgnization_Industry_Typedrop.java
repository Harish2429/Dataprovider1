package Vtiger_comcast_organizationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.Generic.utilites.ExcelUtility;
import com.crm.Generic.utilites.FileUtility;
import com.crm.Generic.utilites.JavaUtility;
import com.crm.Generic.utilites.WebDriverUtility;

public class CreateOrgnization_Industry_Typedrop {
	public static void main(String[] args) throws Throwable, Throwable {
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		int randomNum = jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("Sheet2", 0,0)+randomNum;
		String username = fLib.getPropertyKeyValue("username");
		String password = fLib.getPropertyKeyValue("password");
		String url = fLib.getPropertyKeyValue("url");
		String browser = fLib.getPropertyKeyValue("browser");
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			
		}
		else {
			driver=new ChromeDriver();
		}
		wLib.waitUntilPageLoad(driver);
		driver.get(url);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		WebElement dd = driver.findElement(By.name("industry"));
		wLib.select(dd, "Education");
		WebElement dd1 = driver.findElement(By.name("accounttype"));
		wLib.select(dd1, "Customer");
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
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouserHover(driver, ele1);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.quit();
		
}
}
