package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobilePhones {

	@FindBy (xpath="//li[@id='sobe_d_b_1_1']")
	private WebElement MobileBrandSelection;
	
	
	
	public MobilePhones(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void clickOnMobileBrand() {
		MobileBrandSelection.click();
	}
}
