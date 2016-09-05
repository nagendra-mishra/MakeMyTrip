package testPages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import classPages.FlightsPage;

public class FlightPageTest {
	FlightsPage fp;
	
  @BeforeClass
  public void beforeClass() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Timmy\\workspace\\chromedriver_win32\\chromedriver.exe");
	  
	  WebDriver driver = new ChromeDriver();
	  
	  
	  fp = new FlightsPage(driver);
	 
	  
	  driver.manage().window().maximize();
	  driver.get("https://www.makemytrip.com/");
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 
	  
	  
  }	
  
  @Test
  public void test() throws Exception {
	  
	 fp.selectFlightsTab();
	 fp.clickInternationalButton();
	 fp.fillInDepartureCity("London");
	 fp.fillInDestinationCity("Paris");
	 fp.setDate("20", "5");
	 fp.setNumPassenger(4, 3, 2);
	 fp.selectClass("Business");
	 fp.clickSearchFlightsButton();
	 fp.verifyFiltersPanel();
	 
	 
	 
	 
	 
	 
	 
	  
  }
 

  @AfterClass
  public void afterClass() {
  }

}
