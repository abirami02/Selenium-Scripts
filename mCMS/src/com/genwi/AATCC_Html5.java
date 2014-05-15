package com.genwi;


import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.Assert;
import org.openqa.selenium.Keys;

public class AATCC_Html5 {
	
	FirefoxDriver d1 = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(d1, 100); 
	String text;

  @BeforeClass
  public void beforeClass() {
	  d1.get("http://172.16.1.20/4.0/html5/40563");
  }
  
@Test (priority = 1)
public void homePage() {
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='homenews']/div[1]/a/div"))).click();
	//wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(".//*[@id='articleContainer-nothumbs']/div/div[2]/div[1]"), ""))
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_statictoolbar']/header/div/a[2]/div"))).click();	
}

@Test(priority=2)
public void emptyFav(){
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_statictoolbar']/header/div/a[5]/div"))).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='favoritesContainer']/div/p")));
	text = d1.findElement(By.xpath(".//*[@id='favoritesContainer']/div/div/div/div/p")).getText();
	System.out.println(text);
	Assert.assertTrue(text.contains("No favorites"));
	//d1.get("http://172.16.1.20/4.0/html5/40563");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='sectionsBtn']/div"))).click();
	
}

@Test(priority=3)
public void sectionsMenu() {
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='sectionsBtn']/div"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cat_53722']"))).click();
	text = d1.findElement(By.xpath(".//*[@id='articlesContainer']/div/p")).getText();
	Assert.assertTrue(text.contains("Feature Stories"));
	
	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='sectionsBtn']/div"))).click();
	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cat_53717']"))).click();
	//text = d1.findElement(By.xpath(".//*[@id='articlesContainer']/div/p")).getText();
	//Assert.assertTrue(text.contains("Events"));
	
	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='sectionsBtn']/div"))).click();
	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cat_53718']"))).click();
	//text = d1.findElement(By.xpath(".//*[@id='articlesContainer']/div/p")).getText();
	//Assert.assertTrue(text.contains("A2 Now"));
	
}

@Test(priority=5)
public void addFav(){
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='homenews']/div[1]/a/div"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_statictoolbar']/header/div/a[4]/div"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_statictoolbar']/header/div/a[2]/div"))).click();	
}
@Test(priority=6)
public void verifyFav(){
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_statictoolbar']/header/div/a[5]/div"))).click();
	
}

@Test(priority=4)
public void searchTerm(){
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='sectionsBtn']/div"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='sections_search']"))).sendKeys("AATCC");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='sections_search']"))).sendKeys(Keys.RETURN);
}
}