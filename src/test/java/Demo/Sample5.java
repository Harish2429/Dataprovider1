package Demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Sample5 {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/data/data2.properties.txt");
	    Properties pobj=new Properties();
	    pobj.load(fis);
	    String browser = pobj.getProperty("browser");
	    String url = pobj.getProperty("url");
		String username = pobj.getProperty("username");
		String password = pobj.getProperty("password");
		String product_name = pobj.getProperty("product_name");
		WebDriver driver;
		if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		WebElement ele = driver.findElement(By.id("qccombo"));
		ele.click();
	    Select s=new Select(ele);
	    s.selectByVisibleText("New Product");
	    ele.click();
	    driver.findElement(By.name("productname")).sendKeys(product_name);
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    Actions act=new Actions(driver);
	    act.moveToElement(ele1).perform();
	    driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	   
	    
	    
	    
	    
		
	}

}
