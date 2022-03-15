package pom;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LoginPage {

		
		@FindBy (xpath= "//input[@id='username']")
		private WebElement userName;
		
		@FindBy (xpath="//input[@name='pwd']")
		private WebElement password;
		
		@FindBy (xpath="//input[@id='keepLoggedInCheckBox']")
		private WebElement keepLoggedInCheckBox;
		
		@FindBy (xpath="//a[@id='loginButton']")
		private WebElement login;
		
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public void sendUserName(String user) {
			userName.sendKeys(user);
		}
		
		public void sendPasswordName(String pass) {
			password.sendKeys(pass);
		}
		
		public void clickOnKeepMeLogin() {
			if( !(keepLoggedInCheckBox.isSelected()))
			{
				keepLoggedInCheckBox.click();
			}
			else
			{
				System.out.println("keep me logged in already checked");
			}
			
		}
		public void clickOnLogin() {
			login.click();
		}
	}	
//		public void loginToApplication() {
//			userName.sendKeys("admin");
//			password.sendKeys("manager");
//			if( !(keepLoggedInCheckBox.isSelected()))
//			{
//				keepLoggedInCheckBox.click();
//			}
//			else
//			{
//				System.out.println("keep me logged in already checked");
//			}
//			login.click();
	
		
	
		
		
		
		
		
		
		
		

