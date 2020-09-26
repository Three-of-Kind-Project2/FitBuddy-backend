
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
  // close automation for test
  public void afterClass() {
  driver.quit(); 
  }
  
  @Test
  public void confirmHomePage() {
	
	  assertEquals(driver.getTitle(), FitBuddyHome.title);
  }
  
  @Test(dependsOnMethods = {"confirmHomePage"}, timeOut = 5000)
  public void loginWorks() {
	  FitBuddyHome fbh = new FitBuddyHome(driver);
	 
	  // Instantiate corresponding pages
	  fbh.loginToFitBuddyLogin("pranavtest", "test");
	  // Login
	  FitBuddyLogin fbl = new FitBuddyLogin(driver);
	  // Obtain other page 
	  // Wait for it to be visible 
	  WebDriverWait wait = new WebDriverWait(driver, 50); 
	  wait.until(ExpectedConditions.visibilityOf(fbl.header)); 
	  
	  // Make assertion makes sure you can log in a
	  assertEquals(driver.getTitle(),FitBuddyLogin.title); 
  }
  
  

}
