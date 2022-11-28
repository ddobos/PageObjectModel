package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BooksPage {
	
	WebDriver driver;
	public Select selectDropDown; 
	
	public BooksPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By cookBooks = By.cssSelector("ul[class*='categories'] a[href*=cook]");
	public By countBooks = By.cssSelector("ul[class*='products']>li");
	public By saleLabel = By.cssSelector("span[class='onsale']");
	public By orderDropDown = By.name("orderby");

	public void navigateTo(By locator) {
		driver.findElement(locator).click();
		
	}

	public boolean allBooksIsOnSale() {
		List<WebElement> books = driver.findElements(countBooks);
		List<WebElement> onSales = driver.findElements(saleLabel);
		if (books.size() == onSales.size()) {
			return true;
		}
		return false;
	}
	
	public void filterByValue(String value) {
		WebElement element = driver.findElement(orderDropDown);
		selectDropDown = new Select(element);
		selectDropDown.selectByValue(value);
	}
	
	public void filterByIndex(int index) {
		WebElement element = driver.findElement(orderDropDown);
		selectDropDown = new Select(element);
		selectDropDown.selectByIndex(index);
	}
	
	public void filterByVisibleText(String text) {
		WebElement element = driver.findElement(orderDropDown);
		selectDropDown = new Select(element);
		selectDropDown.selectByVisibleText(text);
	}

	public String getCurrentSelectedOption() {
		WebElement element = driver.findElement(orderDropDown);
		selectDropDown = new Select(element);
		return selectDropDown.getFirstSelectedOption().getText();
	}
}
