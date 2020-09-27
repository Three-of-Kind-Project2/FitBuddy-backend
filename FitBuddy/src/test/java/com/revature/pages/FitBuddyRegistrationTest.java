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
	  driver.get(url + "registration"); 
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
	  fbh.registerToFitBuddyRegistration("Test", "Test", "test", "test", "test", "test@email.com", "1500");
	  	  
	  WebDriverWait wait = new WebDriverWait(driver, 50); 
	  wait.until(ExpectedConditions.urlToBe(url + "login")); 
	  
	  // Make assertion makes sure you can log in a
	  assertEquals(driver.getTitle(),FitBuddyRegistration.title); 
  }

}
