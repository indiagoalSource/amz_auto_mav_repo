package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectedProductPage {
	
	@FindBy (xpath = "(//input[@id='add-to-cart-button'])[2]")
	private WebElement addtoCart ;
	
	@FindBy (xpath = "//span[@id='attach-sidesheet-view-cart-button']")
	private WebElement cart ;
	
	@FindBy (xpath = "//span[@id='sc-subtotal-amount-buybox']")
	private WebElement costOfCart ;
	
	@FindBy (xpath = "//input[@id='buy-now-button']")
	private WebElement buyNowButton ;
	
	@FindBy (xpath = "//input[@id='continue']")
	private WebElement continueButton ;
	
	@FindBy (xpath = "//input[@id='signInSubmit']")
	private WebElement signInButton ;
	
	@FindBy (xpath = "//h1[contains(text(),'Sign in')]")
	private WebElement signInTitle ;
	
	private WebDriver driver ;
	
	public SelectedProductPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
	
	public void clickOnAddToCart() {
		
		addtoCart.click();
	}
	
	public void clickOnCart() {
		
		cart.click();
	}
	
	public String getCostOfCart() {
		
		return costOfCart.getText();
		
	}
	
	public void clickOnBuyNowButton() {
		
		buyNowButton.click();
		
	}
	public void clickOnContinueButton() {
		
		continueButton.click();
	}
	public void clickOnSignInButton() {
		
		signInButton.click();
	}
	public String getSignInTitle() {
		
		return signInTitle.getText();
	}
	
	public String getCurrentPageTitle() {
		
		return driver.getTitle();
	}
	
}
