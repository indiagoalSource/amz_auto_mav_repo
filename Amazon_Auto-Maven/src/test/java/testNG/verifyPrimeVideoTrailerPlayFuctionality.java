package testNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr;
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

import Pages.PrimeVideoPage;
import Utils.UtilityClass;
import browserSelect.Base;

public class verifyPrimeVideoTrailerPlayFuctionality extends Base{
	
	WebDriver driver ;
	PrimeVideoPage primeVideoPage ;
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
		
		primeVideoPage = new PrimeVideoPage(driver);
		
	}
	
	
	@BeforeMethod
	public void openApplication() throws InterruptedException {
		
		driver.get("https://www.amazon.in/");
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		primeVideoPage.clickOnAllButton();
		primeVideoPage.clickOnAmazonPrimeSection();
		primeVideoPage.clickOnAllVideoSection();
		
	}
	
	@Test (priority =1)
	public void primeVideosectionFuctionality() throws IOException, InterruptedException {
		testID = "T401";
		primeVideoPage.mouseActionTillPrimeVideoPage();
		primeVideoPage.clickOnMoreDetails();
		primeVideoPage.clickOnTrailerButton();
		String actualPageTitle = primeVideoPage.getPageTitleOfPage();
		String expecetedPageTitle = actualPageTitle;
		
		Assert.assertEquals(actualPageTitle, expecetedPageTitle);
		
	}
	
	@Test(priority =2)
	public void verifyCategorySectionInPrimeVideo() throws InterruptedException {
		testID = "T402";
		primeVideoPage.clickOnCategoriesSection();
		primeVideoPage.clickOnRomanceCat();
		primeVideoPage.clickOnUpgrandMovie();
		String actualTitleOfPage = primeVideoPage.getPageTitleOfPage();
		String expectedTitleOfPage = actualTitleOfPage;
		
		Assert.assertEquals(actualTitleOfPage, expectedTitleOfPage);
		
	}
	
	@AfterMethod
	public void closeApplication(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE == result.getStatus())
		{
			UtilityClass.cpatureScreenshot(driver, testID);
		}
		
		// code for close application 
	}
	
	@AfterClass
	public void clearObjects() {
		
		primeVideoPage = null ;
	}
	
	@AfterTest
	public void closeBrowser() {
		
		driver.quit();
		driver = null ;
		System.gc();
	}
	
}
