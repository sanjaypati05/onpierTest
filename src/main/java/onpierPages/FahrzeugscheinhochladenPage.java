package onpierPages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import onpierTestHelper.BasePage;
import onpierTestHelper.ConfigRead;
import onpierTestHelper.WaitHelper;

public class FahrzeugscheinhochladenPage extends BasePage{
	
	@FindBy(xpath  = "//*[contains(text(),'Fahrzeugschein Vorderseite hochladen')]")
	private WebElement  uploadTheFrontpageButton;
	
	@FindBy(xpath  = "//*[contains(text(),'Fahrzeugschein Rückseite hochladen')]")
	private WebElement  uploadTheBackPageButton;
	

	@FindBy(xpath  = "(//*[contains(text(),'Weiter')])[1]")
	private WebElement  WeiterButton;

	WebDriver driver;
	
	public FahrzeugscheinhochladenPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	/**
	 * Upload required documents
	 * @throws  
	 */
	public void uploadDocuments() {
		WaitHelper.waitForSeconds(3);
		
		String fileToeUpload1=System.getProperty("user.dir")+ConfigRead.filenameToUpload1;
		String fileToeUpload2=System.getProperty("user.dir")+ConfigRead.filenameToUpload2;
		//uploadTheBackPageButton.sendKeys(projectPath+"\\src\\main\\resources\\SanjayaSignature.jpg");
		
		
		click(uploadTheFrontpageButton, "Click");
		
		WaitHelper.waitForSeconds(3);
		robotClassFileUpload(fileToeUpload1);
		click(uploadTheBackPageButton, "Click");
		WaitHelper.waitForSeconds(3);
		robotClassFileUpload(fileToeUpload2);
		click(WeiterButton, "Click on weiter button");
		System.out.println("Clicked on elemnt");
	}

}
