package Pages;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CutomerServicePage {
	
	@FindBy (xpath = "(//a[text()='Customer Service'])[1]")
	private WebElement customerServiceButton ;
	
	@FindBy (xpath = "(//div[@class='a-alert-content']/span)[1]")
	private WebElement impMsg ;
	
	@FindBy (xpath = "//input[@id='helpsearch']")
	private WebElement helpSerachSection ;
	
	@FindBy (xpath = "//a[contains(text(),'Cancel Items and Orders')]")
	private WebElement cancelItemsAndOrder ;
	
	@FindBy (xpath = "//div[@class='help-service-content']//h1")
	private WebElement titleOfCancel ;
	
	@FindBy (xpath = "//a[contains(text(),'Marathi')]")
	private WebElement marathiSelect ;
	
	
	private WebDriver driver ;
	
	public CutomerServicePage (WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
	
	public void clickOnCustomerServiceButton() {
		customerServiceButton.click();
	}
	public String getImpMsg() {
		
		return impMsg.getText();
	}
	public void clickOnHelpSerachSectionAndAskQu(String data) {
		helpSerachSection.click();
		helpSerachSection.sendKeys(data);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	
	public void clickOnCancelItemsAndOrder() {
		
		cancelItemsAndOrder.click();
	}
	public String getMsgTitleOfCancel() {
		
		return titleOfCancel.getText();
	}
	public void clickOnmarathiSelect() {
		
		marathiSelect.click();
		ArrayList<String> chieldWindow = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(chieldWindow.get(1));
				
	}
	
	public String getCurrentUrl() {
		
		return driver.getCurrentUrl();
		
	}
	
}
