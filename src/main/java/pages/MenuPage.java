package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {
	
	public WebDriver driver;
	
	public MenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By loginLink = By.linkText("Login");
	public By contactsLink = By.linkText("CONTACTS");
	public By blog = By.linkText("BLOG");
	public By classicBlog = By.linkText("Classic");
	public By books = By.linkText("BOOKS");
	
	public void navigateTo(By locator) {
		driver.findElement(locator).click();
	}

	public ContactsPage navigateToContactPage() {
		driver.findElement(contactsLink).click();
		return new ContactsPage(driver);
	}
	
	public BlogPage navigateToBlogClassicPage() {
		driver.findElement(blog).click();
		driver.findElement(classicBlog).click();
		return new BlogPage(driver);
	}
	
	public BooksPage navigateToBooksPage() {
		driver.findElement(books).click();
		return new BooksPage(driver);
	}
}
