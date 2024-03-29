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

import Pages.CutomerServicePage;
import Utils.UtilityClass;
import browserSelect.Base;

public class verifyCustomerServiceSection extends Base {
	
	WebDriver driver ;
	CutomerServicePage cutomerServicePage;
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
		
		cutomerServicePage = new CutomerServicePage(driver);
		
	}
	
	
	
	@BeforeMethod
	public void openApplication() {
		
		driver.get("https://www.amazon.in/");
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.manage().window().maximize();
		cutomerServicePage.clickOnCustomerServiceButton();
	}
	
	@Test(priority = 1)
	public void verifyMsgOnCustomerServicePage() {
		testID = "T201";
		String actualImpMsg = cutomerServicePage.getImpMsg();
		String expectedImpMsg = "Important: Rs. 2,000 notes will no longer be accepted for Cash on Delivery (COD) payments or Cashloads.";
		
		Assert.assertEquals(actualImpMsg, expectedImpMsg);
		
	}
	
	@Test(priority = 2)
	public void verifyFindMoreSolutionAndAskQuationfunction() throws EncryptedDocumentException, IOException {
		testID = "T202";
		cutomerServicePage.clickOnHelpSerachSectionAndAskQu(UtilityClass.getExcelData("amazon_input", 1, 0));
		cutomerServicePage.clickOnCancelItemsAndOrder();
		String actualMsgTitleOfCancel = cutomerServicePage.getMsgTitleOfCancel();
		String expectedMsgTitleOfCancel = "Cancel Items and Orders";
		
		Assert.assertEquals(actualMsgTitleOfCancel, expectedMsgTitleOfCancel);
		
	}
	
	@Test (priority = 3)
	public void verifyLaguageSelectionMarathi() {
		testID = "T203";
		cutomerServicePage.clickOnmarathiSelect();
		String actualURL = cutomerServicePage.getCurrentUrl();
		String expectedURL = "https://www.amazon.in/gp/help/customer/display.html?nodeId=200507590&ref_=nav_cs_help&language=mr_IN";
		
		Assert.assertEquals(actualURL, expectedURL);
				
	}
	
	@AfterMethod
	public void closeApplication(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE == result.getStatus())
		{
			UtilityClass.cpatureScreenshot(driver, testID);
		}
		
		//close application code
	}
	
	@AfterClass
	public void clearObjects() {
		
		cutomerServicePage = null ;
		
	}
	
	@AfterTest
	public void closeBrowser() {
		
		driver.quit();
		driver = null;
		System.gc();
	}
	
}
