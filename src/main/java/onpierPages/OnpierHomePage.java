package onpierPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import onpierTestHelper.BasePage;
import onpierTestHelper.WaitHelper;

public class OnpierHomePage extends BasePage{
	
	@FindBy(xpath  = "(//*[contains(text(),'Prämie beantragen')])[1]")
	private WebElement  PrämiebeantragenButton;
	
	@FindBy(xpath  = "//*[contains(text(),'Fahrzeugschein Vorderseite hochladen')]")
	private WebElement  uploadTheFrontpageButton;
	
	@FindBy(xpath  = "//*[contains(text(),'Fahrzeugschein Rückseite hochladen')]")
	private WebElement  uploadTheBackPageButton;
	

	@FindBy(xpath  = "(//*[contains(text(),'Weiter')])[1]")
	private WebElement  WeiterButton;
	
	
	 
	WebDriver driver;
	public OnpierHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void clickPrämiebeantragen() {
		
		WaitHelper.waitForElementToBeDisplayed(PrämiebeantragenButton, "Test element displayed");
		click(PrämiebeantragenButton, "Click on the element");
		
}
}