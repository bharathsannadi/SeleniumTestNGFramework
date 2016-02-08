package com.testngframework.databuilder;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.testngframework.utility.ExcelUtil;

public class TestNGDataBuilder {

	@DataProvider(name = "Email")
	public static Object[][] getEmail() throws IOException {
		return ExcelUtil.ExcelTestDataRead("TestData");	
	}

}
