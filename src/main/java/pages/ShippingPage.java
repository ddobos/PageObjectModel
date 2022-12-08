package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.SeleniuWrappers;

public class ShippingPage extends SeleniuWrappers{

	WebDriver driver;
	Select dropdown;
	
	public ShippingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By countryShipping = By.id("shipping_country");
	public By regionShipping = By.id("shipping_state");
	
//	public By country = By.xpath("//select[@id='shipping_country']/following::span");
//	public By countryValue = By.xpath("//select[@id='shipping_country']/following::span/span[@role='textbox']");
//	
//	public By region = By.xpath("//select[@id='shipping_state']/following::span");
//	public By regionValue = By.xpath("//select[@id='shipping_state']/following::span/span[@role='textbox']");
	
//	public void selectedCustomSelectByValue(By locator, String text) {
//		waitForELementToBeVisible(locator);
//		WebElement select = driver.findElement(locator);
//		select.click();
//		List<WebElement> liList = driver.findElements(By.cssSelector("ul[role='listbox'] li"));
//		for (WebElement li : liList) {
//			if (li.getText().equals(text)) {
//				li.click();
//				break;
//			}
//		}
//	}
	
//	public void filterByIndex(By locator, int index) { //42
//		dropdown = new Select(driver.findElement(locator));
//		dropdown.selectByIndex(index);
//		
//	}
//	
//	public void filterByValue(By locator, String value) {
//		dropdown = new Select(driver.findElement(locator));
//		dropdown.selectByValue(value);
//	}
//	
//	public String getFilterValue(By locator) {
//		dropdown = new Select(driver.findElement(locator));
//		return dropdown.getFirstSelectedOption().getText();
//	}
	
}
