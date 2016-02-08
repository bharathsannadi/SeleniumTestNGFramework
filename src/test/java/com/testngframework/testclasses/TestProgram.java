package com.testngframework.testclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testngframework.databuilder.TestNGDataBuilder;
import com.testngframework.pages.*;

public class TestProgram {
	WebDriver driver;

	@BeforeTest
	public void initialize() {
		driver = new FirefoxDriver();
	}

	@Test(priority = 1, dataProvider = "Email", dataProviderClass = TestNGDataBuilder.class)
	public void homePage(String userName) {
		HomePage hmpg = new HomePage(driver);
		hmpg.SignIn("test");
	}

	@AfterTest
	public void close() {
		driver.close();
		driver.quit();
	}
}
