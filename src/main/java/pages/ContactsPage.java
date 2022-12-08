package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SeleniuWrappers;

public class ContactsPage extends SeleniuWrappers {

	public WebDriver driver;
	
	public ContactsPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public By nameField = By.cssSelector("input[name='your-name']");
	public By emailField = By.cssSelector("input[name='your-email']");
	public By subjectField = By.cssSelector("input[name='your-s']");
	public By messageField = By.cssSelector("textarea[name='your-message']");
	public By submitButton = By.cssSelector("input[value='Send Message']");
	
	public By messageSendMsg = By.cssSelector("div[class='wpcf7-response-output']");
	public By emptyFieldMsg = By.cssSelector("span[class='wpcf7-not-valid-tip']");
	
	public void sendMessage(String name, String email, String subject, String message) {
		driver.findElement(nameField).sendKeys(name);
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(subjectField).sendKeys(subject);
		driver.findElement(messageField).sendKeys(message);
		driver.findElement(submitButton).click();
	}
	
	public boolean getMessage(By locator, String messageText) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, messageText));
			return true;
		}catch( TimeoutException e) {
			return false;
		}
	}
	
}

