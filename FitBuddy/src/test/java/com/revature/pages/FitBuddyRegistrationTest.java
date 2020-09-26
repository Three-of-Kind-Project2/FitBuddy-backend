package com.revature.pages;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class FitBuddyRegistrationTest {
	public static WebDriver driver; 
	public final String url = "http://localhost:4200/registration";
 
  @BeforeClass
  public void beforeClass() {
	 //this file path works with Linux
	  File file = new File("src/main/resources/chromedriver");
	    //Commented out for windows
	//  File file = new File("src/main/resources/chromedriver.exe");
	  System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	  this.driver = new ChromeDriver(); 
	  driver.get(url); 
  }

  @AfterClass
  public void afterClass() {
	  driver.quit(); 
  }
  
  @Test
  public void confirmRegistrationPage() {
	
	  assertEquals(driver.getTitle(), FitBuddyHomeTwo.title);
  }
  
  @Test(dependsOnMethods = {"confirmRegistrationPage"}, timeOut = 5000)
  public void registrationWorks() {
	  FitBuddyHomeTwo fbh = new FitBuddyHomeTwo(driver);
		 
	  // Instantiate corresponding pages
	  fbh.registerToFitBuddyRegistration("John", "Doe", "Test1", "Test", "Test", "test1@gmail.com", "100");
	  
	  FitBuddyRegistration fbr = new FitBuddyRegistration(driver);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 50); 
	  wait.until(ExpectedConditions.visibilityOf(fbr.headerTwo)); 
	  
	  // Make assertion makes sure you can log in a
	  assertEquals(driver.getTitle(),FitBuddyRegistration.title); 
  }

}
