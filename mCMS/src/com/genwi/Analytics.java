package com.genwi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class Analytics {
	
	String url1 ="jdbc:mysql://172.16.1.20/genwi_dbo";
    // Load Microsoft SQL Server JDBC driver
    String dbClass = "com.mysql.jdbc.Driver";
	
@Test(priority=1)
public void testArticleViews() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
	
    Class.forName(dbClass).newInstance();
    //Get connection to DB
    Connection con = DriverManager.getConnection(url1, "cms", "");
    //Create Statement
    Statement stmt = (Statement) con.createStatement();
    // method which returns the requested information as rows of data
    ResultSet result = (ResultSet) stmt.executeQuery("select count(*) from gw_rssitemsclicks_ext3 where network_id=45142 AND item_id!=0 AND DATE(item_viewDateTime) = CURDATE();");
    
    if(result.next())
    	System.out.println("Total Number of Article Views: " + result.getInt(1));
 
}  

@Test(priority=3)
public void testArticlesViews() throws SQLException
{
	 Connection con = DriverManager.getConnection(url1, "cms", "");
	  Statement stmt = (Statement) con.createStatement();
	  
    ResultSet result1 = (ResultSet) stmt.executeQuery("select count(*) from gw_rssitemsclicks_ext3 where network_id=45142 AND item_id=0 AND DATE(item_viewDateTime) = CURDATE();");
      
    if(result1.next())
	  System.out.println("Total Number of Articles Views: " + result1.getInt(1));
}

@Test(priority=3)
public void testShareViews() throws SQLException
{
	 Connection con = DriverManager.getConnection(url1, "cms", "");
	  Statement stmt = (Statement) con.createStatement();
	  
    ResultSet result1 = (ResultSet) stmt.executeQuery("select count(*) from gw_sharedetails where network_id=45142 AND DATE(dateadded) = CURDATE();");
      
    if(result1.next())
	  System.out.println("Total Number of Share Views: " + result1.getInt(1));
}

@Test(priority=4)
public void testActives() throws SQLException
{
	 Connection con = DriverManager.getConnection(url1, "cms", "");
	  Statement stmt = (Statement) con.createStatement();
	  
    ResultSet result1 = (ResultSet) stmt.executeQuery("select count(*) from gw_app_session_length where network_id=45142 AND DATE(dateadded) = CURDATE();");
      
    if(result1.next())
	  System.out.println("Total Number of Actives: " + result1.getInt(1));
}

}
	


