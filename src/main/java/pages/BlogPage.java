package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlogPage {
	
	WebDriver driver;
	public final String seachText = "Why I won't stop buying books";
	
	public BlogPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By searchBlog = By.xpath("//aside[@id='search-2']/descendant::input[@class='search_field']");
	public By submitSearch = By.xpath("//aside[@id='search-2']/descendant::button");
	public By foundMsg = By.xpath("//a[contains(text(), \"Why I won\")]");
	public By category = By.cssSelector("a[class='category_link']");
	
	public void submitSearchMessage(String msg) {
		driver.findElement(searchBlog).sendKeys(msg);
		driver.findElement(submitSearch).click();
	}
	
	public Boolean checkBlogCategory(String categoryName) {
		List<WebElement> categories = driver.findElements(category);
		for (WebElement category : categories) {
			if (category.getText().equalsIgnoreCase(categoryName)) {
				return true;
			}
		}
		return false;
	}

}
