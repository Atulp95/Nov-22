package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationHeaderPage {

	
	
//	@FindBy (xpath= "//a[@id='nav-logo-sprites']")
//	private WebElement amazonLogo;
//	
//	@FindBy (xpath="//div[@id='glow-ingress-block']")
//	private WebElement address;
//	
//	@FindBy (xpath="//div[@class='nav-search-scope nav-sprite']")
//	private WebElement searchIn;
	
//	@FindBy (xpath="select[@aria-describedby='searchDropdownDescription']")
//	private WebElement allDropbox;
	
	@FindBy (xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchBar;
	
	@FindBy (xpath="//input[@id='nav-search-submit-button']")
	private WebElement searchSym;
	
//	@FindBy (xpath="//a[@id='nav-link-accountList']")
//	private WebElement accountsNlists;
	
//	@FindBy (xpath="(//a[@class='nav-a nav-a-2   nav-progressive-attribute'])[2]")
//	private WebElement ReturnNorder;
//	
//	@FindBy (xpath="//div[@id='nav-cart-count-container']")
//	private WebElement cart;
//	
//	@FindBy (xpath= "//a[@id='nav-hamburger-menu']")
//	private WebElement all;
//	
	@FindBy (xpath="//div[@id='nav-xshop']//a[3]")
	private WebElement bestSellers;
	
	@FindBy (xpath="//div[@id='nav-xshop']//a[2]")
	private WebElement mobiles;
//	
//	@FindBy (xpath="//div[@id='nav-xshop']//a[3]")
//	private WebElement todaysDeals;
//	
//	@FindBy (xpath="//div[@id='nav-xshop']//a[4]")
//	private WebElement customerService;
//	
//	@FindBy (xpath="//div[@id='nav-xshop']//a[5]")
//	private WebElement electronics;
//	
//	@FindBy (xpath="//div[@id='nav-xshop']//a[6]")
//	private WebElement prime;
//	
//	@FindBy (xpath= "//div[@id='nav-xshop']//a[7]")
//	private WebElement books;
//	
//	@FindBy (xpath="//div[@id='nav-xshop']//a[8]")
//	private WebElement fashion;
//	
//	@FindBy (xpath="//div[@id='nav-xshop']//a[9]")
//	private WebElement newReleses;
//	
//	@FindBy (xpath="//div[@id='nav-xshop']//a[10]")
//	private WebElement homeNkicthens;
//	
//	@FindBy (xpath="//div[@id='nav-xshop']//a[11]")
//	private WebElement amazonPay;
//	
//	@FindBy (xpath="//div[@id='nav-xshop']//a[12]")
//	private WebElement computers;
//	
//	@FindBy (xpath="//div[@id='nav-xshop']//a[13]")
//	private WebElement coupans;
//	
//	@FindBy (xpath="//div[@id='nav-xshop']//a[14]")
//	private WebElement toysNgames;
//	
//	@FindBy (xpath="//div[@id='nav-xshop']//a[15]")
//	private WebElement sells;
//	
//	@FindBy (xpath="//div[@id='nav-xshop']//a[16]")
//	private WebElement giftcards;
//	
//	@FindBy (xpath="//div[@id='nav-xshop']//a[17]")
//	private WebElement carNmotorbikes;
//	
//	@FindBy (xpath="//div[@id='nav-xshop']//a[18]")
//	private WebElement beautyNcare;

	
	public ApplicationHeaderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSearchBar() {
		searchBar.click();
		
	}
	
	public void sendOnSearchBar() {
		searchBar.sendKeys("Realme 3 pro");
	}
	
	public void clickOnSearchSymbol() {
		searchSym.click();
	}
	
	public void clickOnMobilesHeader() {
		mobiles.click();
	}
	
	public void clickOnBestSellersHeader() {
		bestSellers.click();
	}
}
