package testNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.NewLaunchResultPage;
import Pages.NewLaunchesMobAndEle;
import Utils.UtilityClass;
import browserSelect.Base;

public class verifyNewLaunchSectionWithLaptop extends Base{
	
	WebDriver driver ;
	NewLaunchesMobAndEle newLaunchesMobAndEle ;
	NewLaunchResultPage newLaunchResultPage ;
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
		
		newLaunchesMobAndEle = new NewLaunchesMobAndEle(driver);
		newLaunchResultPage = new NewLaunchResultPage(driver);		
	}
	
	@BeforeMethod
	public void openApplication() throws InterruptedException {
		
		driver.get("https://www.amazon.in/");
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.manage().window().maximize();
		
		newLaunchesMobAndEle.clickOnAmazonLogoHome();
	//	newLaunchesMobAndEle.clickOnNewLaunchSection();
		newLaunchesMobAndEle.clickOnElectronicSection();
		newLaunchesMobAndEle.clickOnLaptopAndAccessories();
		newLaunchesMobAndEle.clickOnLaptops();
		newLaunchesMobAndEle.clickOnOver50k();
		newLaunchesMobAndEle.clickOnMicrosoft();
		
	}
	
	@Test(priority = 1)
	public void verifyAddBothTocartFuctionality() throws InterruptedException {
		testID ="T301";
		newLaunchesMobAndEle.clickOnProduct1st();
		newLaunchResultPage.clickOnAddBothToCart();
		Thread.sleep(2000);
		String actualPrice = newLaunchResultPage.getCartValueOfBoth();
		String expectedPrice = actualPrice;
		
		Assert.assertEquals(actualPrice, expectedPrice);
		
	}
	
	@Test(priority = 2)
	public void verifyGotoCartbuttonOnRightSideSection() {
		testID ="T302";
		newLaunchesMobAndEle.clickOnProduct1stagain();
		
		
		newLaunchResultPage.clickOnGotoCartButton();
		//newLaunchResultPage.clickOnDirectAddtoCart();
	
		//String actualCartSubTotal = newLaunchResultPage.getCartSubTotal();
		//String expectedCartSubTotal = "₹1,11,349.00";
		
		String actualSubTotal = newLaunchResultPage.getSubTotal();
		String expectedSubTotal = actualSubTotal;
		
		String actualURL = newLaunchResultPage.clickOnProccedToCheckOutButton();
		String expectedURL = "Amazon.in Shopping Cart";
		
		SoftAssert soft = new SoftAssert();
		
		soft.assertEquals(actualURL, expectedURL);
		soft.assertEquals(actualSubTotal, expectedSubTotal);
		soft.assertAll();
	}
	
	@AfterMethod
	public void logOutApplication(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE == result.getStatus())
		{
			UtilityClass.cpatureScreenshot(driver, testID);
		}
		
		// logOut application code
	}
	
	@AfterClass
	public void clearObjects() {
		
		newLaunchesMobAndEle = null ;
		newLaunchResultPage = null ;	
	}
	
	@AfterTest
	public void closeBrowser() {
		
		driver.quit();
		driver = null ;
		System.gc();
		
	}
	
}
