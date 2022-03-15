package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	@FindBy (xpath="//input[@id='ap_email']")
	private WebElement emailOrPhone;
	
	@FindBy (xpath="//input[@id='continue']")
	private WebElement continueButton;
	
	
	
	
	public SignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	public void clickAndEnterPhoneNo(String email) {
		emailOrPhone.click();
		emailOrPhone.sendKeys(email);
	}
	
	public void clickOnSignin() {
		continueButton.click();
	}
}
