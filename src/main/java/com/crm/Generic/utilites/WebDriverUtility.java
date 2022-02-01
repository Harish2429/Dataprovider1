package com.crm.Generic.utilites;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * this class contains WebDriver specific generic methods
 * @author DELL
 *
 */

public class WebDriverUtility {
	/**
	 * this method will maximize the window
	 * 
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	/**this method wait for 20sec for page loading
	 * 
	 */
	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	/**
	 * this method is used for wait until element to be click able
	 */
	
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * this method wait for the element to be visible
	 */
public void waitForElementVisibility(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOf(element));
	
	
}


/**this method wait for the element to be clicked.its custom wait created to avoid elemeninterAceptable
 * Exception
 * @throws InterruptedException 
 * 
 */
public void waitAndClick(WebElement element) throws InterruptedException
{
	int count=0;
	while(count<20){
		try {
			element.click();
			break;
		}
		catch(Throwable e){
			Thread.sleep(1000);
			count++;
			
			
		}
	}
}

/**
 * this method enables user to handle dropdown using visible text
 * 
 * 
 */
public void select(WebElement element,String text)
{
	Select sel=new Select(element);
	sel.selectByVisibleText(text);
	
}

/**
 * this methods enables user to handle dropdown using index
 * 
 */
public void select(WebElement element,int index)
{
	Select sel=new Select(element);
	sel.selectByIndex(index);
	
	
}

/**
 * this methods enables user to handle dropdown using value
 */

public void select(String value,WebElement element)
{
	Select sel=new Select(element);
	sel.selectByValue(value);
	
}


/**
 * this method will perform mouse over actions
 * 
 */
 public void mouserHover(WebDriver driver,WebElement element)
 {
	 Actions act=new Actions(driver);
	 act.moveToElement(element).perform();
	 
 }

 /**
  * this method perform right click operation
  */

 public void rightClick(WebDriver driver,WebElement element)
 {
	 Actions act=new Actions(driver);
	 act.contextClick(element).perform();
	 
 }
 
 /**
  * this method is used to  double click action
  */
 public void doubleClick(WebDriver driver)
 {
	 Actions act=new Actions(driver);
	 act.doubleClick().perform();
 }
 
 
 
 /**
  * this method is used to perform drag and drop actions
  * 
  */
 
 public void dragAndDrop(WebDriver driver,WebElement src,WebElement dest)
 {
	 Actions act=new Actions(driver);
	 act.dragAndDrop(src, dest).perform();
 }
 
 /**
  * this method helps to switch from one window  to window depending partial title
  * 
  */
 
 public void switchToWindow(WebDriver driver,String partialWinTitle)
 {
	 Set<String> window = driver.getWindowHandles();
	 Iterator<String> it = window.iterator();
	 while(it.hasNext())
	 {
		 String winId = it.next();
		 driver.switchTo().window(winId);
		 String title = driver.getTitle();
		 
		 if(title.contains(partialWinTitle))
		 {
			 break;
			 
		 }
	 }
 }
 
 
 /**
  * Accept alert pop_up
  * 
  */
 
 public void acceptAlert(WebDriver driver)
 {
	 driver.switchTo().alert().accept();
	 
 }
 
 
 /**
  * Cancel Alert pop_up
  * 
  
  */
 
 public void cancelAlert(WebDriver driver)
 {
	 driver.switchTo().alert().dismiss();
	 
	 
 }
 
 
 /**
  * this method used for scrolling action in webpage
  */
 
 public void scrollToWebElement(WebDriver driver,WebElement element)
 {
	 JavascriptExecutor js=(JavascriptExecutor) driver;
	 int Y = element.getLocation().getY();
	 js.executeScript("window.scrollBy(0,"+Y+")",element);
	 
	 
 }
 
 /**
  * this method is used to from one page to another by using index
  * 
  */
 
 public void switchFrame(WebDriver driver,int index)
 {
	 driver.switchTo().frame(index);
 }
 
 
 /**
  *  this method is used to from one page to another by using element
  */
 
 public void switchToFrame(WebDriver driver,WebElement element)
 {
	 driver.switchTo().frame(element);
	 
 }
 
 /**
  * 
  *this method is used to from one page to another by using id  
  * 
  */
 
 public void switchToFrame(WebDriver driver,String idOrName)
 {
	 driver.switchTo().frame(idOrName);
	 
 }
 
 /**
  * this method is used to navigate from child to main parent
  */
 
 public void switchToDefaultFrame(WebDriver driver)
 {
	 driver.switchTo().defaultContent();
 }
 
 
 /**
  * this method is used to navigate from child to immidiate parent module
  */
 public void switchToFrame(WebDriver driver)
 {
	 driver.switchTo().parentFrame();
 }
 
 /**
  * 

  * this method is used to TakeScreen shot 
 * @throws Throwable 
  */
 
 
 public void takeScreenshot(WebDriver driver,String screenShotName) throws Throwable
 {
	 TakesScreenshot ts=(TakesScreenshot) driver;
	 File src=ts.getScreenshotAs(OutputType.FILE);
	 File dest=new File("./screenshot/"+screenShotName+".PNG");
	 Files.copy(src, dest);
	 
	 
 }
 
 
 /**
  * 
  * pass enter key appertain into browser 
  * 
  * 
  */
 public void passEnterKey(WebDriver driver ) {
	 
	 Actions act=new Actions(driver);
	 act.sendKeys(Keys.ENTER).perform();
	 
 }
 
	/**
	 * used to pass Virtual key to OS
	 * @throws Throwable 
	 */
	public void pressVurtualEnterKey() throws Throwable {
		Robot rc=new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
		
	}

}