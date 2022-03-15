package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenTasks {

	@FindBy (xpath = "//div[@id='ext-gen32']")
	private WebElement createTasks;
	
	@FindBy (xpath = "//button[contains(@id,'ext-gen')][1]")
	private WebElement selectCustomer;
	
	@FindBy (xpath = "(//a[contains(@id,'ext-gen')])[3]")
	private WebElement newCustomer;
	
	@FindBy (xpath = "//input[@id='createTasksPopup_newCustomer']")
	private WebElement enterCustomerName;
	
	@FindBy (xpath = "//input[@id='createTasksPopup_newProject']")
	private WebElement projectName;
	
	@FindBy (xpath = "//input[@placeholder='Enter task name'][1]")
	private WebElement enterTaskName;
	
	@FindBy (xpath = "(//td[@class='billingTypeCell'])[1]")
	private WebElement workType;
	
	@FindBy (xpath = "(//a[contains(@id,'ext-gen')])[3]")
	private WebElement selectWorktype;
	
	@FindBy (xpath = "(//td[@class='addToTTCell'])[1]")
	private WebElement checkBox;
	
	@FindBy (xpath = "//div[@class='buttonIcon']")
	private WebElement create;
	
	@FindBy (xpath = "//img[@id='closeCreateTasksPopupButton']")
	private WebElement cancelTask;
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;
	
	
	public OpenTasks(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver,10);
		actions = new Actions(driver);
	}
	
	public void clickOnCreateTasks() {
		wait.until(ExpectedConditions.visibilityOf(createTasks));
		createTasks.click();
	}
	
	public void clickOnCustomerType() {
		wait.until(ExpectedConditions.visibilityOf(selectCustomer));
		selectCustomer.click();
	}
	
	public void actionOnselectCustomer() {
		actions.moveToElement(newCustomer).click().build().perform();
		//newCustomer.click();
	}
	
	public void clickNsendCustomerName() {
		enterCustomerName.click();
		enterCustomerName.sendKeys("vaibhav");
	}
	
	public void clickNenterProjectName() {
		projectName.click();
		projectName.sendKeys("fb");
	}
	
	public void clickNenterTaskname() {
		enterTaskName.click();
		enterTaskName.sendKeys("close task");
	}
	
	public void clickTypeOfWork() {
		workType.click();
	}
	
	public void selectTypeOfWork() {
		wait.until(ExpectedConditions.visibilityOf(selectWorktype));
		actions.moveToElement(selectWorktype).click().build().perform();
		//selectWorktype.click();
	}
	
	public void tickCheckbox() {
		checkBox.click();
	}
	
	public void createTask() {
		create.click();
	}
	
	public void clickOnCancel() {
		cancelTask.click();
	}
	
	
}
