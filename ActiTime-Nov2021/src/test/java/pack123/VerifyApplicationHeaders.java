package pack123;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

import base.Browser;
import pom.ApplicationHeaderPage;
import pom.LoginPage;
import utils.Utility;

public class VerifyApplicationHeaders extends Browser{
	private WebDriver driver;
	private LoginPage loginpage;
	private ApplicationHeaderPage applicationHeaderPage;
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
		System.out.println("launchBrowser");
		if(browserName.equals("Chrome"))
		{
			driver = launchChromeBrowser();
		}
		if(browserName.equals("Firefox"))
		{
			driver = launchFirefoxBrowser();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("http://localhost/login.do");
}
	
	@BeforeClass
	public void createObjectOfPOMClasses() {
		loginpage = new LoginPage(driver);
		 applicationHeaderPage = new ApplicationHeaderPage(driver);
		 soft = new SoftAssert();
}
	
	@BeforeMethod
	public void loginIntoApplication() throws IOException {
		System.out.println("loginToApplication");
		driver.get("http://localhost/login.do");
		
		String user=Utility.getDataFromExcel("atul", 1, 0);
		String pass=Utility.getDataFromExcel("atul", 1, 1);
		loginpage.sendUserName(user);
		loginpage.sendPasswordName(pass);
		loginpage.clickOnKeepMeLogin();
		loginpage.clickOnLogin();
	}
	
	@Test
	public void verifyTaskPage() {
testID="101";
		applicationHeaderPage.OpenTasksPage();
		String url =driver.getCurrentUrl();
		
//		Assert.assertEquals(url, "http://localhost/tasks/otasklist.do");
		
		soft.assertEquals(url, "http://localhost/tasks/otasklist.do");
		soft.assertAll();
	}
	
	@Test
	public void verifyReportsPage() {

		testID="102";
		applicationHeaderPage.OpenReportsPage();
		String url =driver.getCurrentUrl();
		
		soft.assertEquals(url, "http://localhost/reports/reports.do");
	}
	
	@Test
	public void verifyUserPage() {

		testID="103";
		applicationHeaderPage.OpenUserPage();;
		String url =driver.getCurrentUrl();
		
		soft.assertEquals(url, "http://localhost/administration/userlist.do");
		
	}
	
	@AfterMethod
	public void logoutApplication(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus())
		{
		Utility.screenshot(driver,testID);
		}
		applicationHeaderPage.OpenLogoutPage();
	}
	
	@AfterClass
	public void closePOMObjects() {
		loginpage=null;
		applicationHeaderPage=null;
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
		driver=null;
		System.gc();
	}
	
	
}
