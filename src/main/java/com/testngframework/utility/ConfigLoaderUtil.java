package com.testngframework.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoaderUtil {

	String value;

	public String constantValue(String key) {
		Properties prop = new Properties();
		try {

			String fileName = System.getProperty("user.dir");
			fileName += "/src/test/resources/"
					+ "EnviromentalVariables.properties";
			FileInputStream fis = new FileInputStream(fileName);
			prop.load(fis);
			fis.close();
			value = prop.getProperty(key);
			System.out.println("value :- " + value);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return value;
	}
}
