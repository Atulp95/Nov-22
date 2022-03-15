package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PinPage {

	@FindBy (xpath="//input[@type='password']")
	private WebElement pin;
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElement continu;
	
	public PinPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void sendPin(String pinNum) {
		pin.sendKeys(pinNum);
	}
	
	public void clickOnContinue() {
		continu.click();
	}
}
