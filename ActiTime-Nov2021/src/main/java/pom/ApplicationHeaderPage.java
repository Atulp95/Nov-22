package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationHeaderPage {

	@FindBy (xpath= "//a[@class='content tt_selected selected']")
	private WebElement timeTrack;
	
	@FindBy (xpath="//a[@class='content tasks']")
	private WebElement tasks;
	
	@FindBy (xpath="//td[@class='navItem relative'][3]")
	private WebElement reports;
	
	@FindBy (xpath="//a[@class='content users']")
	private WebElement users;
	
	@FindBy (xpath="//a[@class='content calendar']")
	private WebElement workSchedule;
	
	@FindBy (xpath="//a[@class='userProfileLink username']")
	private WebElement administration;
	
	@FindBy (xpath="//a[@id='logoutLink']")
	private WebElement logOut;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public ApplicationHeaderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver,10);
		
	}
	
	public void OpenReportsPage() {
		reports.click();
	}
	
	public void OpenTasksPage() {
		wait.until(ExpectedConditions.visibilityOf(tasks));
		tasks.click();
	}
	
	public void OpenWorkSchedulePage() {
		workSchedule.click();
	}
	
	public void OpenAdministrationPage() {
		administration.click();
	}
	
	public void OpenUserPage() {
		users.click();
	}
	

	public void OpenLogoutPage() {
		logOut.click();
	}
	
}


