package pack123;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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
import pom.OpenTasks;
import pom.ReportsPage;
import utils.Utility;


public class VerifyCreateTaskNReportFunctionality extends Browser {

	private WebDriver driver;
	private ApplicationHeaderPage applicationHeaderPage; 
	private LoginPage loginpage;
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

	driver =launchChromeBrowser();
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
		 
}
	
	@BeforeMethod
	public void loginIntoApplication() throws IOException {
		driver.get("http://localhost/login.do");
 loginpage = new LoginPage(driver);
		
 String user=Utility.getDataFromExcel("atul", 1, 0);
	String pass=Utility.getDataFromExcel("atul", 1, 1);
	loginpage.sendUserName(user);
	loginpage.sendPasswordName(pass);
		loginpage.clickOnKeepMeLogin();
		loginpage.clickOnLogin();
	}
	
	@Test (priority=0)
	public void verifyCreateTask() {
		testID="201";
applicationHeaderPage = new ApplicationHeaderPage(driver);
		
		applicationHeaderPage.OpenTasksPage();
		
		OpenTasks openTasks = new OpenTasks(driver);
		
		openTasks.clickOnCreateTasks();
		openTasks.clickOnCustomerType();
		openTasks.actionOnselectCustomer();
		openTasks.clickNsendCustomerName();
		openTasks.clickNenterProjectName();
		openTasks.clickNenterTaskname();
//		openTasks.clickTypeOfWork();
		//openTasks.selectTypeOfWork();
		//openTasks.tickCheckbox();
//		openTasks.createTask();
		openTasks.clickOnCancel();
		Alert alert =driver.switchTo().alert();
		alert.accept();
	}
	
	@Test (priority=1)
	public void verifyReports() {
		testID="202";
		applicationHeaderPage = new ApplicationHeaderPage(driver);
		applicationHeaderPage.OpenReportsPage();
		
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.clickCreateReport();
		reportsPage.clickConfigureParameter();
	}
	
	
	@AfterMethod
	public void logoutApplication(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus())
		{
		Utility.screenshot(driver,testID);
		}
applicationHeaderPage = new ApplicationHeaderPage(driver);
		
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
