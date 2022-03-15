package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;

	@FindBy (xpath="//input[@id='userid']")
	private WebElement userID;
	
	@FindBy (xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElement login;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void sendUserID(String user) {
		userID.sendKeys(user);
	}
	
	public void sendPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnLogin() {
		login.click();
	}
}
