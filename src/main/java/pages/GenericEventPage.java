package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniuWrappers;

public class GenericEventPage extends SeleniuWrappers {

	WebDriver driver;
	
	public GenericEventPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public By mapLink = By.partialLinkText("map");
	public By iFrame = By.tagName("iframe");
	
	public void clickMap() {
		driver.switchTo().frame(getWebElement(iFrame));
		click(mapLink);
	}
}

