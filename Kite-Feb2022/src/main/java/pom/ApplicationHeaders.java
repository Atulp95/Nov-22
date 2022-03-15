package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationHeaders {

	@FindBy(xpath="//a[@href='/dashboard']")
	private WebElement dashboard;
	
	@FindBy(xpath="//a[@href='/orders']")
	private WebElement order;
	
	@FindBy(xpath="//a[@href='/holdings']")
	private WebElement holdings;
	
	@FindBy(xpath="//a[@href='/positions']")
	private WebElement positions;
	
	@FindBy(xpath="//a[@href='/funds']")
	private WebElement funds;
	
	@FindBy(xpath="//div[contains(@id,'avatar-')]")
	private WebElement profileSym;
	
	@FindBy(xpath="//a[@href='/logout']")
	private WebElement logout;
	
	@FindBy(xpath="//a[text()='Change user']")
	private WebElement changeUser;
	
	
	
	public ApplicationHeaders(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnDashboard() {
		dashboard.click();
	}
	
	public void clickOnOrder() {
		order.click();
	}
	
	public void clickOnHoldings() {
		holdings.click();
	}
	
	public void clickOnPositions() {
		positions.click();
	}
	
	public void clickOnFunds() {
		funds.click();
	}
	
	public void clickOnSymbol() {
		profileSym.click();
	}
	
	public void clickOnLogout() {
		logout.click();
	}
	
	public void clickOnChangeUser() {
		changeUser.click();
	}
}
