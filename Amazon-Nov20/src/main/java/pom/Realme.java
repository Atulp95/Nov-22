package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Realme {

	
	@FindBy (xpath="(//div[@class='aok-relative'])[1]")
	private WebElement searchClick;
	
	
	

	public Realme(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	
	}
	
	public void clickOnSearch() {

		
		searchClick.click();
	}
}
