package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportsPage {

	@FindBy (xpath= "//div[@id='ext-gen20']")
	private WebElement createReport;
	
	@FindBy (xpath="//input[@id='configureReportParametersButton']")
	private WebElement configureReportParameter;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public ReportsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver,10);
		
	}
	
	public void clickCreateReport() {
		wait.until(ExpectedConditions.visibilityOf(createReport));
		createReport.click();
	}
	
	public void clickConfigureParameter() {
		wait.until(ExpectedConditions.visibilityOf(configureReportParameter));
		configureReportParameter.click();
	}
}
