
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

public class FitBuddyLoginTest {
	
	public static WebDriver driver; 
	public final String url = "http://localhost:4200/";
 
  @BeforeClass
  public void beforeClass() {
	  String filepath = "src/test/resources/";
	  String os = System.getProperty("os.name").substring(0, 3);
	  
	  switch (os) {
	  	case "Win":
	  		filepath += ("chromedriver_windows.exe");
	  		break;
	  	case "Mac":
	  		filepath += ("chromedriver_mac");
	  		break;
	  	case "Lin":
	  		filepath += ("chromedriver_linux");
	  		break;
	  }
	  
	  File file = new File(filepath);
	  System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	  driver = new ChromeDriver(); 
	  driver.get(url + "login"); 
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
  
  @Test(dependsOnMethods = {"confirmHomePage"}, timeOut = 20000)
  public void loginWorks() {
	  FitBuddyHome fbh = new FitBuddyHome(driver);
	 
	  // Instantiate corresponding pages
	  fbh.loginToFitBuddyLogin("test", "test");
	  // Login
	  // Wait for it to be visible 
	  WebDriverWait wait = new WebDriverWait(driver, 20); 
	  wait.until(ExpectedConditions.urlToBe(url + "userhome"));
	  
	  // Make assertion makes sure you can log in a
	  assertEquals(driver.getTitle(),FitBuddyLogin.title); 
  }
  
  

}
