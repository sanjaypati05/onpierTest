package onpierTestHelper;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	/**
	 * This method is created to add static wait for given seconds of time
	 * 
	 * @param seconds
	 */
	public static void waitForSeconds(int seconds) {
		int milliseconds = seconds * 1000;
		try {

			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {

		}
	}

	/**
	 * This method is created to wait for any element, if element will not appear
	 * then testcase will fail.
	 * 
	 * @param element
	 * @param description
	 */
	public static void waitForElementToBeDisplayed(WebElement element, String description) {
		WebDriverWait wait = new WebDriverWait(TestBase.driver,
				Duration.ofSeconds(Integer.parseInt(ConfigRead.objectWaittime)));
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("Expected elemnt displayed: "+description);
		} catch (StaleElementReferenceException e) {

			try {
				wait.until(ExpectedConditions.visibilityOf(element));
			} catch (Exception exc) {

			}
		} catch (TimeoutException e) {
			try {
				wait.until(ExpectedConditions.visibilityOf(element));
			} catch (Exception exc) {

			}
		}
	}

}
