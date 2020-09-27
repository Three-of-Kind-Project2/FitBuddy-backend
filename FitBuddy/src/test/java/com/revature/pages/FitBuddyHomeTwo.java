package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FitBuddyHomeTwo {
	
	public final static String title = "FitBuddy"; 
	
	@FindBy(xpath = "//input[@name='fName']")
	public WebElement firstName; 
	@FindBy(xpath = "//input[@name='lName']")
	public WebElement lastName; 
	@FindBy(xpath = "//input[@name='username']")
	public WebElement username; 
	@FindBy(xpath = "//input[@name='password']")
	public WebElement password; 
	@FindBy(xpath = "//input[@name='vPassword']")
	public WebElement vpassword; 
	@FindBy(xpath = "//input[@name='email']")
	public WebElement email; 
	@FindBy(xpath = "//input[@name='goal']")
	public WebElement goal; 
	@FindBy(xpath = "//button[@name='Register']")
	public WebElement registerButton; 
    @FindBy(linkText = "About")
    public WebElement homelink; 
    @FindBy(xpath = "//a[text()='Register ']")
    public WebElement signOnLink; 
    
    //Fitbuddy Login webdriver method in constructor
    public FitBuddyHomeTwo (WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    
    public void registerToFitBuddyRegistration(String firstName,String lastName, String username, String password, String vpassword, String email, String goal ) {
    	this.firstName.sendKeys(firstName);
    	this.lastName.sendKeys(lastName);
    	this.username.sendKeys(username);
    	this.password.sendKeys(password);
    	this.vpassword.sendKeys(vpassword);
    	this.email.sendKeys(email); 
    	this.goal.sendKeys(goal); 
    	this.registerButton.click();
    }

	
	
	

}
