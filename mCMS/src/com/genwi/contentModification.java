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


public class contentModification {
	
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

@Test(priority = 3)
public void addCat() {
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[6]/a"))).click();
	
	for(int i=1;i<4;i++)
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addbtn_placeholder']/a[1]"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("cattitle"))).sendKeys("Auto Category "+ i );
	
		d1.switchTo().frame("desc_ifr");
		d1.switchTo().activeElement().sendKeys("Test");
		d1.switchTo().defaultContent();
		
		d1.findElement(By.id("btnsavecategory")).click();
		
		String msg1= d1.findElement(By.xpath(".//*[@id='formcontainerdiv']/div[1]/p")).getText();
	//	System.out.println(msg1);
		Assert.assertTrue(msg1.contains("saved"),"Changes saved successfully");
		
	}	
	try {
		String file = "/Users/abirami/Documents/Abirami/JSONCompare/jsonObject_addCat.json";
		String url = "http://app.genwi.com/4.0/getjson/jsonObject/41979";
		
		Set<String> incProperties = new HashSet<String>();
		incProperties.add("category_title");
		
		Assert.assertTrue(JSONCompare.compareJSON(file, url, incProperties, null));
		
		file = "/Users/abirami/Documents/Abirami/JSONCompare/skeleton_addCat.json" ;
		url = "http://app.genwi.com/4.0/getjson/skeleton/41979";
		
		Assert.assertTrue(JSONCompare.compareJSON(file, url, incProperties, null));
		
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

@Test(priority=4)
public void deactivateCat() {
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[6]/a")));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl2_addtabs']/ol/li[2]/div/div[4]/input"))).click();
		
	try {
		Thread.sleep(30);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	try {
		
		String file = "/Users/abirami/Documents/Abirami/JSONCompare/jsonObject_deactivateCat.json";
		String url = "http://app.genwi.com/4.0/getjson/jsonObject/41979";
		
		Set<String> incProperties = new HashSet<String>();
		incProperties.add("category_title");
		
		Assert.assertTrue(JSONCompare.compareJSON(file, url, incProperties, null));
		
		file = "/Users/abirami/Documents/Abirami/JSONCompare/skeleton_deactivateCat.json" ;
		url = "http://app.genwi.com/4.0/getjson/skeleton/41979";
		
		Assert.assertTrue(JSONCompare.compareJSON(file, url, incProperties, null));
		
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

@Test(priority=5)
public void activateCat() {
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[6]/a")));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl2_addtabs']/ol/li[2]/div/div[4]/input"))).click();
	
	try {
		Thread.sleep(30);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	try {
		
		String file = "/Users/abirami/Documents/Abirami/JSONCompare/jsonObject_activateCat.json";
		String url = "http://app.genwi.com/4.0/getjson/jsonObject/41979";
		
		Set<String> incProperties = new HashSet<String>();
		incProperties.add("category_title");
		
		Assert.assertTrue(JSONCompare.compareJSON(file, url, incProperties, null));
		
		file = "/Users/abirami/Documents/Abirami/JSONCompare/skeleton_activateCat.json" ;
		url = "http://app.genwi.com/4.0/getjson/skeleton/41979";
		
		Assert.assertTrue(JSONCompare.compareJSON(file, url, incProperties, null));
		
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

@Test(priority=6)
public void editCat(){

	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[6]/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl2_addtabs']/ol/li[2]/div/div/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.id("cattitle"))).sendKeys("Modified");
	
	d1.switchTo().frame("desc_ifr");
	d1.switchTo().activeElement().sendKeys(" Modified ");
	d1.switchTo().defaultContent();
	
	d1.findElement(By.id("btnsavecategory")).click();
	
	try {
		String file = "/Users/abirami/Documents/Abirami/JSONCompare/jsonObject_editCat.json";
		String url = "http://app.genwi.com/4.0/getjson/jsonObject/41979";
		
		Set<String> incProperties = new HashSet<String>();
		incProperties.add("category_title");
		
		Assert.assertTrue(JSONCompare.compareJSON(file, url, incProperties, null));
		
		file = "/Users/abirami/Documents/Abirami/JSONCompare/skeleton_editCat.json" ;
		url = "http://app.genwi.com/4.0/getjson/skeleton/41979";
		
		Assert.assertTrue(JSONCompare.compareJSON(file, url, incProperties, null));
		
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

@Test(priority=5) 
public void delCat() {
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[6]/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl2_addtabs']/ol/li[2]/div/div[1]/a[3]"))).click();	

try {
	String file = "/Users/abirami/Documents/Abirami/JSONCompare/jsonObject_delCat.json";
	String url = "http://app.genwi.com/4.0/getjson/jsonObject/41979";
	
	Set<String> incProperties = new HashSet<String>();
	incProperties.add("category_title");
	
	Assert.assertTrue(JSONCompare.compareJSON(file, url, incProperties, null));
	
	incProperties.clear();
	incProperties.add("category_title");
	
	file = "/Users/abirami/Documents/Abirami/JSONCompare/skeleton_delCat.json" ;
	url = "http://app.genwi.com/4.0/getjson/skeleton/41979";
	
	Assert.assertTrue(JSONCompare.compareJSON(file, url, incProperties, null));
	
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


@Test(priority=7)
public void addPost(){
	//adding a post
		d1.findElementByLinkText("Posts").click();
			
		for (int j=1;j<3;j++)
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Post"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("postTitle"))).sendKeys("Automation Post Title " + j);
			
			
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='categoryType_chzn']/ul/li/input"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='categoryType_chzn_o_0']"))).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Save"))).click();
			
			String msg = d1.findElement(By.id("postformmsg")).getText();
			Assert.assertTrue(msg.contains("saved"), "Changes saved successfully");
		}
		try {
			String file = "/Users/abirami/Documents/Abirami/JSONCompare/jsonObject_addPost.json";
			String url = "http://app.genwi.com/4.0/getjson/jsonObject/41979";
		
			Set<String> incProperties = new HashSet<String>();
			incProperties.add("category_title");
			incProperties.add("item_title");
			incProperties.add("article_tmpl");
			incProperties.add("parent_cat_title");
			incProperties.add("articles_tmpl");
			
			Assert.assertTrue(JSONCompare.compareJSON(file, url, incProperties, null));
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

@Test(priority=9)
public void editPost(){

	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[4]/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='postlist']/tbody/tr[1]/td[5]/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.id("postTitle"))).sendKeys("Modified");
	d1.findElement(By.id("savebtn")).click();

	try {
		String file = "/Users/abirami/Documents/Abirami/JSONCompare/jsonObject_editPost.json";
		String url = "http://app.genwi.com/4.0/getjson/jsonObject/41979";
	
		Set<String> incProperties = new HashSet<String>();
		incProperties.add("category_title");
		incProperties.add("item_title");
		incProperties.add("article_tmpl");
		incProperties.add("parent_cat_title");
		incProperties.add("articles_tmpl");
		
		Assert.assertTrue(JSONCompare.compareJSON(file, url, incProperties, null));
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

@Test(priority=10)
public void delPost(){
	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Posts"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='postlist']/tbody/tr/td[6]/a"))).click();
	Alert alert = d1.switchTo().alert();
	alert.accept();
	
	try {
		String file = "/Users/abirami/Documents/Abirami/JSONCompare/jsonObject_delPost.json";
		String url = "http://app.genwi.com/4.0/getjson/jsonObject/41979";
	
		Set<String> incProperties = new HashSet<String>();
		incProperties.add("category_title");
		incProperties.add("item_title");
		incProperties.add("article_tmpl");
		incProperties.add("parent_cat_title");
		incProperties.add("articles_tmpl");
		
		Assert.assertTrue(JSONCompare.compareJSON(file, url, incProperties, null));
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

@Test(priority=11)
public void addFeed(){
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Feeds"))).click();
			//adding a new feed
			wait.until(ExpectedConditions.elementToBeClickable(By.id("btnaddnewfeed"))).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.id("add_feed_form_url"))).sendKeys("http://syndication.indianexpress.com/rss/latest-news.xml");
			d1.findElementById("btnsavefeed").click();
			//JSONCompare.compareJSON(, url)
}
@Test(priority=12)
public void delFeed(){
	
	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Feeds"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='feedlist']/tbody/tr[1]/td[4]/a[3]"))).click();
	Alert alert = d1.switchTo().alert();
	alert.accept();

try {
	String file = "/Users/abirami/Documents/Abirami/JSONCompare/jsonObject_delFeed.json";
	String url = "http://app.genwi.com/4.0/getjson/jsonObject/41979";
	
	Set<String> incProperties = new HashSet<String>();
	incProperties.add("category_title");
	incProperties.add("item_title");
	incProperties.add("article_tmpl");
	incProperties.add("parent_cat_title");
	incProperties.add("articles_tmpl");
	
	Assert.assertTrue(JSONCompare.compareJSON(file, url, incProperties, null));
	
	file = "/Users/abirami/Documents/Abirami/JSONCompare/skeleton_delCat.json" ;
	url = "http://app.genwi.com/4.0/getjson/skeleton/41979";
	
	Assert.assertTrue(JSONCompare.compareJSON(file, url, incProperties, null));
	
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

@Test(priority=13)
public void addSMFeed() {
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[3]/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='wordpress_link']/a"))).click();
	d1.findElement(By.id("btnsavewebservicesfeed")).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.id("basic_username_form_username"))).sendKeys("genwiblore");
	d1.findElement(By.id("btnsavewebservicesfeed")).click();

	try {
		String file = "/Users/abirami/Documents/Abirami/JSONCompare/jsonObject_addSMFeed.json";
		String url = "http://app.genwi.com/4.0/getjson/jsonObject/41979";
		
		Set<String> incProperties = new HashSet<String>();
		incProperties.add("category_title");
		incProperties.add("item_title");
		incProperties.add("article_tmpl");
		incProperties.add("parent_cat_title");
		incProperties.add("articles_tmpl");
		
		Assert.assertTrue(JSONCompare.compareJSON(file, url, incProperties, null));
		
		file = "/Users/abirami/Documents/Abirami/JSONCompare/skeleton_addSMFeed.json" ;
		url = "http://app.genwi.com/4.0/getjson/skeleton/41979";
		
		incProperties = new HashSet<String>();
		incProperties.add("category_title");
		
		Assert.assertTrue(JSONCompare.compareJSON(file, url, incProperties, null));
		
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

@Test(priority=14)
public void delSMFeed(){
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[3]/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='wordpress_link']/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='social_feeds_table_body']/tr/td[4]/a[3]"))).click();
	Alert alert = d1.switchTo().alert();
	alert.accept();
	
	try {
		String file = "/Users/abirami/Documents/Abirami/JSONCompare/jsonObject_delSMFeed.json";
		String url = "http://app.genwi.com/4.0/getjson/jsonObject/41979";
		
		Set<String> incProperties = new HashSet<String>();
		incProperties.add("category_title");
		incProperties.add("item_title");
		incProperties.add("article_tmpl");
		incProperties.add("parent_cat_title");
		incProperties.add("articles_tmpl");
		
		Assert.assertTrue(JSONCompare.compareJSON(file, url, incProperties, null));
		
		file = "/Users/abirami/Documents/Abirami/JSONCompare/skeleton_delSMFeed.json" ;
		url = "http://app.genwi.com/4.0/getjson/skeleton/41979";
		
		incProperties = new HashSet<String>();
		incProperties.add("category_title");
		
		Assert.assertTrue(JSONCompare.compareJSON(file, url, incProperties, null));
		
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


@Test(priority = 15)
public void articleDesign()
{
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='Header_breadtrail_placeholder']/ul/li[4]/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl0_menu']/ul/li[2]/a"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[1]/a"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Create Article Layout')]"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/input"))).sendKeys("newarticle");
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addbtn_placeholder']/a"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl2_addbtn']/div/a[1]/i"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addtemplatemenu']/li/a"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='file']"))).sendKeys("/Users/somashekar/Documents/Build/QA-working/QA/mCMS_Automation_Scripts/mCMS/html/newarticle.html");
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addbtn_placeholder']/a"))).click();
	    
}

@Test(priority = 16)
public void articlesDesign_carousel()
{
	    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Design')]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[2]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='_ctl2_addbtn']/div/a[2]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/input"))).sendKeys("newarticles_with_carousel");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addbtn_placeholder']/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl2_addbtn']/div/a[1]/i"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addtemplatemenu']/li/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/div/input"))).sendKeys("/Users/somashekar/Documents/Build/QA-working/QA/mCMS_Automation_Scripts/mCMS/html/newarticles_with_carousel.html");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addbtn_placeholder']/a"))).click();      
}
//Articles list view
/*
@Test(priority = 5)
public void articlesDesign_list()
{
	    //d1.findElementByXPath("//a[contains(text(),'Design')]").click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[4]/div[1]/div/span/ul/li[2]/a"))).click();
	    d1.findElementByXPath("html/body/div[4]/div[2]/span/span[5]/ul/li[2]/a").click();
	    d1.findElementByXPath("html/body/div[4]/div[2]/span/span[5]/ul/li[2]/span/ul/li[1]/a").click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[4]/div/form/ul/li/input"))).sendKeys("newarticles_with_list");
	    d1.findElementByXPath("html/body/div[3]/span[1]/a").click();
	      
}

*/

@Test(priority = 17)
public void categoriesDesign()
{	
	    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Design')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[3]/a"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='_ctl2_addbtn']/div/a[2]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/input"))).sendKeys("newgrid");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addbtn_placeholder']/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl2_addbtn']/div/a[1]/i"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addtemplatemenu']/li/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/div/input"))).sendKeys("/Users/somashekar/Documents/Build/QA-working/QA/mCMS_Automation_Scripts/mCMS/html/newgrid.html");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addbtn_placeholder']/a"))).click(); 
	   }

@Test(priority = 18)
public void categoryMenuDesign()
{   
	   //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Design')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[4]/a"))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='_ctl2_addbtn']/div/a[2]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/input"))).sendKeys("newsections_menu");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addbtn_placeholder']/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl2_addbtn']/div/a[1]/i"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addtemplatemenu']/li/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/div/input"))).sendKeys("/Users/somashekar/Documents/Build/QA-working/QA/mCMS_Automation_Scripts/mCMS/html/newsections_menu.html");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addbtn_placeholder']/a"))).click();    
}

@Test(priority = 19)
public void favoritesDesign()
{
	    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Design')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[5]/a"))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='_ctl2_addbtn']/div/a[2]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/input"))).sendKeys("newfavorites");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addbtn_placeholder']/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl2_addbtn']/div/a[1]/i"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addtemplatemenu']/li/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/div/input"))).sendKeys("/Users/somashekar/Documents/Build/QA-working/QA/mCMS_Automation_Scripts/mCMS/html/newfavorites.html");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addbtn_placeholder']/a"))).click();     
}

@Test(priority = 20)
public void searchDesign()
{
		//d1.findElementByXPath("//a[contains(text(),'Design')]").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[6]/a"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='_ctl2_addbtn']/div/a[2]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/input"))).sendKeys("newsearch");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addbtn_placeholder']/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl2_addbtn']/div/a[1]/i"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addtemplatemenu']/li/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/div/input"))).sendKeys("/Users/somashekar/Documents/Build/QA-working/QA/mCMS_Automation_Scripts/mCMS/html/newsearch.html");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addbtn_placeholder']/a"))).click();    
}

@Test(priority = 21)
public void toolbarDesign()
{
	     //d1.findElementByXPath("//a[contains(text(),'Design')]").click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[7]/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='_ctl2_addbtn']/div/a[2]"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/input"))).sendKeys("newtoolbar");
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addbtn_placeholder']/a"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl2_addbtn']/div/a[1]/i"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addtemplatemenu']/li/a"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/div/input"))).sendKeys("/Users/somashekar/Documents/Build/QA-working/QA/mCMS_Automation_Scripts/mCMS/html/newtoolbar.html");
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addbtn_placeholder']/a"))).click(); 
	    
	     
}

@Test(priority=22)
public void getAllActiveTmpl() {
	try {
		String file = "/Users/abirami/Documents/Abirami/JSONCompare/getAllActivetmpl_base.json";
		String url = "http://107.21.33.153//4.0/getjson/getAllActiveTmpl/41979";
		
		Assert.assertTrue(JSONCompare.compareJSON(file, url, null, null));
		
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

/*
@Test(priority = 7)
public void deletearticlesDesign_list()
{
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[2]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='link7756']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='lnk_7756']"))).click();
	    Alert alert = d1.switchTo().alert();
		alert.accept();
		}
*/


@Test(priority = 25)
public void deletecategoriesDesign()
{
	    //d1.findElementByXPath("//a[contains(text(),'Design')]").click();
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[3]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='link7756']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='lnk_7756']"))).click();
	    Alert alert = d1.switchTo().alert();
		alert.accept(); 
}

@Test(priority = 26)
public void deletecategoryMenuDesign()
{
	    //d1.findElementByXPath("//a[contains(text(),'Design')]").click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[4]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='link7756']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='lnk_7756']"))).click();
	    Alert alert = d1.switchTo().alert();
		alert.accept(); 
}

@Test(priority = 27)
public void deletefavoritesDesign()
{
	    //d1.findElementByXPath("//a[contains(text(),'Design')]").click();
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[5]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='link7756']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='lnk_7756']"))).click();
	    Alert alert = d1.switchTo().alert();
		alert.accept();  
}

@Test(priority = 28)
public void deletesearchDesign()
{
	    //d1.findElementByXPath("//a[contains(text(),'Design')]").click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[6]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='link7756']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='lnk_7756']"))).click();
	    Alert alert = d1.switchTo().alert();
		alert.accept();  
}

@Test(priority = 29)
public void deltoolbarDesign()
{
	    //d1.findElementByXPath("//a[contains(text(),'Design')]").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl1_menu']/ul/li[7]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='link7756']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='lnk_7756']"))).click();
	    Alert alert = d1.switchTo().alert();
		alert.accept();
		  
		  
}

}


