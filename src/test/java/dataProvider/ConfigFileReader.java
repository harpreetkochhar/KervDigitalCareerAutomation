package dataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Properties;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileReader;
import java.lang.String;
import java.lang.NumberFormatException;
import enums.DriverType;


import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

//This Class is used to read .properties file and get the webdriver path, browser etc..
public class ConfigFileReader 
{

	private Properties properties;
	private final String propertyFilePath = "config//Configurations.properties";
	private static final Logger Logger = LoggerFactory.getLogger(ConfigFileReader.class);
 
//Constructor
	public ConfigFileReader()
	{
		BufferedReader reader;
		try
		{
		   reader = new BufferedReader(new FileReader(propertyFilePath));
		   properties = new Properties();
		   try {
		   properties.load(reader);
		   reader.close();
		   } catch (IOException e)
		{
			e.printStackTrace();
		} 
		} catch(FileNotFoundException e)
		   {
			e.printStackTrace();
			throw new RuntimeException("Configuration.propeties not found at " + propertyFilePath);
		   }
		
	}
	

//Get Driver path from configuration.properties file:
 public String getChromeDriverPath()
{
	String driverPath = properties.getProperty("chromeDriverPath");
	if(driverPath != null)
		return driverPath;
	else throw new RuntimeException("driverPath not specified in the configuration.properties file.");
	}

 
// Get browser from configuration.properties file
public DriverType getBrowser()
{
	String specifiedBrowser = properties.getProperty("browser");
	//if (specifiedBrowser != null)
		//return getBrowser(specifiedBrowser);
	return DriverType.CHROME;
	//else
		//Logger.warn("There is no browser specified in configuration.properties file");
}

public DriverType getBrowser(String specifiedBrowser)
{
	DriverType returnDriverType = null;
	DriverType specifiedDriverType;
	specifiedDriverType = DriverType.valueOf(specifiedBrowser.toUpperCase());
	
	switch ( specifiedDriverType)
	{
	case CHROME:
		returnDriverType = DriverType.CHROME;
		break;
	}
	return returnDriverType;
}

// Get Implicit wait time from Propeties file:
public long getImplicitlyWait()
{
	String implicitlywait = properties.getProperty("implicitlyWait");
	if (implicitlywait != null)
	{
		try
		{
			return Long.parseLong(implicitlywait);
		} catch (NumberFormatException e)
		{
			throw new RuntimeException("Not able to parse value" + implicitlywait+ "into Long" );
		}
	}
	return 30;
}

//Get Application URL:
public String getApplicationURL()
{
	String URL = properties.getProperty("applicationURL");
    return URL;
	
}

}

