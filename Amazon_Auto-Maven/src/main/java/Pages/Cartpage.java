package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cartpage {
	
	@FindBy (xpath = "(//span[@id='sc-subtotal-amount-activecart']//span)[1]")
	private WebElement cartValue ;
	
	@FindBy (xpath = "//input[@name='proceedToRetailCheckout']")
	private WebElement proccedToBuy ;
	
	public Cartpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void getCartValue() {
		
		cartValue.getText();
	}
	
	public void clickOnProcced() {
		
		proccedToBuy.click();
	}

}
