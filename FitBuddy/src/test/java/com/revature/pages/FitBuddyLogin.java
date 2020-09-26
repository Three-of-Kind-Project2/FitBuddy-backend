package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FitBuddyLogin {
	
	public final String title = "Angular"; 
	
	@FindBy(xpath = "//input[@name='username']")
	//maps to username on page
	public WebElement username; 
	//maps to password on page
    @FindBy(name = "password")
	public WebElement password; 
    //maps to submit button on page
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitButton; 
    //Fitbuddy Login webdriver method in constructor
    public FitBuddyLogin (WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
   // method for logging in on webpage
    public void loginToFitBuddyLogin(String username, String password) {
    	this.username.sendKeys(username);
    	this.password.sendKeys(password);
    	this.submitButton.click();
    }
}
