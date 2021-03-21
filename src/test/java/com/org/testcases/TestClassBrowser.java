package com.org.testcases;

import org.testng.annotations.Test;

import com.org.basefile.*;

public class TestClassBrowser extends BaseFileLynnox{

	@Test
	public void checkingAll() {
		
		ConfigReader reader = new ConfigReader();
		driverInit(reader.getChroDriver(),reader.getAppURL());
		
		
	}
	
}
