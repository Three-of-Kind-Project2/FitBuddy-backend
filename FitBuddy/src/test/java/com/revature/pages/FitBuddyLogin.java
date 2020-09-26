package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FitBuddyLogin {

	public static final String title = "FitBuddy"; 
	
	// after logging in succesfully find an h3 on the page saying consumed table
	@FindBy(xpath = "//h3[text()='Consumed Table']")
	public WebElement header; 
	
	// sign off
	 @FindBy(xpath = "//input[@type='submit']")
	public WebElement signOfLink; 
	// constructor 
	public FitBuddyLogin (WebDriver driver) {
		PageFactory.initElements(driver,this); 
	}
}
