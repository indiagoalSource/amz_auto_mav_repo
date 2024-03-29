package Pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrimeVideoPage {
	
	@FindBy (xpath = "//a[@id='nav-hamburger-menu']")
	private WebElement allButton ;
	
	@FindBy (xpath = "(//div[text()='Amazon Prime Video'])[1]")
	private WebElement amazonPrimeSection ;
	
	@FindBy (xpath = "(//a[text()='All Videos'])[2]")
	private WebElement allVideoSection ;
	
	@FindBy (xpath = "(//a[text()='All Videos'])[1]")
	private WebElement allVideoSection1 ;
	
	@FindBy (xpath = "(//a[text()='All Videos'])[2]")
	private WebElement allVideoSection2 ;
	
	@FindBy (xpath = "//a[contains(text(),'Home')]")
	private WebElement homeButton ;
	
	@FindBy (xpath = "//a[text()='Movies']")
	private WebElement moviesSection ;
	
	@FindBy (xpath = "(//a[text()='More details'])[1]")
	private WebElement moreDetails ;
	
	@FindBy (xpath = "//a[@aria-label='Watch Trailer']")
	private WebElement trailerButton ;
	
	@FindBy (xpath = "((//div[@id='pv-nav-container']//div)[2]//li//a)[10]")
	private WebElement categoriesSection ;
	
	@FindBy (xpath = "//a[@aria-label='Romance']")
	private WebElement romanceCat ;
	
	@FindBy (xpath = "//a[text()='Upgraded']")
	private WebElement upgrandMovie ;
	
	
	
	private WebDriver driver ;
	
	public PrimeVideoPage (WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
	
	public void clickOnAllButton() throws InterruptedException {
		
		allButton.click();
		Thread.sleep(2000);
	}
	public void clickOnAmazonPrimeSection () throws InterruptedException {
		
		Thread.sleep(2000);
		amazonPrimeSection.click();
	}
	public void clickOnAllVideoSection() throws InterruptedException {
		
		Thread.sleep(3000);
		allVideoSection.click();
	}
	public void mouseActionTillPrimeVideoPage () throws InterruptedException {
		
		Actions action = new Actions(driver);
		//action.moveToElement(amazonPrimeSection).click().perform();
		
		//action.moveToElement(allVideoSection).click().build().perform();
		action.moveToElement(homeButton).moveToElement(moviesSection).click().build().perform();
		
	}
	public void clickOnMoreDetails() {
		
		moreDetails.click();
	}
	public void clickOnTrailerButton() throws IOException, InterruptedException {
		
		trailerButton.click();
		Thread.sleep(5000);
		
		String date = new SimpleDateFormat("dd-MM-yy hh-mm-ss-SS").format(Calendar.getInstance().getTime());
		
		File src1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("test-output/generalScreenshots/Test-Trailer"+date+".png");
		FileHandler.copy(src1, dest);
		
	}
	
	public String getPageTitleOfPage() {
		
		return driver.getTitle();
		
	}
	public void clickOnCategoriesSection() {
		
		//Actions action = new Actions(driver);
		//action.moveToElement(categoriesSection).moveToElement(romanceCat).click().build().perform();
		categoriesSection.click();
	}
	public void clickOnRomanceCat() throws InterruptedException {
		
		Thread.sleep(1000);
		romanceCat.click();
	}
	
	public void clickOnUpgrandMovie() {
		
		upgrandMovie.click();
	}
	
}
