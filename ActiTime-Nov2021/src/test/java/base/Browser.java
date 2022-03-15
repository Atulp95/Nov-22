package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Browser {

	public static WebDriver launchChromeBrowser() {
		System.setProperty("webdriver.chrome.driver",  "C:\\project\\new chrome\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		return driver;
	}
		public static WebDriver launchFirefoxBrowser() {
			System.setProperty("webdriver.gecko.driver", "C:\\project\\geckodriver.exe");
			WebDriver driver= new FirefoxDriver();
			return driver;
	}
		public static WebDriver launchOperaBrowser() {
			System.setProperty("webdriver.opera.driver", "operadriver.exe");
			WebDriver driver= new OperaDriver();
			return driver;
}
}
