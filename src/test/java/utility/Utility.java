package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	public static void waitForElement(WebDriver dr, WebElement element, int timeout) {

		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static boolean isElementVisible(WebElement element) {
		try {
			return element.isDisplayed();

		} catch (Exception e) {
			return false;
		}
	}
}
