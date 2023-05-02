package onpierPages;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import onpierTestHelper.BasePage;
import onpierTestHelper.WaitHelper;

public class PersönlicheDateneingebenPage extends BasePage {

	@FindBy(id = "mat-select-0")
	private WebElement anredeSelect;

	@FindBy(xpath = "//*[contains(text(),'Bitte wählen Sie Ihre Anrede aus')]")
	private WebElement anredeErrorMessage;

	@FindBy(id = "mat-radio-3-input")
	private WebElement unternehmenRadioButton;

	@FindBy(xpath = "//input[@placeholder='Musterunternehmen GmbH']")
	private WebElement UnternehmensnameinklUnternehmensrechtsformInput;

	@FindBy(xpath = "//*[@label='Umsatzsteuer-ID (oder Steuernummer)']//input")
	private WebElement UmsatzsteuerIDInput;

	@FindBy(id = "mat-option-0")
	private WebElement matSelectOption1;

	@FindBy(id = "mat-option-1")
	private WebElement matSelectOption2;

	@FindBy(id = "mat-option-2")
	private WebElement matSelectOption3;

	@FindBy(xpath = "//*[@label='Vorname']//input")
	private WebElement vornameInput;

	@FindBy(xpath = "//*[contains(text(),'Bitte geben Sie Ihren Vornamen ein')]")
	private WebElement vornameErrorMessage;

	@FindBy(xpath = "//*[contains(text(),'Der Vorname muss mindestens zwei Zeichen lang sein')]")
	private WebElement vornameErrorMessageForLessThanTwoCharacter;

	@FindBy(xpath = "//*[@label='Nachname']//input")
	private WebElement nachnameInput;

	@FindBy(xpath = "//*[contains(text(),'Der Nachname muss mindestens zwei Zeichen lang sein')]")
	private WebElement nachnameErrorMessageForLessThanTwoCharacter;

	@FindBy(xpath = "//*[contains(text(),'Bitte geben Sie Ihren Nachnamen ein')]")
	private WebElement nachnameErrorMessage;

	@FindBy(xpath = "//*[@label='E-Mail-Adresse']//input")
	private WebElement emailInput;

	@FindBy(xpath = "//*[contains(text(),'Bitte geben Sie Ihre E-Mail-Adresse ein')]")
	private WebElement emailErrorMessage;

	@FindBy(xpath = "//*[contains(text(),'Bitte geben Sie eine gültige E-Mail-Adresse ein')]")
	private WebElement invalidFormatEmailErrorMessage;

	@FindBy(xpath = "//*[@label='Kontoinhaber']//input")
	private WebElement kontoinhaberInput;

	@FindBy(xpath = "//*[contains(text(),'Bitte geben Sie Vor- und Nachname des Kontoinhabers ein')]")
	private WebElement kontoinhaberErrorMessage;

	@FindBy(xpath = "//*[@label='IBAN']//input")
	private WebElement iBANInput;

	@FindBy(xpath = "//*[contains(text(),' Bitte geben Sie eine vollständige IBAN ein')]")
	private WebElement iBANErrorMessage;

	@FindBy(xpath = "(//*[contains(text(),'Weiter')])[2]")
	private WebElement weiterButton;

	WebDriver driver;

	public PersönlicheDateneingebenPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/**
	 * Verify all Anrede options e.g - Herr,Frau and Divers
	 */
	public void verifyAndRedeOptions() {

		List<String> matOptions = new ArrayList<String>();
		matOptions.add("Herr");
		matOptions.add("Frau");
		matOptions.add("Divers");
		click(anredeSelect, "Click on the select option");
		WaitHelper.waitForSeconds(2);
		
		Assert.assertEquals(true, matOptions.contains(matSelectOption1.getText()));
		Assert.assertEquals(true, matOptions.contains(matSelectOption2.getText()));
		Assert.assertEquals(true, matOptions.contains(matSelectOption3.getText()));
		System.out.println("All options are verified ");

	}

	/**
	 * Verify all filed mandatory message
	 * 
	 * @throws AWTException
	 */

	public void verifyMandatoryErrorMessage() throws AWTException {

		click(vornameInput, "Click on Vorname");
		robotTab();
		String returnvornameErrorMessage = vornameErrorMessage.getText();
		System.out.println(returnvornameErrorMessage);
		Assert.assertEquals(returnvornameErrorMessage, "Bitte geben Sie Ihren Vornamen ein.");

		click(nachnameInput, "Click on NachName");
		click(vornameInput, "Click on Vorname");
		String returnNachNameErrorMessage = nachnameErrorMessage.getText();
		System.out.println(returnNachNameErrorMessage);
		Assert.assertEquals(returnNachNameErrorMessage, "Bitte geben Sie Ihren Nachnamen ein.");

		click(emailInput, "Click on email");
		click(vornameInput, "Click on Vorname");
		String returnEmailErrorMessage = emailErrorMessage.getText();
		System.out.println(returnEmailErrorMessage);
		Assert.assertEquals(returnEmailErrorMessage, "Bitte geben Sie Ihre E-Mail-Adresse ein.");

		click(kontoinhaberInput, "Click on kontoinhaber");
		click(vornameInput, "Click on Vorname");
		String returnkontoinhaberErrorMessage = kontoinhaberErrorMessage.getText();
		System.out.println(returnkontoinhaberErrorMessage);
		Assert.assertEquals(returnkontoinhaberErrorMessage, "Bitte geben Sie Vor- und Nachname des Kontoinhabers ein.");

		click(iBANInput, "Click on IBAN");
		click(vornameInput, "Click on Vorname");
		String returnIBANErrorMessage = iBANErrorMessage.getText();
		System.out.println(returnIBANErrorMessage);
		Assert.assertEquals(returnIBANErrorMessage,
				"Bitte geben Sie eine vollständige IBAN ein (z. B. DE45 7890 8965 5643 3454 00).");

		click(anredeSelect, "Click on the select option");
		WaitHelper.waitForSeconds(3);
		robotTab();
		//String returnAnredErrorMessage = anredeErrorMessage.getText();
		//System.out.println(returnAnredErrorMessage);
		//Assert.assertEquals(returnAnredErrorMessage, "Bitte wählen Sie Ihre Anrede aus.");

	}

	public void verifyUnternehmenOptionsDisplayed() {

		click(unternehmenRadioButton, "Click on Unternehmen Radio button");

		Assert.assertTrue(IsElementDisplayed(UmsatzsteuerIDInput));
		Assert.assertTrue(IsElementDisplayed(UnternehmensnameinklUnternehmensrechtsformInput));
		;
	}

	public void verifInvalidFormatVorNameValidation() {

		enterData(vornameInput, "S", "Enter the wrong Vorname format");
		click(nachnameInput, "Click on Nach Name to get the error ");
		String returnWrongVorNameformatError = getText(vornameErrorMessageForLessThanTwoCharacter,
				"Get text of the  Vorname Invalid format error");
		Assert.assertEquals(returnWrongVorNameformatError, "Der Vorname muss mindestens zwei Zeichen lang sein.");
		System.out.println(returnWrongVorNameformatError);
	}

	public void verifyInvalidNachNameValidation() {
		enterData(nachnameInput, "S", "Enter the wrong NachName format");
		click(vornameInput, "Click on VorName to get the error ");
		String returnWrongNachNameformatError = getText(nachnameErrorMessageForLessThanTwoCharacter,
				"Get text of the Nachname Invalid format error");
		Assert.assertEquals(returnWrongNachNameformatError, "Der Nachname muss mindestens zwei Zeichen lang sein.");
		System.out.println(returnWrongNachNameformatError);
	}

	public void verifyInvalidEmailformat() {

		enterData(emailInput, "S@g", "Enter the wrong Email format");
		click(nachnameInput, "Click on Nach Name to get the error ");
		String returnWrongEmailformatError = getText(invalidFormatEmailErrorMessage,
				"Get text of the emailid Invalid format error");
		System.out.println(returnWrongEmailformatError);
		Assert.assertEquals(returnWrongEmailformatError, "Bitte geben Sie eine gültige E-Mail-Adresse ein.");
	}

	public void verifyInvalidKontoinhaberformat() {

		enterData(kontoinhaberInput, "dd", "Enter the wrong Kontoinhaber format");
		click(nachnameInput, "Click on Nach Name to get the error ");
		String returnWrongKontoinhaberformatError = getText(kontoinhaberErrorMessage,
				"Get text of the kontoinhaber Invalid format error");
		System.out.println(returnWrongKontoinhaberformatError);
		Assert.assertEquals(returnWrongKontoinhaberformatError,
				"Bitte geben Sie Vor- und Nachname des Kontoinhabers ein.");

	}

	public void verifyInvalidIBANformat() {

		enterData(iBANInput, "S", "Enter the wrong Vorname format");
		click(nachnameInput, "Click on Nach Name to get the error ");
		String returnWrongIBANformatError = getText(iBANErrorMessage, "Get text of the IBAN Invalid format error");
		System.out.println(returnWrongIBANformatError);
		Assert.assertEquals(returnWrongIBANformatError,
				"Bitte geben Sie eine vollständige IBAN ein (z. B. DE45 7890 8965 5643 3454 00).");

	}

	public void verifyWeiterDisbale() {
		Assert.assertTrue(weiterButton.isEnabled());
	}

	public void verifyWeiterEnableAndNavigateToNextStep() {
		click(anredeSelect, "Click on anredeSelect drop down");
		click(matSelectOption1, "Select Option 1");
		enterData(vornameInput, "Sanjaya", "Enter Vorname");
		enterData(nachnameInput, "Pati", "Enter Nachname");
		enterData(emailInput, "sanjay@gmail.com", "Enter Email");
		enterData(kontoinhaberInput, "Sanjaya Pati", "Enter Kontoinhaber");
		enterData(iBANInput, "RT12 3123 1232 3113 2138 88", "Enter IBAN Number");
		Assert.assertTrue(IsElementEnabled(weiterButton));
		click(weiterButton, "Click on Weiter Button");

	}
}
