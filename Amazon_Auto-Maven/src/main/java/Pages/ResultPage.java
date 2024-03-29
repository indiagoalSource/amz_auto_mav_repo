package Pages;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {
	
	@FindBy (xpath = "//span[text()='Featured']")
	private WebElement sortby ;
	
	@FindBy (xpath = "//a[text()='Price: High to Low']")
	private WebElement priceHightoLow ;
	
	@FindBy (xpath = "(//div[@data-cy='title-recipe'])[2]//a")
	private WebElement product2nd ;
	
	@FindBy (xpath = "//input[@id='buy-now-button']")
	private WebElement buyNownbutton ;
	
	WebDriver driver ;
	
	public ResultPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
	
	public void clickOnSortby() {
		
		sortby.click();
	}
	
	public void clickOnPriceHightoLow() {
		
		priceHightoLow.click();
	}
	
	public void clickOn2ndProduct() throws InterruptedException {
		
		product2nd.click();
		Thread.sleep(3000);
		
		ArrayList<String> chieldBrowser = new ArrayList<String> ( driver.getWindowHandles() );
		driver.switchTo().window(chieldBrowser.get(1));
		
	}
	
	public void clickOn2ndProduct2() throws InterruptedException {
	
		product2nd.click();
		Thread.sleep(3000);
		
		ArrayList<String> chieldBrowser = new ArrayList<String> ( driver.getWindowHandles() );
		driver.switchTo().window(chieldBrowser.get(2));
		
	}
	public void clickOnBuyNownbutton() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		js.executeScript("arguments[0].scrollIntoView(true)", buyNownbutton);
		Thread.sleep(2000);
		js.executeScript("window.ScrollBy(0,-200)");
		buyNownbutton.click();
		
	}

}
