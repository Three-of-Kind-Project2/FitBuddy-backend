package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FitBuddyRegistration {
	
	public static final String title = "FitBuddy"; 
	
	@FindBy(xpath = "//h2[text()='Login']")
	public WebElement headerTwo; 
	
	 @FindBy(xpath = "//input[@type='submit']")
	public WebElement signOnLink; 
	 
		public FitBuddyRegistration (WebDriver driver) {
			PageFactory.initElements(driver,this); 
		}

}
