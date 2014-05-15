package com.genwi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.google.gson.JsonSyntaxException;


public class CopyOfcontentModification {
	
	FirefoxDriver d1 = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(d1, 200); 

  @BeforeClass
  public void beforeClass() {
		
		//d1.get("http://172.16.1.42/login");
	  d1.get("http://mcms.genwi.com");
  }
  
@Test (priority = 1)
public void TestLogin(){
	
	wait.until(ExpectedConditions.elementToBeClickable(By.id("username"))).sendKeys("abirami02@gmail.com");
	wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys("automation");
	
	d1.findElement(By.className("btn")).click();
	
}

@Test(priority = 2)
public void launchApp(){
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='accountlist']/div[1]/h2/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='box41979']/h2/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl0_menu']/ul/li[1]/a"))).click();
}

@Test(priority = 23)
public void deletearticleDesign()
{
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Design')]"))).click();
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[1]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='templateslist']/li[2]/a"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='templateslist']/li[2]/span/ul/li[4]/a"))).click();
	    Alert alert = d1.switchTo().alert();
		alert.accept();
	    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[4]/div[1]/div/span/ul/li[1]/a"))).click();
	    
}

@Test(priority = 24)
public void deletearticlesDesign_carousel()
{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[2]/a"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='link7756']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='lnk_7756']"))).click();
		Alert alert = d1.switchTo().alert();
		alert.accept();  
}
}