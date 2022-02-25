package com.test.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.test.constants.SourcePath;

public class Utils {

	public static String getApplicationProperty(String key)
	{
		Properties properties=new Properties();
		String filePath=SourcePath.CONFIG_PROPERTIES_PATH;
		FileInputStream input=null;
		try {
			input=new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			properties.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value=properties.getProperty(key);
		return value;
	}}
