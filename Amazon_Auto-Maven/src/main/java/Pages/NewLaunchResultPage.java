package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLaunchResultPage {
		
	@FindBy (xpath = "(//input[@name='submit.addToCart'])[1]")
	private WebElement addBothToCart ;
	
	@FindBy (xpath = "(//span[@class='a-price sw-subtotal-amount']//span)[4]")
	private WebElement cartValueOfBoth ;
	
	@FindBy (xpath = "//a[contains(text(),'Go to Cart')]")
	private WebElement goToCartbutton ;
	
	@FindBy (xpath = "(//div[@data-name='Subtotals']/span[2])[1]")
	private WebElement subTotal ;
	
	@FindBy (xpath = "(//input[@id='add-to-cart-button'])[2]")
	private WebElement directAddtoCart ;
	
	@FindBy (xpath = "//span[@id='attach-accessory-cart-subtotal']")
	private WebElement cartSubTotal ;
	
	@FindBy (xpath = "//input[@name='proceedToRetailCheckout']")
	private WebElement proccedToCheckOutButton ;
	
	
	private WebDriver driver ;
	
	public NewLaunchResultPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
	
	public void clickOnAddBothToCart() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		js.executeScript("arguments[0].scrollIntoView(true);", addBothToCart);
		js.executeScript("window.scrollBy(0,-200)");
		Thread.sleep(2000);
		addBothToCart.click();
	}
	
	public String getCartValueOfBoth() {
		
		return cartValueOfBoth.getText();
	}
	
	public void clickOnGotoCartButton() {
		
		goToCartbutton.click();
	}
	public String getSubTotal() {
		
		return subTotal.getText();
	}
	public void clickOnDirectAddtoCart() {
		
		directAddtoCart.click();
	}
	public String getCartSubTotal() {
		
		return cartSubTotal.getText();
	}
	public String clickOnProccedToCheckOutButton() {
		
		proccedToCheckOutButton.click();
		return driver.getTitle();
		
	}
	
}
