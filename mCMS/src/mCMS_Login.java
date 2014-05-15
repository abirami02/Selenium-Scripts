
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mCMS_Login {
	
	public static void main (String[] args) throws InterruptedException{
		
		FirefoxDriver d1 = new FirefoxDriver();
			
		d1.get("http://mcms.genwi.com/");
		
		
		d1.findElementByXPath("//input[@id='username']").sendKeys("abirami02@gmail.com");
		d1.findElementByXPath("//input[@id='password']").sendKeys("automation12");
		
		d1.findElementByXPath("//input[@value='Login']").click();
		
		//wait for the create an app link to appear and click on it
		WebDriverWait wait = new WebDriverWait(d1, 50);
		WebElement channelist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='channelist']/div/a/i")));
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
		d1.findElementByXPath("//form[@id='create_app']/ul/li/input").sendKeys("InstaApp_"+date);
		d1.findElementByXPath("//form[@id='create_app']/ul/li[2]/input").sendKeys("InstaApp_"+date);
		d1.findElementByXPath("//form[@id='create_app']/ul/li[3]/textarea").sendKeys("InstaApp_"+date);
		d1.findElementByXPath("//div[@id='create_app_language_chzn']/a/span").click();
		d1.findElementByXPath("//span[@id='addbtnplaceholder']/a").click();
	
		//wait for the go to content link to be available for clicking
		WebElement gotocontent = wait.until(ExpectedConditions.elementToBeClickable(By.id("gutter_content_footer")));
		gotocontent.click();
		
		//adding a new feed
		d1.findElementById("btnaddnewfeed").click();
		
		d1.findElementById("add_feed_form_url").sendKeys("http://syndication.indianexpress.com/rss/latest-news.xml");
		d1.findElementByXPath("//div[@id='add_feed_form_content_type_chzn']/a/span").click();
		d1.findElementByXPath("//div[@id='feedCategory_chzn']/ul/li/input").click();
		//d1.findElementByXPath("//div[@id='feedCategory_chzn']/ul/li/input").sendKeys("Test");
		d1.findElementById("btnsavefeed").click();
	
		
		//adding a post
		d1.findElementByLinkText("Posts").click();
		
		d1.findElementByLinkText("Add Post").click();
		d1.findElementByName("postTitle").sendKeys("Automation Post Title");
		d1.findElementByLinkText("Save").click();
		
		Boolean smsg = wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(".//*[@id='postformmsg']/div/p"), "Changes saved successfully"));
		
		if (smsg == true)
		{ System.out.println("post added successfully");}	
		
		
		//d1.quit();
	}
	
}
