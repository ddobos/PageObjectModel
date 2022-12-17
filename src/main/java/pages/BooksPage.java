package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.SeleniuWrappers;

public class BooksPage extends SeleniuWrappers {
	
	WebDriver driver;
	public Select selectDropDown; 
	
	public BooksPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By cookBooksLink = By.cssSelector("ul[class*='categories'] a[href*=cook]");
	public By countBooks = By.cssSelector("ul[class*='products']>li");
	public By saleLabel = By.cssSelector("span[class='onsale']");
	public By orderDropDown = By.name("orderby");
	public By sliderInitialPosition = By.cssSelector("span[style='left: 0%;']");
	public By sliderFinalPosition = By.cssSelector("span[style='left: 100%;']");
	public By productTitle = By.cssSelector("h1[class*='product_title']");
	public By price = By.xpath("//span[@class='price']/ins/span/bdi|//span[@class='price']/span/bdi");

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
