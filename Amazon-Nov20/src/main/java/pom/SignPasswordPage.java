package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignPasswordPage {
	@FindBy (xpath="//input[@id='ap_password']")
	private WebElement password;
	
	@FindBy (xpath="//input[@id='signInSubmit']")
	private WebElement continuePassButton;
	
	
	
	
	public SignPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void clickAndEnterPhoneNo(String pass) {
		password.click();
		password.sendKeys(pass);
	}
	
	public void clickOnSignin() {
		continuePassButton.click();
	}
}
