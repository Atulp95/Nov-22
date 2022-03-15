package pack;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.AddTo;
import pom.ApplicationHeaderPage;
import pom.Realme;

public class TestClass {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",  "\\C:\\project\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		
		ApplicationHeaderPage applicationHeaderPage = new ApplicationHeaderPage(driver);
		
		applicationHeaderPage.clickOnSearchBar();
		applicationHeaderPage.sendOnSearchBar();
		applicationHeaderPage.clickOnSearchSymbol();
		
		Realme realme = new Realme(driver);
		realme.clickOnSearch();
		
		ArrayList<String> array = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(array.get(1));
		
		AddTo addTo = new AddTo(driver);
		addTo.clickOnAddToCart();
	}

}
