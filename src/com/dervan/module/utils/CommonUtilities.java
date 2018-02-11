package com.dervan.module.utils;

import java.util.Date;

public class CommonUtilities {
	public static Date getDate(){
		Date date = new Date();
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		return sqldate;
	}
	
	public static String getUsername(){
		return "Dervan";
	}
}
