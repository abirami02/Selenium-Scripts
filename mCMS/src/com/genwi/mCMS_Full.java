package com.genwi;

//import static org.junit.Assume.assumeTrue;

import java.sql.Driver;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class mCMS_Full {
	
	FirefoxDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver, 70);
	DateFormat dateformat = new SimpleDateFormat("ddmmyy");
	Date date = new Date();

	
	  @BeforeClass
	public void beforeClass() {
		  //driver.get("http://172.16.1.42:81");
		  driver.get("http://mcms.genwi.com");
	  }



	  @Test (priority = 1)
	  public void Login() {
	  driver.findElementByXPath("//input[@id='username']").sendKeys("abirami@genwi.com");
	  driver.findElementByXPath("//input[@id='password']").sendKeys("genwiblr");
	  driver.findElementByXPath("//input[@value='Login']").click();
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='accountlist']/div[2]/h2/a"))).click();
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='channelist']/div[1]/a/i"))).click();  
	  System.out.println(dateformat.format(date));
	  WebElement themelistNewsfeed = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='themeslist']/li[1]/a/div")));
		themelistNewsfeed.click();
	  }
		
	  @Test (priority =2)

	  public void createApp(){
			wait.until(ExpectedConditions.elementToBeClickable(By.name("name"))).sendKeys("InstaApp_"+date);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='clone_app_url']"))).sendKeys("InstaApp_"+date);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='clone_app_description']"))).sendKeys("InstaApp_"+date);		
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='clone_app_language_chzn']/a/span"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='save_form']"))).click();		
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='gutter_olap_content_header']"))).click();	
	  }
	  

	  @Test (priority =3)

	  public void addCategories(){
			
			for (int i=0; i<5; i++)
			{
			// add a category with proper feed 		
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Categories"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Category"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("cattitle"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("cattitle"))).sendKeys("Category " + i);
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Save"))).click();		
			}
		 
						
	  }
	
	  @Test (priority =4)
	  public void previewCategory(){
			// Clicking on preview link
			String winHandleBefore = driver.getWindowHandle();
			WebElement preview =wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl2_addtabs']/ol/li[2]/div/div/a[2]")));
		  	preview.click();
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(By.id("ipadmini"))).click();
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.close();
			driver.switchTo().window(winHandleBefore);
				
	  }
	  
	
	   @Test (priority =5)
	        public void addFeeds(){
			//adding a feed without images	
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Feeds"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("btnaddnewfeed"))).click();			
			driver.findElementById("add_feed_form_url").sendKeys("http://feeds.reuters.com/reuters/bankruptcyNews");		
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='feedCategory_chzn']/ul/li/input"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='feedCategory_chzn_o_1']"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("btnsavefeed"))).click();
		
			
			//adding a feed with proper content
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Feeds"))).click();
			WebElement gotoaddnewfeed1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnaddnewfeed")));
			gotoaddnewfeed1.click();		
			driver.findElementById("add_feed_form_url").sendKeys("http://syndication.indianexpress.com/rss/latest-news.xml");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='feedCategory_chzn']/ul/li/input"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='feedCategory_chzn_o_2']"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("btnsavefeed"))).click();
									
			
			//adding a feed with Videos 					
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Feeds"))).click();
			WebElement gotoaddnewfeed2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnaddnewfeed")));
			gotoaddnewfeed2.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("add_feed_form_url"))).sendKeys("http://feeds.reuters.com/reuters/INVideoMostWatched");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='feedCategory_chzn']/ul/li/input"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='feedCategory_chzn_o_3']"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("btnsavefeed"))).click();
			
	   }
	   @Test (priority=6)
	   public void addSocialFeeds(){
			//adding a socialfeed with Wordpress
	        
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Social Media"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("WordPress"))).click();
			WebElement addwordpressfeed = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnsavewebservicesfeed")));
			addwordpressfeed.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("basic_username_form_username"))).sendKeys("genwiblore");
			//driver.findElementById("basic_username_form_username").sendKeys("genwiblore");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='feedCategory_chzn']/ul/li/input"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='feedCategory_chzn_o_4']"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("btnsavewebservicesfeed"))).click();
	 
	  }
	  
	  
	  
	   @Test (priority =7)
		  public void previewFeeds(){
				// Clicking on preview link
		        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Feeds"))).click();
				String winHandleBeforepreview = driver.getWindowHandle();
				WebElement previewfeed =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='SubHeader_preview_placeholder']/a[1]")));
			  	//driver.findElement(By.xpath("//*[@id='SubHeader_preview_placeholder']/a/span[1]")).click();
				previewfeed.click();
				for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
				}
				
				wait.until(ExpectedConditions.elementToBeClickable(By.id("ipadmini"))).click();
				driver.close();
				driver.switchTo().window(winHandleBeforepreview);
					
		  }
	   
	   @Test (priority =8)
		  public void previewfixedcontentFeed(){
				// Clicking on preview link
			    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Social Media"))).click();
			    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("WordPress"))).click();
				String winHandleBeforepreview = driver.getWindowHandle();
				WebElement previewfixedfeed =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='SubHeader_preview_placeholder']/a[1]")));
			  	//driver.findElement(By.xpath("//*[@id='SubHeader_preview_placeholder']/a/span[1]")).click();
				previewfixedfeed.click();
				for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
				}
				
				wait.until(ExpectedConditions.elementToBeClickable(By.id("ipadmini"))).click();
				driver.close();
				driver.switchTo().window(winHandleBeforepreview);
					
		  }
	   
	  
	  @Test (priority =9)
	  public void addPost(){
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Posts"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Post"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("postTitle"))).click();
			driver.findElementById("postTitle").sendKeys("Automation Post Title");		
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='categoryType_chzn']/ul/li/input"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='categoryType_chzn_o_3']"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Apply"))).click();
	  }
	  
	   @Test (priority =10)
		  public void previewPost(){
				// Clicking on preview link
		        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Posts"))).click();
				String winHandleBeforepost = driver.getWindowHandle();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='SubHeader_preview_placeholder']/a[1]"))).click();
			  
				for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
				}
				
				wait.until(ExpectedConditions.elementToBeClickable(By.id("ipadmini"))).click();  		
				driver.close();
				driver.switchTo().window(winHandleBeforepost);
					
		  }
	   
	  @AfterClass 
	  public void AfterClass(){
      driver.quit();
	  }
	  	
}
