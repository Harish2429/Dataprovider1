package com.crm.Generic.utilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/**
	 * its used to read the data from common data properties File based on key which you pass as an
	 * argument
	 * @throws Throwable 
	 */
public String getPropertyKeyValue(String key) throws Throwable
{
	FileInputStream fis=new FileInputStream(AutoConstant.propertyfilepath);
	Properties pobj=new Properties();
	pobj.load(fis);
	String value = pobj.getProperty(key);
	return value;
}
	
	
}
