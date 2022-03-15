package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTo {


	@FindBy (xpath="//input[@id='add-to-cart-button']")
	private WebElement addToCart;
	
	@FindBy (xpath="//input[@id='buy-now-button']")
	private WebElement buyNow;
	
	@FindBy (xpath="//a[@id='attach-close_sideSheet-link']")
	private WebElement closeAddToCart;
	
	@FindBy (xpath="//a[@id='nav-link-accountList']")
	private WebElement accountNlist;
	
	@FindBy (xpath="//a[@id='nav-item-signout']")
	private WebElement signOut;
	
	private WebDriver driver;
	

	public AddTo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
	
	public void clickOnAddToCart() {	
		addToCart.click();	
	}
	
public void clickOnBuyNow() {	
	buyNow.click();		
	}
	
public void closeAddToCart() {	
		closeAddToCart.click();	
	}

	public void moveOnSearchBar() {
		Actions actions= new Actions(driver);
		actions.moveToElement(accountNlist).build().perform();	
	}
	
	public void clickOnSignout() {
		signOut.click();
	}
}

