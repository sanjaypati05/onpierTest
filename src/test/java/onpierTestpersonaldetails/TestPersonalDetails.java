package onpierTestpersonaldetails;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import onpierPages.FahrzeugscheinhochladenPage;
import onpierPages.OnpierHomePage;
import onpierPages.PersönlicheDateneingebenPage;
import onpierTestHelper.ConfigRead;
import onpierTestHelper.TestBase;

public class TestPersonalDetails extends TestBase{
	
@BeforeMethod
	
	public void launchTheURl() {
		
		System.out.println("Before method is running ");
		driver.get(ConfigRead.url);
	}
	
/**
 * Below test verify all different Anrede present in Personal details page
 */
	@Test
	public void testAnrede() {
		System.out.println("Test Started");
		
		
		OnpierHomePage onpierHomePage =new OnpierHomePage (driver);
		FahrzeugscheinhochladenPage fahrzeugscheinhochladenPage=new FahrzeugscheinhochladenPage(driver);
		
		onpierHomePage.clickPrämiebeantragen();
		
		fahrzeugscheinhochladenPage.uploadDocuments();
		PersönlicheDateneingebenPage persönlicheDateneingebenPage=new PersönlicheDateneingebenPage(driver); 
		persönlicheDateneingebenPage.verifyAndRedeOptions();
		
	}
	
	/**
	 * Below test verify all different mandatory error message displayed for each filed 
	 */
	
	@Test
	public void verifyPersönlicheDateneingebenMandatoryErrorMessage() throws AWTException {
		
		OnpierHomePage onpierHomePage =new OnpierHomePage (driver);
		FahrzeugscheinhochladenPage fahrzeugscheinhochladenPage=new FahrzeugscheinhochladenPage(driver);
		
		onpierHomePage.clickPrämiebeantragen();
		
		fahrzeugscheinhochladenPage.uploadDocuments();
		PersönlicheDateneingebenPage persönlicheDateneingebenPage=new PersönlicheDateneingebenPage(driver); 
		persönlicheDateneingebenPage.verifyMandatoryErrorMessage();
		
	}
	
	/**
	 * This test will validate the new option added to the page when Unternehmen radio button is selected 
	 */
	@Test
	public void verifyUnternehmenExtraOptions() {
		OnpierHomePage onpierHomePage =new OnpierHomePage (driver);
		onpierHomePage.clickPrämiebeantragen();
		
		FahrzeugscheinhochladenPage fahrzeugscheinhochladenPage=new FahrzeugscheinhochladenPage(driver);
		fahrzeugscheinhochladenPage.uploadDocuments();
		
		PersönlicheDateneingebenPage persönlicheDateneingebenPage=new PersönlicheDateneingebenPage(driver);
		persönlicheDateneingebenPage.verifyUnternehmenOptionsDisplayed();
		
	}

	
	@Test
	
	public void verifyEachFiledValidation() {
		OnpierHomePage onpierHomePage =new OnpierHomePage (driver);
		onpierHomePage.clickPrämiebeantragen();
		
		FahrzeugscheinhochladenPage fahrzeugscheinhochladenPage=new FahrzeugscheinhochladenPage(driver);
		fahrzeugscheinhochladenPage.uploadDocuments();
		
		PersönlicheDateneingebenPage persönlicheDateneingebenPage=new PersönlicheDateneingebenPage(driver);
		//Verify Vorname should be 2 character minimum and 50 character maximum
		persönlicheDateneingebenPage.verifInvalidFormatVorNameValidation();
		
		//Verify Nachname should be 2 character minimum and 50 character maximum
		persönlicheDateneingebenPage.verifyInvalidNachNameValidation();
		
		//Verify the wrong email format error message
		
		persönlicheDateneingebenPage.verifyInvalidEmailformat();
		
		//Verify the Kontoinhaber should consist 1st name and last name at least one space in between the name 
		
		persönlicheDateneingebenPage.verifyInvalidKontoinhaberformat();
		
		//Verify the wrong IBAN format --AS42 4234 4234 2342 3424 23
		persönlicheDateneingebenPage.verifyInvalidIBANformat();
		
		//Verify Weiter button is disabled when all mandatory fields are not entered
		persönlicheDateneingebenPage.verifyWeiterDisbale();
		
		//Verify Weiter button is enabled when all mandatory fields are entered and it's navigating to 3rd stepper of the page 
		persönlicheDateneingebenPage.verifyWeiterEnableAndNavigateToNextStep();
	}
}
