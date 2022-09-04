package com.vtechsolution.orangehrm.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class configDataProvider {

	public static Properties prop;

	public configDataProvider(String configPath) {

		try {

			FileInputStream fins = new FileInputStream(configPath);
			prop = new Properties();
			prop.load(fins);

		} catch (Exception e) {

			System.out.println("File not found" + e.getMessage());

		}

	}

//	public String SearchKey(String Keyname) {
//		try {
//
//			FileInputStream fins = new FileInputStream("./Config/Config.properties");
//
//			prop = new Properties();
//
//			prop.load(fins);
//			
//			 return prop.getProperty(Keyname);
//
//		} catch (Exception e) {
//			
//			System.out.println("File Not Found" + e.getMessage());
//			return null;
//		}
//		}

	public String searkey(String Keyname) {
		return prop.getProperty(Keyname);
	}

	public String getUserName() {
		return prop.getProperty("username");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}

	public String getAppUrl() {
		return prop.getProperty("appUrl");
	}
}
