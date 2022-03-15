package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserList {

	@FindBy (xpath= "//div[@id='ext-gen6']")
	private WebElement user;
	
	@FindBy (xpath="//input[@id='userDataLightBox_firstNameField']")
	private WebElement firstName;
	
	@FindBy (xpath="//input[@id='userDataLightBox_lastNameField']")
	private WebElement lastName;
	
	@FindBy (xpath= "//input[@id='userDataLightBox_emailField']")
	private WebElement email;
	
	@FindBy (xpath="//input[@id='userDataLightBox_usernameField']")
	private WebElement username;
	
	@FindBy (xpath="//input[@id='userDataLightBox_passwordField']")
	private WebElement password;
	
	@FindBy (xpath="//input[@id='userDataLightBox_passwordCopyField']")
	private WebElement retypePassword;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public UserList(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver,10);
		
	}
	
	public void clickUser() {
		wait.until(ExpectedConditions.visibilityOf(user));
		user.click();
	}
	
	public void enterFirstName() {
		wait.until(ExpectedConditions.visibilityOf(firstName));
		firstName.sendKeys("Atul");
	}
	
	public void enterlastName() {
		
		lastName.sendKeys("Pungal");
}
	public void enteremailName() {
		
		email.sendKeys("Atulp95@");
}
	
	public void enterusernameName() {
		username.sendKeys("Atulp");
	}
	
	public void enterpasswordName() {
		password.sendKeys("1234");
}
	public void enterretypePasswordName() {
		retypePassword.sendKeys("1234");
}
	
	
}