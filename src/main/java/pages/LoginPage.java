package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniuWrappers;

public class LoginPage extends SeleniuWrappers{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By userName = By.id("log");
	
	public By passwordField = By.id("password");
	
	public By submitButton = By.xpath("//input[@class='submit_button']");
	
	public By loginErrorMsg = By.cssSelector("div[class*='sc_infobox_style_error']");
	
	public By loginSuccessMsg = By.cssSelector("div[class*='sc_infobox_style_success']");
	
	public By logoutButton = By.cssSelector("li[class='menu_user_logout']");
	
	public By closePopUp = By.cssSelector("a[class='popup_close']");
	
	public void loginInApp(String userName, String passwd) {
		sendKeys(this.userName, userName);
		sendKeys(passwordField,passwd);
		
		click(submitButton);
	}
	
	public void logoutFromApp() {
		click(logoutButton);
	}
	
	public void closePopUp() {
		click(closePopUp);
	}

}
