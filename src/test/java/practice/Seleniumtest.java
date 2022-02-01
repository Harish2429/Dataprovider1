package practice;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Seleniumtest {
	public static void main(String[] args) throws IOException {
		//step1:get the java representation object of the physical file
		FileInputStream fis= new FileInputStream("./src/data/commanData.properties.txt");
		//step2: create an object to property class to load all the keys
		Properties pobj=new Properties();
		pobj.load(fis);
		//step3: read the value using get property("key")
		String browser = pobj.getProperty("browser");
		String url = pobj.getProperty("url");
		String username = pobj.getProperty("username");
		String password = pobj.getProperty("password");
		WebDriver driver=new FirefoxDriver();
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.quit();
		
	}

}
