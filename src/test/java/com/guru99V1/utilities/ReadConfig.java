package com.guru99V1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig
{
	Properties pro;
	
	public ReadConfig( ) 
	{
		File src=new File("Configuration\\config.properties");
		
		try 
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e)
		{
			System.out.println("Exception is: "+e.getMessage());
		}
	}
	
	public String getApplicationUrl()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getUsername()
	{
		String uName=pro.getProperty("username");
		return uName;
	}
	public String getPassword()
	{
		String pwd=pro.getProperty("password");
		return pwd;
	}
	public String getChromePath()
	{
		String cPath=pro.getProperty("chromePath");
		return cPath;
	}
	public String getFirefoxPath()
	{
		String fPath=pro.getProperty("firefoxPath");
		return fPath;
	}
	
	
}
