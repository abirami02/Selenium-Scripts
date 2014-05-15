package com.genwi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.google.gson.JsonSyntaxException;


public class Sample_Test {
	
	FirefoxDriver d1 = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(d1, 100); 

  @BeforeClass
  public void beforeClass() {
		
		d1.get("http://mcms.genwi.com/");
  }
@AfterClass
public void AfterClass(){
	//d1.findElementByXPath("//a[contains(text(),'Logout')]").click();
	//d1.quit();
}
  
@Test(priority=1)
public void testLogin(){
	
	d1.findElement(By.id("username")).sendKeys("abirami02@gmail.com");
	d1.findElement(By.id("password")).sendKeys("automation");
	
	d1.findElement(By.className("btn")).click();
}

@Test(priority=2)
public void createApp(){
	
	//wait for the create an app link to appear and click on it
			
			WebElement channelist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='channelist']/div[1]/a/i")));
			channelist.click();
			
			//create new instaApp with current date & time
			DateFormat dateformat = new SimpleDateFormat("ddmmyy");
			Date date = new Date();
			//String date1 = dateformat.format(date);
			System.out.println(dateformat.format(date));
			
			//wait for the themelist link to be available for clicking
			WebElement themelist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='themeslist']/li/a/div/img")));
			themelist.click();
			
			//create an app
			d1.findElement(By.id("create_app_name")).sendKeys("InstaApp_"+date);
			d1.findElement(By.id("create_app_url")).sendKeys("InstaApp_"+date);
			d1.findElement(By.id("create_app_description")).sendKeys("InstaApp_"+date);
			d1.findElement(By.id("save_form")).click();
	
}

@Test(priority=3)
public void addFeed(){
	//wait for the go to content link to be available for clicking
			wait.until(ExpectedConditions.elementToBeClickable(By.id("gutter_content_footer"))).click();
			
			//adding a new feed
			wait.until(ExpectedConditions.elementToBeClickable(By.id("btnaddnewfeed"))).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.id("add_feed_form_url"))).sendKeys("http://syndication.indianexpress.com/rss/latest-news.xml");
			d1.findElementById("btnsavefeed").click();
			//JSONCompare.compareJSON(, url)
}

@Test(priority=4)
public void delFeed(){
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='feedlist']/tbody/tr[1]/td[4]/a[3]"))).click();
	Alert alert = d1.switchTo().alert();
	alert.accept();
}

@Test(priority=5)
public void addSMFeed() {
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[3]/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='wordpress_link']/a"))).click();
	d1.findElement(By.id("btnsavewebservicesfeed")).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.id("basic_username_form_username"))).sendKeys("genwiblore");
	d1.findElement(By.id("btnsavewebservicesfeed")).click();
}

@Test(priority=8)
public void addPost(){
	//adding a post
		d1.findElementByLinkText("Posts").click();
			
		for (int j=1;j<=5;j++)
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Post"))).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("postTitle"))).sendKeys("Automation Post Title "+j);
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tinymce']/p"))).sendKeys("Auto Post Description " + j);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='categoryType_chzn']/ul/li/input"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='categoryType_chzn_o_0']"))).click();
			
			d1.findElementByLinkText("Save").click();
			
			String msg = d1.findElement(By.id("postformmsg")).getText();
			Assert.assertTrue(msg.contains("saved"), "Changes saved successfully");
		}
		

}

@Test(priority=9)
public void delPost(){
	d1.findElementByLinkText("Posts").click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='postlist']/tbody/tr/td[6]/a"))).click();
	Alert alert = d1.switchTo().alert();
	alert.accept();
}

@Test(priority=6)
public void addCat() {
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[6]/a"))).click();
	
	for(int i=0;i<3;i++)
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addbtn_placeholder']/a[1]"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("cattitle"))).sendKeys("Auto Category "+i);
		d1.findElement(By.id("btnsavecategory")).click();
		
		String msg1= d1.findElement(By.xpath(".//*[@id='formcontainerdiv']/div[1]/p")).getText();
	//	System.out.println(msg1);
		Assert.assertTrue(msg1.contains("saved"),"Changes saved successfully");
		
	}	
}

@Test(priority=7) 
public void delCat() {
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[6]/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl2_addtabs']/ol/li[2]/div/div[1]/a[3]"))).click();	

}

@Test(priority=10)
public void editCat(){

	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[6]/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl2_addtabs']/ol/li[2]/div/div/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.id("cattitle"))).sendKeys("Modified");
	d1.findElement(By.id("btnsavecategory")).click();
	
}

@Test(priority=11)
public void editPost(){

	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[4]/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='postlist']/tbody/tr[1]/td[5]/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.id("postTitle"))).sendKeys("Modified");
	d1.findElement(By.id("savebtn")).click();
	
}


}
