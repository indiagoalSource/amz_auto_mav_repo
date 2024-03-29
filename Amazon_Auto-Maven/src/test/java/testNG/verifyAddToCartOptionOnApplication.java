package testNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.HomePage;
import Pages.ResultPage;
import Pages.SelectedProductPage;
import Utils.UtilityClass;
import browserSelect.Base;

public class verifyAddToCartOptionOnApplication extends Base{
	
	WebDriver driver ;
	SelectedProductPage selectedProductPage ;
	HomePage homePage ;
	ResultPage resultPage ;
	String testID ;
	static ExtentTest test ;
	static ExtentHtmlReporter reporter ;
	
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName) {
		
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		if(browserName.equals("Chrome"))
		{
			driver = openChromeBrowser();
		}
		
		if(browserName.equals("Firefox"))
		{
			driver = openFirefoxBrowser();		
		}
		
		if(browserName.equals("Edge"))
		{
			driver = openEdgeBrowser();	
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	@BeforeClass
	public void createPOMObjects() {
		
		homePage = new HomePage(driver);
		resultPage = new ResultPage(driver);
		selectedProductPage = new SelectedProductPage(driver);
		
	}
	
	
	@BeforeMethod
	public void openApplication() throws InterruptedException, EncryptedDocumentException, IOException {
		
		driver.get("https://www.amazon.in/");
		driver.navigate().refresh();
		driver.navigate().refresh();
		homePage.SearchInAmazon(UtilityClass.getExcelData("amazon_input", 1, 1));
		homePage.SearchProduct();
		
	}
	
	@Test(priority = 1)
	public void addToCartFuctionality() throws InterruptedException {
		testID = "T110";
		resultPage.clickOnSortby();
		resultPage.clickOnPriceHightoLow();
		resultPage.clickOn2ndProduct();
		
		selectedProductPage.clickOnAddToCart();
		selectedProductPage.clickOnCart();
		
		String actualPrice = selectedProductPage.getCostOfCart();
		System.out.println(actualPrice);
		
		String expectedPrice = actualPrice ;
		
		Assert.assertEquals(actualPrice, expectedPrice);
		
	}
	
	@Test(priority = 2)
	public void buyNowFunctionality() throws InterruptedException {
		testID = "T111";
		resultPage = new ResultPage(driver);
		resultPage.clickOnSortby();
		resultPage.clickOnPriceHightoLow();
		resultPage.clickOn2ndProduct2();
		
		selectedProductPage = new SelectedProductPage(driver);
		selectedProductPage.clickOnBuyNowButton();
		String actualSignInTitle = selectedProductPage.getSignInTitle();
		String expectedSignInTitle = "Sign in";
		String actualURL = selectedProductPage.getCurrentPageTitle();
		String expectedURL = "Amazon Sign In";
				
		Assert.assertEquals( actualSignInTitle, expectedSignInTitle);
		Assert.assertEquals(actualURL, expectedURL);
		
	}
	
	@AfterMethod
	public void logOutApplication(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE == result.getStatus())
		{
			UtilityClass.cpatureScreenshot(driver, testID);
		}
		
		//logOut Code of Application
	}
	
	@AfterClass
	public void clearObjects() {
		
		homePage = null ;
		resultPage = null ;
		selectedProductPage = null ;
	}
	
	@AfterTest
	public void closeBrowser() {
		
		driver.quit();
		driver = null ;
		System.gc();
		
	}
	
}
