package onpierTestHelper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class BasePage {

	/**
	 * param elementToBeClicked WebElement to be clicked
	 * 
	 * @param description logical name of specified WebElement, used for Logging
	 *                    purposes in report
	 * @param scroll      used true whenever user want to scroll the element on the
	 *                    top of the page.
	 */
	public static void click(WebElement elementToBeClicked, String description, boolean... scroll) {
		if (elementToBeClicked != null) {
			WaitHelper.waitForElementToBeDisplayed(elementToBeClicked, "Test element displayed");
			System.out.println("Click on '" + description + "'");
			try {
				// Scroll Up or Down if element is not visible
				JavascriptExecutor jse = (JavascriptExecutor) TestBase.driver;
				if (scroll.length > 0 && scroll[0]) {
					jse.executeScript("arguments[0].scrollIntoView(true)", elementToBeClicked);
				} else {
					jse.executeScript("arguments[0].scrollIntoView(false)", elementToBeClicked);
				}
			} catch (WebDriverException wde) {
				System.out.println("Webdriver execption : " + wde);
			}
			// Then click element
			elementToBeClicked.click();
		} else {

			System.out.println("Element is null");
		}
	}

	/**
	 * @param elementToBeClicked WebElement to be clicked
	 * @param description        logical name of specified WebElement, used for
	 *                           Logging purposes in report
	 */
	public static void clickJavascript(WebElement elementToBeClicked, String description) {
		if (elementToBeClicked != null) {
			System.out.println("Click on '" + description + "'");
			try {
				WaitHelper.waitForElementToBeDisplayed(elementToBeClicked, "Test element displayed");
				JavascriptExecutor jse = (JavascriptExecutor) TestBase.driver;
				jse.executeScript("arguments[0].click();", elementToBeClicked);

			} catch (Exception wde) {
				System.out.println("Exception in clicking via Javascript" + wde);
			}

		} else {
			System.out.println("Element to be clicked is null");
		}
	}

	/**
	 * @param element     WebElement to be clicked
	 * @param value
	 * @param description logical name of specified WebElement, used for Logging
	 *                    purposes in report
	 */
	public static void enterData(WebElement element, String value, String description) {
		try {
			WaitHelper.waitForElementToBeDisplayed(element, "Wait for the tex box");
			element.clear();
			element.sendKeys(value);

		} catch (Exception e) {
			System.out.println("Expection occured while entering data " + e);

		}
	}

	/**
	 * @param element     WebElement whose text is needed
	 * @param description logical name of specified WebElement, used for Logging
	 *                    purposes in report
	 */
	public static String getText(WebElement element, String description) {
		String text = null;
		try {
			WaitHelper.waitForElementToBeDisplayed(element, "Element displayed");
			text = element.getText();

		} catch (StaleElementReferenceException e) {
			text = element.getText();

		} catch (NoSuchElementException e) {
			System.out.println("Element not found");
		}
		return text;
	}

	/**
	 * Verify Element is enable
	 * 
	 * @param testConfig
	 * @param element
	 * @return
	 */
	public static Boolean IsElementEnabled(WebElement element) {
		Boolean visible = true;
		try {
			WaitHelper.waitForElementToBeDisplayed(element, "Element available for enable check");
			visible = element.isEnabled();
		} catch (StaleElementReferenceException e) {
			visible = element.isEnabled();

		} catch (NoSuchElementException e) {
			visible = false;
		} catch (Exception e) {
			visible = false;
		}

		return visible;
	}

	/**
	 * This method verify the presence of webelement in the page and return true if
	 * present otherwise false
	 * 
	 * @param testConfig
	 * @param element
	 * @return
	 */
	public static Boolean IsElementDisplayed(WebElement element) {
		Boolean visible = true;
		if (element == null)
			return false;
		try {
			WaitHelper.waitForSeconds(2);
			visible = element.isDisplayed();
		} catch (StaleElementReferenceException e) {
			visible = element.isDisplayed();

		} catch (NoSuchElementException e) {
			visible = false;
		} catch (Exception e) {
			visible = false;
		}
		return visible;
	}

	/**
	 * @author Sanjaya
	 * @param Filepath File path of the file
	 * @throws AWTException
	 */

	public static void robotClassFileUpload(String Filepath)  {

		try {
			Robot rb = new Robot();
			rb.delay(2000);

			// Put path to file in clipboard
			StringSelection ss = new StringSelection(Filepath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			// CTRL+V
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);

			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);

			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			WaitHelper.waitForSeconds(3);
			
		}catch(Exception e) {
			
		}
	}

	public static void robotTab() throws AWTException {
		Robot rb = new Robot();
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
	}

}
