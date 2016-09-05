package classPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FlightsPage {

	WebDriver driver;
	
	public FlightsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[text()='Flights']" )
	WebElement flightsTab;
	
	@FindBy(xpath = "/.//*[@id='widget_row']/div[1]/div/div[3]/div/div[2]/div[2]/a" )
	WebElement internationalButton;
	
	@FindBy(xpath = ".//*[@id='widget_row']/div[1]/div/div[3]/div/div[2]/div[1]/a" )
	WebElement domesticTab;
	
	@FindBy(id = "from_typeahead1" )
	WebElement departureCity;
	
	@FindBy(id = "to_typeahead1" )
	WebElement destinationCity;
	
	@FindBy(id = "start_date_sec")
	WebElement departureDate;
	
	@FindBy(id = "return_date_sec")
	WebElement returnDate;
	
	@FindBy(xpath = ".//*[@id='adult_count']/a[2]")
	WebElement adultPassenger;
	
	@FindBy(xpath = ".//*[@id='child_count']/a[2]")
	WebElement childPassenger;
	
	@FindBy(xpath = ".//*[@id='infant_count']/a[2]")
	WebElement infantPassenger;
	
	@FindBy(id = "class_selector")
	WebElement classSelector;
	
	@FindBy(id = "flights_submit")
	WebElement searchFlightsButton;
	
	
	public void selectFlightsTab(){
		WebElement element = null;
		try {
			element = driver.findElement(By.xpath("html/body/div[12]/div/a[1]"));
			if (element != null) {
				element.click();
			}
			
		} catch (Exception e) {
			
			System.out.println("ELEMENT IS NOT PRESENT!!!!!!!!!!!!");
			flightsTab.click();
		}
		
	}
	
	
	public void clickInternationalButton(){
		internationalButton.click();
		WebElement element = null;
		try {
			element = driver.findElement(By.xpath("html/body/div[12]/div/a[1]"));
			if (element != null) {
				element.click();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ELEMENT IS NOT PRESENT!!!!!!!!!!!!");
		}
	}
	
	
	public void fillInDepartureCity(String depCity){
		departureCity.sendKeys(depCity);
	}
	
	
	public void fillInDestinationCity(String desCity){
		destinationCity.sendKeys(desCity);
		
	}
	
	public void setDate(String depDate, String retdate )throws Exception{
		
				departureDate.click();
				
				WebElement depCalendar = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]"));
				List<WebElement> depDays = depCalendar.findElements(By.tagName("a"));
				
				for (WebElement day : depDays) {
					
					if (day.getText().equals(depDate)) {
						day.click();
						break;
					}
				}
				
				returnDate.click();
				WebElement retCalendar = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[3]"));
				List<WebElement> retDays = retCalendar.findElements(By.tagName("a"));
				
				for (WebElement day : retDays) {
					if (day.getText().equals(retdate)) {
						day.click();
						break;
					}
				}
				
	}
	
	public void setNumPassenger(int adult, int children, int infant){
		for (int i = 0; i < (adult-1) ; i++) {
			adultPassenger.click();
			
		}
		
		for (int i = 0; i < children; i++) {
			childPassenger.click();
		}
		
		for (int i = 0; i < infant; i++) {
			infantPassenger.click();
		}
		
	}
	
	public void selectClass(String _class){
		Select sel = new Select(classSelector);
//		sel.selectByValue(_class);
		sel.selectByVisibleText(_class);
	}
	
	
	
	public void clickSearchFlightsButton(){
		searchFlightsButton.click();
		
	}
	
	public void verifyFiltersPanel(){
		try {
			WebElement element = driver.findElement(By.id("filters_panel"));
			Assert.assertTrue(element!=null);
			System.out.println("Successful!");
		} catch (Exception e) {
			System.out.println("Failed!");
		}
		
		
	}
	
	
	
	
}
