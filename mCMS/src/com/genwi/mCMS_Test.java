package com.genwi;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.google.gson.JsonSyntaxException;


public class mCMS_Test {
	
	ProfilesIni allProfiles = new ProfilesIni();
	FirefoxProfile profile = allProfiles.getProfile("Abirami");
	FirefoxDriver d1 = new FirefoxDriver(profile);
	
	WebDriverWait wait = new WebDriverWait(d1, 100); 
	
	String url = "http://mcms.genwi.com/";

  @BeforeClass
  public void beforeClass() {
		
		d1.get(url);
  }
  
  @Test (priority = 1)
  public void mCMSLogin() {
  	  d1.findElementByXPath("//input[@id='username']").sendKeys("appsbackup@genwi.com");
  	  d1.findElementByXPath("//input[@id='password']").sendKeys("genwi123");
  	  d1.findElementByXPath("//input[@value='Login']").click();
  	  }
  
  @Test(priority = 2 )
  public void backupApp() {
	   List<WebElement> linkElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("account")));
	   int length = linkElements.size();
	  System.out.println("Number of apps in the account " + length );
	  
	  for (int i=2; i<=length; i++)
	  {
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='accountlist']/div["+i+"]/h2/a"))).click();
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='channelist']/div[1]/h2/a"))).click();
      //wait.until(ExpectedConditions.elementToBeClickable(By.className("app"))).click();
      wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Design"))).click();
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl3_menu']/ul/li[6]/a"))).click();
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_div_download']/a"))).click();
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='zip_download_message']/p/a"))).click();
      d1.get(url);
      
      }
  }
  
@AfterClass()
public void afterClass()
{
	
	d1.quit();
}

}