package com.lexa.starter.sparkjava.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {
	
	private final String CONFIG_LOCATION = "com/lexa/starter/sparkjava/resources/config.properties";
	private Properties configProp = null;
	
	public String getString(String key){
		lazyLoadConfigFile();
		return configProp.getProperty(key);
	}
	
	public int getInt(String key){
		int response = 0;//Default Value
		String value = getString(key);
		
		if(null != value && value.trim().length() > 0){
			try {
				response = Integer.parseInt(value);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		return response;
	}
	
	private void lazyLoadConfigFile(){
		if(null == configProp){
			configProp = new Properties();
			InputStream in = this.getClass().getClassLoader().getResourceAsStream(CONFIG_LOCATION);
			try {
				configProp.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
