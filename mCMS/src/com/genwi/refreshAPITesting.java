package com.genwi;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.internal.thread.TestNGThread;

import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;

public class refreshAPITesting {
	
	FirefoxDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver, 200); 
	
	String file = "/Users/abirami/Documents/RefreshTests/cacheStatus.json";
	String url = "http://app.genwi.com/5.0/cache/cacheStatus/45131";
	
	File output = new File("/Users/abirami/Documents/RefreshTests/cacheStatus.json");

 @BeforeClass
public void beforeClass() {
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
	  wait.until(ExpectedConditions.elementToBeClickable(By.linkText("APITest"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Content"))).click();
			
		Scanner scanner;
		try {
			scanner = new Scanner(new URL(url).openStream(), "UTF-8");
			String content = scanner.useDelimiter("\\A").next();
			//	System.out.println(content);
				FileUtils.writeStringToFile(output, content);
				scanner.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
		System.out.println(diff.contains("3"));
		
		Scanner scanner = new Scanner(new URL(url).openStream(), "UTF-8");
		String content = scanner.useDelimiter("\\A").next();
		FileUtils.writeStringToFile(output, content);
		scanner.close();
		Assert.assertTrue(diff.contains("3"));
		
		String file = "/Users/abirami/Documents/RefreshTests/jsonObject_addCat.json";
		String url = "http://app.genwi.com/5.0/getjson/jsonObject/45131";
		
		Set<String> incProperties = new HashSet<String>();
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

@Test (priority =4)
public void editCategoryTitle(){
 wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Categories"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl2_addtabs']/ol/li[2]/div/div/a[1]"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.id("cattitle"))).click();
	driver.findElementById("cattitle").sendKeys("Edited");
	driver.findElementByLinkText("Save").click();
	
	try {
		Set<String> diff = JSONCompare.getTimestampDiff(file, url);
			
		System.out.println("Editing Category Title reuturned tab" + diff.toString());
		
		Scanner scanner = new Scanner(new URL(url).openStream(), "UTF-8");
		String content = scanner.useDelimiter("\\A").next();
		FileUtils.writeStringToFile(output, content);
		scanner.close();
		Assert.assertEquals(diff.contains("3"), true);
		
		String file = "/Users/abirami/Documents/RefreshTests/jsonObject_editCat.json";
		String url = "http://app.genwi.com/5.0/getjson/jsonObject/45131";
		
		Set<String> incProperties = new HashSet<String>();
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

@Test (priority =7)
public void addPost(){
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Posts"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Post"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("postTitle"))).click();
		driver.findElementById("postTitle").sendKeys("Automation Post Title");	
		//driver.switchTo().frame("wysiwyg_ifr");
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tinymce']")));
		//((JavascriptExecutor) driver).executeScript("document.body.innerHTML = 'dummy text';");
		//driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='categoryType_chzn']/ul/li/input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='categoryType_chzn_o_0']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='18']/div[1]/img"))).click();
		driver.findElementByLinkText("Apply").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Posts"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Posts"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Posts"))).click();
		
		try {
			
			Set<String> diff = JSONCompare.getTimestampDiff(file, url);
			
			System.out.println("Adding Post Returned tab " + diff.toString());
			
			Scanner scanner = new Scanner(new URL(url).openStream(), "UTF-8");
			String content = scanner.useDelimiter("\\A").next();
			FileUtils.writeStringToFile(output, content);
			scanner.close();
			Assert.assertEquals(diff.contains("5"),true);
			
			String file = "/Users/abirami/Documents/RefreshTests/jsonObject_addPost.json";
			String url = "http://app.genwi.com/5.0/getjson/jsonObject/45131";
			Set<String> incProperties = new HashSet<String>();
			incProperties.add("item_title");
			System.out.println(JSONCompare.compareJSON(file, url, incProperties, null));
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

@Test (priority =8)
public void editPost(){
  wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Content"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Posts"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='postlist']/tbody/tr[1]/td[5]/a[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("postTitle"))).click();
		driver.findElementById("postTitle").sendKeys("Edited");	
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Apply"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Posts"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Posts"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Posts"))).click();
		
		try {
			
			Set<String> diff = JSONCompare.getTimestampDiff(file, url);
			
			System.out.println("Editing Post returned tab " + diff.toString());
			
			Scanner scanner = new Scanner(new URL(url).openStream(), "UTF-8");
			String content = scanner.useDelimiter("\\A").next();
			FileUtils.writeStringToFile(output, content);
			scanner.close();
			Assert.assertEquals(diff.contains("5"),true);
			
			String file = "/Users/abirami/Documents/RefreshTests/jsonObject_editPost.json";
			String url = "http://app.genwi.com/5.0/getjson/jsonObject/45131";
			Set<String> incProperties = new HashSet<String>();
			incProperties.add("item_title");
			System.out.println(JSONCompare.compareJSON(file, url, incProperties, null));
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

@Test (priority =9)
public void addFeed(){
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Feeds"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btnaddnewfeed"))).click();
		driver.findElementById("add_feed_form_url").sendKeys("http://www.mid-day.com/Resources/midday/rss/life-and-style-technology.xml");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='feedCategory_chzn']/ul/li/input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='feedCategory_chzn_o_0']"))).click();
		driver.findElementById("btnsavefeed").click();	
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Feeds"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Feeds"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Feeds"))).click();
		
		try {
			TestNGThread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			
			Set<String> diff = JSONCompare.getTimestampDiff(file, url);
			
			System.out.println("Adding Feed returned tab " + diff.toString());
			
			Scanner scanner = new Scanner(new URL(url).openStream(), "UTF-8");
			String content = scanner.useDelimiter("\\A").next();
			//System.out.println(content);
			FileUtils.writeStringToFile(output, content);
			scanner.close();
			
			Assert.assertEquals(diff.contains("5"),true);
			
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
@Test (priority =10)
public void deleteExistingCategory(){
	
 wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Categories"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl2_addtabs']/ol/li[2]/div/div/a[3]"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Categories"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Categories"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Categories"))).click();
	
	try {
		
		Set<String> diff = JSONCompare.getTimestampDiff(file, url);
		
		System.out.println("Deleting Existing Category returned tab " + diff.toString());
	
		Scanner scanner = new Scanner(new URL(url).openStream(), "UTF-8");
		String content = scanner.useDelimiter("\\A").next();
		//System.out.println(content);
		FileUtils.writeStringToFile(output, content);
		scanner.close();
		
		Assert.assertEquals(diff.contains("3"),true);
		
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

@Test (priority =11)
public void DeletePost(){
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Posts"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='postlist']/tbody/tr[1]/td[6]/a[1]"))).click();
     
		wait.until(ExpectedConditions.alertIsPresent());
      Alert alert =driver.switchTo().alert();
      alert.accept();
      wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Posts"))).click();
      wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Posts"))).click();
      wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Posts"))).click();
      
      try {
  		Set<String> diff = JSONCompare.getTimestampDiff(file, url);
  		
  		System.out.println("Deleting Post returned tab " + diff.toString());
  	
  		Scanner scanner = new Scanner(new URL(url).openStream(), "UTF-8");
  		String content = scanner.useDelimiter("\\A").next();
  		FileUtils.writeStringToFile(output, content);
  		scanner.close();
  		Assert.assertEquals(diff.contains("5"),true);
  		
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

@Test (priority = 12)
public void createTemplateAssigntoPost(){
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='blackmenuholder']/a[1]"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='blackmenu']/ul/li[2]/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='link18']"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menulink18']/ul/li[1]/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/form/ul/li/input"))).sendKeys("testPost");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addbtn_placeholder']/a"))).click();
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='templateslist']/li[3]/div[3]/input[2]"))).click();
	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tr_118161_45131_18']/div[3]/input[1]"))).click();
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='blackmenuholder']/a[1]"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='blackmenu']/ul/li[1]/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Posts"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Post"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.id("postTitle"))).click();
	driver.findElementById("postTitle").sendKeys("Automation Post Title");	
	driver.findElementByLinkText("Apply").click();
	
	try {
		Set<String> diff = JSONCompare.getTimestampDiff(file, url);
		
		System.out.println("Creating new Template and assing it to Post Returned tab " + diff.toString());
		
		Scanner scanner = new Scanner(new URL(url).openStream(), "UTF-8");
		String content = scanner.useDelimiter("\\A").next();
		FileUtils.writeStringToFile(output, content);
		scanner.close();
		
		Assert.assertEquals(diff.contains("4"),true);
		
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

@Test (priority = 13)
public void editPostAssignDiffTemplate(){
	 wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Content"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Posts"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='postlist']/tbody/tr[1]/td[5]/a[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("postTitle"))).click();
		driver.findElementById("postTitle").sendKeys("Edited");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='templateType']/li[2]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Apply"))).click();
		
		try {
			Set<String> diff = JSONCompare.getTimestampDiff(file, url);
			
			System.out.println("Editing Post and Assigning Different Template Returned tab " + diff.toString());
			
			Scanner scanner = new Scanner(new URL(url).openStream(), "UTF-8");
			String content = scanner.useDelimiter("\\A").next();
			//System.out.println(content);
			FileUtils.writeStringToFile(output, content);
			scanner.close();
			
			Assert.assertEquals(diff.contains("4"),true);
			
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
@Test (priority = 14)
public void deleteTemplate(){
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='blackmenuholder']/a[1]"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='blackmenu']/ul/li[2]/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='templateslist']/li[2]/div[3]/input[2]"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='templateslist']/li[3]/a"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='templateslist']/li[3]/span/ul/li[4]/a"))).click();
	wait.until(ExpectedConditions.alertIsPresent());
      Alert alert =driver.switchTo().alert();
      alert.accept();
      
      try {
    	  Set<String> diff = JSONCompare.getTimestampDiff(file, url);
			
			System.out.println("Deleting Template Returned tab " + diff.toString());
			
			Scanner scanner = new Scanner(new URL(url).openStream(), "UTF-8");
			String content = scanner.useDelimiter("\\A").next();
			//System.out.println(content);
			FileUtils.writeStringToFile(output, content);
			scanner.close();
			
			Assert.assertEquals(diff.contains("4"),true);
			
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

@AfterClass
public void afterclass() {
	driver.quit();
}

}
