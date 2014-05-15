import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class instaApp {
	
	FirefoxDriver d1 = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(d1, 100); 
	
	 @BeforeClass
	  public void beforeClass() {
			
			d1.get("http://app.genwi.com/4.0/html5/42042");
	  }
	@AfterClass
	public void AfterClass(){
		//d1.findElementByXPath("//a[contains(text(),'Logout')]").click();
		//d1.quit();
	}
	
@Test
public void TestSections() {
	
	d1.findElementByXPath(".//*[@id='sectionsBtn']/div").click();
	
}

}
