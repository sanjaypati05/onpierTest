package onpierTestHelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class TestBase {
	
	
	public static WebDriver driver=null;
	ConfigRead config=new ConfigRead();
	
	
	/**
	 * Start the browser instance as per the required browser name mentioned in the properties file
	 */
	@BeforeClass
	public void startBrowser() {
		
		String broswer=ConfigRead.browserName;
		
		System.out.println("Before Class is running ");
		
		
		switch (broswer)
		{
		case "firefox":
			
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			driver = new FirefoxDriver(firefoxOptions);
			driver.manage().window().fullscreen();
			break;
		
		case "chrome":
			
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("disable-infobars");
			chromeOptions.addArguments("start-fullscreen");
			
			try
			{
				driver = new ChromeDriver(chromeOptions);
			}
			catch (WebDriverException e)
			{
				System.out.println("Chrome driver Exepetion occur "+e);
			}
			break;
		default:
			break;
		}
		
	}
	
	/**
	 * Close all the browser instance after test 
	 */
	
	@AfterClass
	public void tearDown() {
		System.out.println("After Class is running ");
		driver.quit();
	}
	
}
