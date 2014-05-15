package com.genwi;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.thread.TestNGThread;

import com.google.gson.JsonSyntaxException;

public class refreshTest {
	
	FirefoxDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver, 200); 
	//private static final String outputFolder = "/Users/abirami/Documents/RefreshTests";

	String file = "/Users/abirami/Documents/RefreshTests/cacheStatus.json";
	String url = "http://app.genwi.com/5.0/cache/cacheStatus/45131";
	String url1 = "http://app.genwi.com/5.0/getjson/jsonObject/45131";
	
	File output = new File("/Users/abirami/Documents/RefreshTests/cacheStatus.json");
	File basejson = new File("/Users/abirami/Documents/RefreshTests/jsonObject.json");
	
 @BeforeClass
public void beforeClass() {
		  //driver.get("http://172.16.1.42:81");
		  driver.get("http://mcms.genwi.com");

}
 
 @Test (priority = 1)
 public void mCMSLogin() {
 	  driver.findElementByXPath("//input[@id='username']").sendKeys("abirami@genwi.com");
 	  driver.findElementByXPath("//input[@id='password']").sendKeys("genwiblr");
 	  driver.findElementByXPath("//input[@value='Login']").click();
 	  }
 	  
 @Test(priority = 2 )
 public void launchApp() {
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='accountlist']/div[15]/h2/a"))).click();
 	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='box45131']/h2/a"))).click();
 		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Content"))).click();
 		try {
 			TestNGThread.sleep(5000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();	
 		}
 	 }
	
 @Test (priority =3)
 public void addCategory(){
 		//adding a category with no data/ feed
 	   			
 		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Categories"))).click();
 		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Category"))).click();
 		wait.until(ExpectedConditions.elementToBeClickable(By.id("cattitle"))).sendKeys("Refresh Category A");
 		driver.findElementByLinkText("Save").click();
 		
 	try {
 				
 		Set<String> diff = JSONCompare.getTimestampDiff(file, url);
 		
 		System.out.println("Adding Category returned tab" + diff.toString());
 		
 		Scanner scanner = new Scanner(new URL(url).openStream(), "UTF-8");
 		String content = scanner.useDelimiter("\\A").next();
 		FileUtils.writeStringToFile(output, content);
 		scanner.close();
 		
 		String file = "/Users/abirami/Documents/Abirami/JSONCompare/jsonObject.json";
		String url = "http://app.genwi.com/5.0/getjson/jsonObject/45131";
		
		Set<String> incProperties = new HashSet<String>();
		incProperties.add("category_title");
		
		Assert.assertTrue(JSONCompare.compareJSON(file, url, incProperties, null));
 		
// 		Scanner scanner2 = new Scanner(new URL(url1).openStream(), "UTF-8");
// 		String content2 = scanner2.useDelimiter("\\A").next();
// 		FileUtils.writeStringToFile(basejson, content2);
// 		scanner2.close();
 		
 		Assert.assertTrue(diff.contains("3"));
 		
 	} catch (JsonSyntaxException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 	} catch (MalformedURLException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 	} catch (IOException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 	}
 }
 
// @Test (priority =5)
// public void hideCategory(){
// 	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Categories"))).click();
// 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl2_addtabs']ol/li[2]/div/div[4]"))).click();
// 	
// 	
// 	
// 	try {
// 		Set<String> diff = JSONCompare.getTimestampDiff(file, url);
// 			
// 		System.out.println("Hiding Category reuturned tab" + diff.toString());
// 		
// 		Scanner scanner = new Scanner(new URL(url).openStream(), "UTF-8");
// 		String content = scanner.useDelimiter("\\A").next();
// 	//	System.out.println(content);
// 		FileUtils.writeStringToFile(output, content);
// 		scanner.close();
// 		
// 		Assert.assertEquals(diff.contains("3"), true);
// 		
// 	} catch (JsonSyntaxException e) {
// 		// TODO Auto-generated catch block
// 		e.printStackTrace();
// 	} catch (MalformedURLException e) {
// 		// TODO Auto-generated catch block
// 		e.printStackTrace();
// 	} catch (IOException e) {
// 		// TODO Auto-generated catch block
// 		e.printStackTrace();
// 	}		
// 		
// }
//
// @Test (priority =6)
// public void unhideCategory(){
// 	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Categories"))).click();
// 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl2_addtabs']ol/li[2]/div/div[4]"))).click();
// 	
// 	try {
// 		String file = "/Users/abirami/Documents/RefreshTests/cacheStatus.json";
// 		String url = "http://app.genwi.com/5.0/cache/cacheStatus/45131";
// 		
// 		Set<String> diff = JSONCompare.getTimestampDiff(file, url);
// 			
// 		System.out.println("Unhiding Category reuturned tab" + diff.toString());
// 		
// 		Scanner scanner = new Scanner(new URL(url).openStream(), "UTF-8");
// 		String content = scanner.useDelimiter("\\A").next();
// 	//	System.out.println(content);
// 		FileUtils.writeStringToFile(output, content);
// 		scanner.close();
// 		
// 		Assert.assertEquals(diff.contains("3"), true);
// 		
// 	} catch (JsonSyntaxException e) {
// 		// TODO Auto-generated catch block
// 		e.printStackTrace();
// 	} catch (MalformedURLException e) {
// 		// TODO Auto-generated catch block
// 		e.printStackTrace();
// 	} catch (IOException e) {
// 		// TODO Auto-generated catch block
// 		e.printStackTrace();
// 	}		
// 		
// }

}