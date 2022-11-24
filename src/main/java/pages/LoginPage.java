package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By userName = By.id("log");
	
	public By passwordField = By.id("password");
	
	public By submitButton = By.xpath("//input[@class='submit_button']");
	
	public void loginInApp(String userName, String passwd) {
		driver.findElement(this.userName).sendKeys(userName);
		driver.findElement(passwordField).sendKeys(passwd);
		
		driver.findElement(submitButton).click();
	}

}
