package com.crm.Generic.utilites;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;

import java.util.Random;
/**
 * this class contains java specific generic libraries
 * @author DELL
 *
 */

public class JavaUtility {
	/**
	 * this method will generate a random number and return t to the caller
	 * 
	 */
	public int getRandomNumber()
	{
		Random ran=new Random();
		int random=ran.nextInt(1000);
		return random;
	}
	/*
	 * this method is used to get the current system date & time
	 */
	public String getCurrentDate()
	{
		Date date=new Date();
		String currentdate = date.toString();
		return currentdate;
	}
	
/*
 * this method will return date in specified format
 * 
 */
	public String getFinalDateFormat()
	{
		Date date=new Date();
		String d = date.toString();
		String[] dte = d.split(" ");
	     String YYYY = dte[5];
	     String dd = dte[2];
	     String mm = dte[1];
	     String today = YYYY+"-"+mm+"-"+dd;
	     return today;
		
	}


}
