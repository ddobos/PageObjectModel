package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BooksPage {
	
	WebDriver driver;
	
	public BooksPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By cookBooks = By.cssSelector("ul[class*='categories'] a[href*=cook]");
	public By countBooks = By.cssSelector("ul[class*='products']>li");
	public By saleLabel = By.cssSelector("span[class='onsale']");

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

}
