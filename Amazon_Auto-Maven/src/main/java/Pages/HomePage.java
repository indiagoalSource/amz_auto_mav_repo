package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy (xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchAmazon ;
	
	@FindBy (xpath = "//input[@id='nav-search-submit-button']")
	private WebElement hitSerach ;
	
	
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void SearchInAmazon(String data) {
		
		searchAmazon.click();
		searchAmazon.sendKeys(data);
		
	}
	
	public void SearchProduct() {
		
		hitSerach.click();
	}

}
