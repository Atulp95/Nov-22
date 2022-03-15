package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeTrackPage {

	@FindBy (xpath= "//input[@id='taskSearchControl_field']")
	private WebElement searchUser;
	

	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public TimeTrackPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver,10);
		
	}
	
	public void clickOnSearch() {
		wait.until(ExpectedConditions.visibilityOf(searchUser));
		searchUser.click();
		searchUser.sendKeys("Atul");
	}
}
