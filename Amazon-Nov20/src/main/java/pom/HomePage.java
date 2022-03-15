package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy (xpath="//a[@id='nav-link-accountList']")
	private WebElement accountNlist;
	
	@FindBy (xpath="(//span[text()='Sign in'])[1]")
	private WebElement signIn;
	
	private WebDriver driver;
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	
	public void moveOnSearchBar() {
		Actions actions= new Actions(driver);
		actions.moveToElement(accountNlist).build().perform();	
	}
	
	public void clickOnSignin() {
		signIn.click();
	}
}
