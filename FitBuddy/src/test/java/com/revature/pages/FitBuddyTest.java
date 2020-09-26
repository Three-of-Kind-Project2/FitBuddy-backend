package com.revature.pages;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class FitBuddyTest {
	
	public static WebDriver driver; 
	public final String url = "http://localhost:4200/login";
  @Test
  public void f() {
  }
  @BeforeClass
  public void beforeClass() {
	  File file = new File("src/main/resources/chromedriver.exe");
	  System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	  this.driver = new ChromeDriver(); 
	  driver.get(url); 
  }

  @AfterClass
  public void afterClass() {
  driver.quit(); 
  }
  
  @Test
  public void confirmHomePage() {
	  FitBuddyLogin fl = new FitBuddyLogin(driver); 
	  assertEquals(driver.getTitle(), fl.title);
  }
  
  @Test
  public void loginWorks() {
	  FitBuddyLogin fl = new FitBuddyLogin(driver);
	  fl.loginToFitBuddyLogin("pranavuday", "password");
  }
  
  

}
