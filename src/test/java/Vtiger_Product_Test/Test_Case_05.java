package Vtiger_Product_Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Test_Case_05 {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis= new FileInputStream("./src/data/commanData.properties.txt");
		//step2: create an object to property class to load all the keys
		Properties pobj=new Properties();
		pobj.load(fis);
		//step3: read the value using get property("key")
		String url = pobj.getProperty("url");
		String username = pobj.getProperty("username");
		String password = pobj.getProperty("password");
		String productName = pobj.getProperty("productName");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(productName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG' and @style='padding: 0px;padding-left:5px']"));
		 Actions act=new Actions(driver);
		 act.moveToElement(ele).perform();
	    driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}

}
