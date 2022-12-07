package utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class SeleniuWrappers extends BaseTest {

	public void click(By locator) {
		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.elementToBeClickable(locator));
			waitForElementToBeClicable(locator);
			WebElement element = driver.findElement(locator);
			element.click();
		} catch (NoSuchElementException e) {
			throw new TestException(e.getMessage());
		}
	}

	public void waitForElementToBeClicable(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}catch(NoSuchElementException e) {
			throw new TestException(e.getMessage());
		}
	}
	
	public void waitForELementToBeVisible(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}catch(NoSuchElementException e){
			throw new TestException(e.getMessage());
		}
	}
	
	public static boolean checkElementIsDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	
	public void sendKeys(By locator, String textToBeSend) {
		try {
			waitForELementToBeVisible(locator);
			WebElement element = driver.findElement(locator);
			element.clear();
			element.sendKeys(textToBeSend);
			
		}catch(NoSuchElementException e) {
			throw new TestException(e.getMessage());
		}
	}

}
