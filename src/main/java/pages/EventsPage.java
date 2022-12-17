package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniuWrappers;

public class EventsPage extends SeleniuWrappers {

	WebDriver driver;
	
	public EventsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By festivalOfOldLink = By.linkText("Festival of Old Films");
	
}
