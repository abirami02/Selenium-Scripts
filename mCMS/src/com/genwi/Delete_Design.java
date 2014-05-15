package com.genwi;
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


public class Delete_Design {

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
public void deletearticleDesign()
{
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/header/div[2]/nav/span/span/ul/li[2]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[1]/div/span/ul/li[1]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/span[8]/ul/li[2]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Delete')]"))).click();
	    Alert alert = d1.switchTo().alert();
		alert.accept();
	    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[4]/div[1]/div/span/ul/li[1]/a"))).click();
	    
}

@Test(priority = 4)
public void deletearticlesDesign_carousel()
{
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[1]/div/span/ul/li[2]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/span[5]/ul/li[3]/a"))).click();										
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/span[5]/ul/li[3]/span/ul/li[4]/a"))).click();
	    Alert alert = d1.switchTo().alert();
		alert.accept();  
}

/*
@Test(priority = 7)
public void deletearticlesDesign_list()
{
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[4]/div[1]/div/span/ul/li[2]/a"))).click();
	    d1.findElementByXPath("html/body/div[4]/div[2]/span/span[5]/ul/li[3]/a").click();
	    d1.findElementByXPath("html/body/div[4]/div[2]/span/span[5]/ul/li[3]/span/ul/li[4]/a").click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[4]/div[1]/div/span/ul/li[2]/a"))).click();   
}

*/

@Test(priority = 5)
public void deletecategoriesDesign()
{
	    //d1.findElementByXPath("//a[contains(text(),'Design')]").click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[1]/div/span/ul/li[3]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/span[2]/ul/li[2]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/span[2]/ul/li[2]/span/ul/li[4]/a"))).click();
	    Alert alert = d1.switchTo().alert();
		alert.accept(); 
}

@Test(priority = 6)
public void deletecategoryMenuDesign()
{
	    //d1.findElementByXPath("//a[contains(text(),'Design')]").click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[1]/div/span/ul/li[4]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/span[23]/ul/li[1]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/span[23]/ul/li[1]/span/ul/li[4]/a"))).click();
	    Alert alert = d1.switchTo().alert();
		alert.accept(); 
}

@Test(priority = 7)
public void deletefavoritesDesign()
{
	    //d1.findElementByXPath("//a[contains(text(),'Design')]").click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[1]/div/span/ul/li[5]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/span[11]/ul/li[2]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/span[11]/ul/li[2]/span/ul/li[4]/a"))).click();					   
	    Alert alert = d1.switchTo().alert();
		alert.accept();  
}

@Test(priority = 8)
public void deletesearchDesign()
{
	    //d1.findElementByXPath("//a[contains(text(),'Design')]").click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[1]/div/span/ul/li[6]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/span[17]/ul/li[1]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/span[17]/ul/li[1]/span/ul/li[4]/a"))).click();					   
	    Alert alert = d1.switchTo().alert();
		alert.accept();  
}

@Test(priority = 9)
public void toolbarDesign()
{
	    //d1.findElementByXPath("//a[contains(text(),'Design')]").click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[1]/div/span/ul/li[7]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/span[20]/ul/li[1]/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[2]/span/span[20]/ul/li[1]/span/ul/li[4]/a"))).click();				   
	    Alert alert = d1.switchTo().alert();
		alert.accept();  
}

}
