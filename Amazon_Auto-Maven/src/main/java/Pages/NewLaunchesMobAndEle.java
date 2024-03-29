package Pages;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLaunchesMobAndEle {
	
	@FindBy (xpath = "//a[@aria-label='Amazon.in']")
	private WebElement amazonLogoHome ;
	
	@FindBy (xpath = "//a[@aria-label='New Launches from Mobile, Electronics & more']")
	private WebElement newLaunchSection ;
	
	@FindBy (xpath = "//span[contains(text(),'Laptops & Accessories')]")
	private WebElement laptopAndAccessories ;
	
	@FindBy (xpath = "(//span[text()='Laptops'])[1]")
	private WebElement laptops ;
	
	@FindBy (xpath = "//span[text()='Over ₹50,000']")
	private WebElement over50k ;
	
	@FindBy (xpath = "(//div[@id='brandsRefinements']//span//a)[7]")
	private WebElement microsoft ;
	
	@FindBy (xpath = "(//div[@cel_widget_id='MAIN-SEARCH_RESULTS-2']//a)[2]")
	private WebElement product1st ;
	
	@FindBy (xpath = "//a[text()=' Electronics ']")
	private WebElement electronicsSection ;
	
	private WebDriver driver ;
	
	public NewLaunchesMobAndEle(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
	
	public void clickOnAmazonLogoHome() {
		
		amazonLogoHome.click();
	}
	public void clickOnElectronicSection() {
		
		electronicsSection.click();
	}
	
	public void clickOnNewLaunchSection() {
		
		newLaunchSection.click();
	}
	public void clickOnLaptopAndAccessories() {
		
		laptopAndAccessories.click();
	}
	
	public void clickOnLaptops() {
		
		laptops.click();
	}
	public void clickOnOver50k() {
		over50k.click();
	}
	public void clickOnMicrosoft() throws InterruptedException {
		
		JavascriptExecutor js =  (JavascriptExecutor)driver ;
		js.executeScript("arguments[0].scrollIntoView(true);", microsoft);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,-150)");
		Thread.sleep(1000);
		microsoft.click();
		
	}
	public void clickOnProduct1st() {
		
		product1st.click();
		
		ArrayList<String> chieldBrowser = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(chieldBrowser.get(1));
		
	}
	
	public void clickOnProduct1stagain() {
		
		product1st.click();
		
		ArrayList<String> chieldBrowser = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(chieldBrowser.get(2));
		
	}
	
}
