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


public class Add_Designhtml {

        FirefoxDriver d1 = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(d1, 100);

  @BeforeClass
  public void beforeClass() {

                //d1.get("http://172.16.1.42/login");
          d1.get("http://mcms.genwi.com");
  }

@Test (priority = 1)
public void TestLogin(){

        d1.findElement(By.id("username")).sendKeys("abirami02@gmail.com");
        d1.findElement(By.id("password")).sendKeys("automation");

        d1.findElement(By.className("btn")).click();
}

@Test(priority = 2)
public void App(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='box41979']/h2/a"))).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_ctl0_menu']/ul/li[1]/a"))).click();
}

@Test(priority = 3)
public void articleDesign()
{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/header/div[2]/nav/span/span/ul/li[2]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[1]/div/span/ul/li[1]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/div/span/div/a[2]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/input"))).sendKeys("newarticle");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/span[1]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/div/span/div/a[1]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/div/span/div/ul/li/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/div/input"))).sendKeys("html/newarticle.html");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/span[1]/a"))).click();
	    
}

@Test(priority = 4)
public void articlesDesign_carousel()
{
	    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Design')]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[1]/div/span/ul/li[2]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/div/span/div/a[2]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/input"))).sendKeys("newarticles_with_carousel");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/span[1]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/div/span/div/a[1]/i"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/div/span/div/ul/li/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/div/input"))).sendKeys("html/newarticles_with_carousel.html");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/span[1]/a"))).click();    
}
/*//Articles list view
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

@Test(priority = 6)
public void categoriesDesign()
{	
	    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Design')]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[1]/div/span/ul/li[3]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/div/span/div/a[2]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/input"))).sendKeys("newgrid");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/span[1]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/div/span/div/a[1]/i"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/div/span/div/ul/li/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/div/input"))).sendKeys("html/newgrid.html");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/span[1]/a"))).click();    
}

@Test(priority = 7)
public void categoryMenuDesign()
{   
	    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Design')]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[1]/div/span/ul/li[4]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/div/span/div/a[2]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/input"))).sendKeys("newsections_menu");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/span[1]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/div/span/div/a[1]/i"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/div/span/div/ul/li/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/div/input"))).sendKeys("html/newsections_menu.html");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/span[1]/a"))).click();    
}

@Test(priority = 8)
public void favoritesDesign()
{
	    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Design')]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[1]/div/span/ul/li[5]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/div/span/div/a[2]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/input"))).sendKeys("newfavorites");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/span[1]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/div/span/div/a[1]/i"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/div/span/div/ul/li/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/div/input"))).sendKeys("html/newfavorites.html");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/span[1]/a"))).click();    
}

@Test(priority = 9)
public void searchDesign()
{
		//d1.findElementByXPath("//a[contains(text(),'Design')]").click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Design')]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[1]/div/span/ul/li[6]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/div/span/div/a[2]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/input"))).sendKeys("newsearch");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/span[1]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/div/span/div/a[1]/i"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/div/span/div/ul/li/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/div/input"))).sendKeys("html/newsearch.html");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/span[1]/a"))).click();    
}

@Test(priority = 10)
public void toolbarDesign()
{
	    //d1.findElementByXPath("//a[contains(text(),'Design')]").click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Design')]"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[1]/div/span/ul/li[7]/a"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/div/span/div/a[2]"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/input"))).sendKeys("newtoolbar");
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/span[1]/a"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/div/span/div/a[1]/i"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/div/span/div/ul/li/a"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/form/ul/li/div/input"))).sendKeys("html/newtoolbar.html");
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/span[1]/a"))).click();  
	    
	     
}

@Test(priority=11)
public void getAllActiveTmpl() {
	try {
		String file = "html/getAllActivetmpl_base.json";
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
}