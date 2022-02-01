package practice;

import java.io.File;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.crm.Generic.utilites.BaseClass;

public class Demo2 extends BaseClass {
	
	@Test
	
	public void verifyHomepage(Method mtd) throws Throwable {
		System.out.println(mtd.getName());
		
		String currentTestName = mtd.getName();
		System.out.println("*****test strat****");
		
		EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
		 File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		File dstFile=new File("./Screenshot/"+currentTestName+".png");
		FileUtils.copyFile(srcFile, dstFile);
		System.out.println("*****test end*****");
		
		
	}
	

}
