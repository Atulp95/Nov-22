package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BestSellerProduct {

	@FindBy (xpath="//div[@id='anonCarousel1']//img[1]")
	private WebElement bestSellerProductSelection;
	
	
	
	public BestSellerProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void clickOnBestSelection() {
		bestSellerProductSelection.click();
	}
}
