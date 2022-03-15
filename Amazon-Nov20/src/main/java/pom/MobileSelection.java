package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileSelection {

	@FindBy (xpath="(//div[@class='a-section a-spacing-base'])[1]")
	private WebElement mobileSelect;
	
	
	
	public MobileSelection(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void clickOnMobile() {
		mobileSelect.click();
	}
}
