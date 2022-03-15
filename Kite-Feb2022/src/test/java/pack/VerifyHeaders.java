package pack;

import java.io.File;
import java.io.IOException;
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
import org.testng.asserts.SoftAssert;
import org.testng.internal.TestResult;

import base.Browser;
import pom.ApplicationHeaders;
import pom.LoginPage;
import pom.PinPage;
import utils.Utility;

public class VerifyHeaders extends Browser {
	private WebDriver driver;
	private LoginPage loginPage;
	private PinPage pinPage;
	private ApplicationHeaders applicationHeaders;
	SoftAssert soft;
	String testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browserName) {
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		if(browserName.equals("Chrome")) {
			driver =launchChromeBrowser();
		}
		if(browserName.equals("Firefox")) {
			driver=launchFirefoxBrowser();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void createObjectsOfPOMClasses() {
		loginPage = new LoginPage(driver);
		pinPage=new PinPage(driver);
		applicationHeaders = new ApplicationHeaders(driver);
		soft= new SoftAssert();
	}
	
	@BeforeMethod

	public void loginKite() throws InterruptedException, IOException {
		driver.get("https://kite.zerodha.com/");
		
	String user = Utility.getDataFromExcel("atul", 4, 0);
	String pass= Utility.getDataFromExcel("atul", 4, 1);
		
		loginPage.sendUserID(user);
		loginPage.sendPassword(pass);
		loginPage.clickOnLogin();
		Thread.sleep(5000);
	String pinNum= Utility.getDataFromExcel("atul", 4, 2);
		pinPage.sendPin(pinNum);
		pinPage.clickOnContinue();
		Thread.sleep(8000);
		
	}
	
	@Test(priority=0)
	public void verifyDashboardPage() {
		testID="501";
		applicationHeaders.clickOnDashboard();
		String url=driver.getCurrentUrl();
		soft.assertEquals(url, "https://kite.zerodha.com/dashboard");
	}
	
	@Test(priority=1)
	public void verifyOrderPage() {
		
		testID="502";
		applicationHeaders.clickOnOrder();
		String url=driver.getCurrentUrl();
		soft.assertEquals(url, "https://kite.zerodha.com/orders");
	}
	
	@Test(priority=2)
	public void verifyHoldingsPage() {
		testID="503";
		applicationHeaders.clickOnHoldings();
		String url=driver.getCurrentUrl();
		soft.assertEquals(url, "https://kite.zerodha.com/holdings");
	}
	
	@Test(priority=3)
	public void verifyPositionsPage() {
		testID="504";
		applicationHeaders.clickOnPositions();
		String url=driver.getCurrentUrl();
		soft.assertEquals(url, "https://kite.zerodha.com/positions");
	}
	
	@Test(priority=4)
	public void verifyFundsPage() {
		testID="505";
		applicationHeaders.clickOnFunds();
		String url=driver.getCurrentUrl();
		soft.assertEquals(url, "https://kite.zerodha.com/funds");
	}
	
	@AfterMethod
	public void logoutKite(ITestResult result) throws InterruptedException, IOException {
		if(ITestResult.FAILURE==result.getStatus())
		{
		Utility.screenshot(driver, testID);
		}
		applicationHeaders.clickOnSymbol();
		applicationHeaders.clickOnLogout();
		Thread.sleep(5000);
		applicationHeaders.clickOnChangeUser();
		soft.assertAll();
	}
	
	@AfterClass
	public void closePOMObjects() {
		loginPage=null;
		pinPage=null;
		applicationHeaders=null;
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
		System.gc();
	}
}
