package com.org.basefile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	Properties pro;
	
	public ConfigReader() {
		
		try {
			File src = new File("./Configs/Configuation.properties");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}  catch (IOException e) {
			System.out.println("Exception is=="+e.getMessage());
		}
	}

public String getChroDriver(){
	
	return pro.getProperty("Browser");
}
public String getAppURL() {
	
	return pro.getProperty("URL");
}
}


