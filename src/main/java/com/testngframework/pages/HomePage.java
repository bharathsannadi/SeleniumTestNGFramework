package com.testngframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testngframework.utility.ConfigLoaderUtil;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath=".//*[@id='displayMyStore']")
	WebElement FindMyStore;
	
	@FindBy(xpath=".//*[@id='searchButton']")
	WebElement Search;
	
	@FindBy(linkText="Sign Up for Specials")
	WebElement SignUp;
	
	@FindBy(linkText="Espa�ol")
	WebElement Language;
	
	@FindBy(xpath=".//*[@id='featuredProductsDiv']/div/div[2]/a/img")
	WebElement Logo;
	
	@FindBy(linkText="Furniture")
	WebElement Furniture;
	
	@FindBy(linkText="Appliances")
	WebElement  Appliances;
	
	@FindBy(linkText=" Computers")
	WebElement Computers;
	
	@FindBy(linkText="Smartphones ")
	WebElement  Smartphones;
	
	@FindBy(linkText="Specials")
	WebElement  Specials ;
	
	@FindBy(xpath=".//*[@id='signUpEmailField']")
	WebElement  Email ;
	
	@FindBy(xpath=".//*[@id='signUpFormButton']")
	WebElement  Submit ;
	
	ConfigLoaderUtil consts;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		consts = new ConfigLoaderUtil();
		driver.get(consts.constantValue("URL"));
		PageFactory.initElements(driver, this);
	}
	
	public void SignIn(String EmailId){
		SignUp.click();
		Email.sendKeys(EmailId);
		Submit.click();
	}

	public void UIValidation(){
		
	}
	
}
