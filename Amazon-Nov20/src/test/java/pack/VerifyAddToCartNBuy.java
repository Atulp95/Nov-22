package pack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
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

import base.Browser;
import pom.AddTo;
import pom.ApplicationHeaderPage;
import pom.HomePage;
import pom.Realme;
import pom.SignInPage;
import pom.SignPasswordPage;
import utils.Utility;

public class VerifyAddToCartNBuy extends Browser {
	private WebDriver driver;
	private HomePage homePage;
	private SignInPage signInPage; 
	private SignPasswordPage signPasswordPage;
	private ApplicationHeaderPage applicationHeaderPage;
//	SoftAssert soft;
	String testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browserName) {
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		if(browserName.equals("Chrome"))
		{
		driver = launchChromeBrowser();
		}
		if(browserName.equals("Firefox"))
		{
		driver = launchFirefoxBrowser();
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	}
	
	@BeforeClass
	public void createObjectsOfPOMClasses() {
		homePage = new HomePage(driver);
		signInPage = new SignInPage(driver);
		signPasswordPage = new SignPasswordPage(driver);
		applicationHeaderPage = new ApplicationHeaderPage(driver);
//		soft= new SoftAssert();
	}
	
	@BeforeMethod
	public void loginApplication() throws IOException {
		driver.get("https://www.amazon.in/");
		
		 homePage = new HomePage(driver);
		homePage.moveOnSearchBar();
		homePage.clickOnSignin();
		
		String email=Utility.getDataFromExcel("atul", 2, 0);
		String pass=Utility.getDataFromExcel("atul", 2, 1);
		signInPage.clickAndEnterPhoneNo(email);
		signInPage.clickOnSignin();
		
		
		signPasswordPage.clickAndEnterPhoneNo(pass);
		signPasswordPage.clickOnSignin();
		
		
		applicationHeaderPage.clickOnSearchBar();
		applicationHeaderPage.sendOnSearchBar();
		applicationHeaderPage.clickOnSearchSymbol();
//		String url =driver.getCurrentUrl();
		
		Realme realme = new Realme(driver);
		realme.clickOnSearch();
		
	}
	
	@Test(priority=0)
	public void verifyAddToCart() {
		testID="001";
//ApplicationHeaderPage applicationHeaderPage = new ApplicationHeaderPage(driver);
//		applicationHeaderPage.clickOnSearchBar();
//		applicationHeaderPage.sendOnSearchBar();
//		applicationHeaderPage.clickOnSearchSymbol();
//		
//		Realme realme = new Realme(driver);
//		realme.clickOnSearch();
		
		ArrayList<String> array = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(array.get(1));
		AddTo addTo = new AddTo(driver);
		addTo.clickOnAddToCart();
//		String url=driver.getCurrentUrl();
//		SoftAssert s=new SoftAssert();
//		s.assertEquals(url, "https://www.amazon.in/Realme-Nitro-Blue-64GB-Storage/dp/B07QZZRD4N/ref=sr_1_1?crid=1Z00BQTH7N5U0&keywords=Realme+3+pro&qid=1645715214&sprefix=%2Caps%2C427&sr=8-1");
		//Assert.assertEquals(url, "https://www.amazon.in/Realme-Nitro-Blue-64GB-Storage/dp/B07QZZRD4N/ref=sr_1_1?crid=1Z00BQTH7N5U0&keywords=Realme+3+pro&qid=1645715214&sprefix=%2Caps%2C427&sr=8-1");
		addTo.closeAddToCart();
		addTo.moveOnSearchBar();
		
	}
	
	@Test(priority=1)
	public void verifyBuynow() {
		testID="002";
		ArrayList<String> array = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(array.get(2));
		AddTo addTo = new AddTo(driver);
		addTo.clickOnBuyNow();
//		String url=driver.getCurrentUrl();
//		Assert.assertEquals(url, "https://www.amazon.in/gp/buy/payselect/handlers/display.html?hasWorkingJavascript=1");
		driver.close();
		driver.switchTo().window(array.get(1));
	}
	
	@AfterMethod
	public void signOut(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus())
		{
		Utility.screenshot(driver, testID);
		}
		AddTo addTo = new AddTo(driver);
		addTo.moveOnSearchBar();
		addTo.clickOnSignout();
		
	}
	
	@AfterClass
	public void closePOMObjects() {
		homePage=null;
		signInPage=null;
		signPasswordPage=null;
		applicationHeaderPage=null;
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
		driver=null;
		System.gc();
	}
}
