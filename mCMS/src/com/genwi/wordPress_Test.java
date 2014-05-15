package com.genwi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

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

public class wordPress_Test {
	
	FirefoxDriver d1 = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(d1, 100); 
  
@Test (priority = 0)
public void addSMFeed() {
	 d1.get("http://mcms.genwi.com");
	 	
	 	wait.until(ExpectedConditions.elementToBeClickable(By.id("username"))).sendKeys("abirami02@gmail.com");
	 	wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys("automation");
	 	
	 	d1.findElement(By.className("btn")).click();
	 	//Launch app
	 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='accountlist']/div[1]/h2/a"))).click();
	 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='box41979']/h2/a"))).click();
	 	//Wordpress link
	 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl0_menu']/ul/li[1]/a"))).click();
	 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[3]/a"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='wordpress_link']/a"))).click();	 
		
		d1.findElement(By.id("btnsavewebservicesfeed")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("basic_username_form_username"))).sendKeys("genwiblore");
		d1.findElement(By.id("btnsavewebservicesfeed")).click();
}
@Test (priority = 1)
public void TestLogin(){
	 d1.get("http://wordpress.com/wp-login.php");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='user_login']"))).sendKeys("genwiblore");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='user_pass']"))).sendKeys("genwi@123");
	
	d1.findElement(By.xpath(".//*[@id='wp-submit']")).click();
	
}

@Test (priority = 2)
public void addWPPost() throws InterruptedException {
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='menu-dash-newpost']/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ipt-form-format-aside']/span[2]"))).click();
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ipt-aside-title']/input"))).sendKeys("Automation Post");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ipt-form-publish']"))).click();
	
Thread.sleep(1800000);
	
}

@Test (priority = 3)
public void verifyPost() {
	 d1.get("http://mcms.genwi.com");
	 	
	 	//wait.until(ExpectedConditions.elementToBeClickable(By.id("username"))).sendKeys("abirami02@gmail.com");
	 	//wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys("automation");
	 	
	 	//d1.findElement(By.className("btn")).click();
	 	//Launch app
	 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='accountlist']/div[1]/h2/a"))).click();
	 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='box41979']/h2/a"))).click();
	 	//Wordpress link
	 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl0_menu']/ul/li[1]/a"))).click();
	 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[3]/a"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='wordpress_link']/a"))).click();	 
		//verify newly added post
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='social_feeds_table_body']/tr/td[4]/a[1]/span[2]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='list_feed_items_table_filter']/label/input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='list_feed_items_table_filter']/label/input"))).sendKeys("Automation Post");
		
		String msg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='list_feed_items_table']/tbody/tr[1]/td[1]"))).getText();
		
		System.out.println(msg);
		
		Assert.assertTrue(msg.contains("Automation Test"), "Automation Test");
		

	 }

@Test (priority = 4)
public void editWPPost() throws InterruptedException {
	d1.get("http://wordpress.com/wp-login.php");
	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='user_login']"))).sendKeys("genwiblore");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='user_pass']"))).sendKeys("genwi@123");
	d1.findElement(By.xpath(".//*[@id='wp-submit']")).click();
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='wp-admin-bar-newdash-my-blogs']/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='my-blogs-content']/ul/li[1]/div[2]/p[1]/a[1]"))).click();
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='the-list']/tr[1]/td/strong/a[1]"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='title']"))).sendKeys(" Modified");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='publish']"))).click();
	
Thread.sleep(1800000);
}

@Test (priority = 5)
public void verifyEditPost() {
	 d1.get("http://mcms.genwi.com");
	 	
	 //	wait.until(ExpectedConditions.elementToBeClickable(By.id("username"))).sendKeys("abirami02@gmail.com");
	 //	wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys("automation");
	 	
	 //	d1.findElement(By.className("btn")).click();
	 	//Launch app
	 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='accountlist']/div[1]/h2/a"))).click();
	 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='box41979']/h2/a"))).click();
	 	//Wordpress link
	 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl0_menu']/ul/li[1]/a"))).click();
	 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[3]/a"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='wordpress_link']/a"))).click();	 
		//verify newly added post
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='social_feeds_table_body']/tr/td[4]/a[1]/span[2]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='list_feed_items_table_filter']/label/input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='list_feed_items_table_filter']/label/input"))).sendKeys("Automation Post");
		
		String msg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='list_feed_items_table']/tbody/tr[1]/td[1]"))).getText();
		
		System.out.println(msg);
		
		Assert.assertTrue(msg.contains("Modified"), "Automation Test Modified");		
	 }

@Test (priority = 6)
public void delWPPost() {
	d1.get("http://wordpress.com/wp-login.php");
	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='user_login']"))).sendKeys("genwiblore");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='user_pass']"))).sendKeys("genwi@123");
	
	d1.findElement(By.xpath(".//*[@id='wp-submit']")).click();
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='wp-admin-bar-newdash-my-blogs']/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='my-blogs-content']/ul/li[1]/div[2]/p[1]/a[1]"))).click();
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='the-list']/tr[1]/td/strong/a[1]"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='delete-action']/a"))).click();

}


}