package com.genwi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.google.gson.JsonSyntaxException;


public class Activity_Tracking {
	
	FirefoxDriver d1 = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(d1, 100); 

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

@Test(priority=2)
public void selectAccount() {
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='accountlist']/div[2]/h2/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='box44334']/h2/a"))).click();
	
}

@Test(priority=3)
public void addFeed() throws BiffException, IOException{
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl0_menu']/ul/li[1]/a"))).click();
	
	/*FileInputStream fi = new FileInputStream("/Users/abirami/Downloads/Newsfeedlinks.xls");
	Workbook w = Workbook.getWorkbook(fi);
	Sheet s = w.getSheet(0);
	for (int i=10; i<30; i++) {
		String feedurl = s.getCell(1, i).getContents();

	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='btnaddnewfeed']"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='add_feed_form_url']"))).sendKeys(feedurl);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='feedCategory_chzn']/ul/li/input"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='feedCategory_chzn']/ul/li/input"))).sendKeys(i+"Category");
	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='feedCategory_chzn']/div/ul/li[2]/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='btnsavefeed']"))).click();
	
	}*/
	
}
@Test(priority=4)
public void addCat() {
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[6]/a"))).click();
	for (int j=201; j<401; j++) {
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addbtn_placeholder']/a[1]"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cattitle']"))).sendKeys(j+"Category");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='btnsavecategory']"))).click();
	}
}

}




