package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import utils.SeleniuWrappers;

public class MenuPage extends SeleniuWrappers{
	
	public WebDriver driver;
	
	public MenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By loginLink = By.linkText("Login");
	public By contactsLink = By.linkText("CONTACTS");
	public By blogLink = By.linkText("BLOG");
	public By classicBlog = By.linkText("Classic");
	public By booksLink = By.linkText("BOOKS");
	public By eventsLink = By.linkText("EVENTS");
	public By homeLink = By.linkText("HOME");
	public By searchIcon = By.cssSelector("button[class*='search_submit']");
	public By searchInput = By.cssSelector("input[class*='search_field']");
	public By aboutLink = By.linkText("ABOUT");
	public By blogSubMenuMansory = By.xpath("//a[contains(text(),'Masonry')]");
	public By blogSubMenuMansorySubMenu2 = By.xpath("//a[contains(text(),'Masonry 2')]");
	public By blogSubMenuPostFormats = By.linkText("Post Formats");
	public By fbLink = By.cssSelector("div[class*='top_panel_top'] a[class*='facebook']");
	public By twitterLink = By.cssSelector("div[class*='top_panel_top'] a[class*='twitter']");
	public By instagrammLink = By.cssSelector("div[class*='top_panel_top'] a[class*='instagramm']");
	public By findKingLink = By.linkText("The Wicked King");
	
	public void navigateTo(By locator) {
		driver.findElement(locator).click();
	}
	
	public void search(String text) {
		click(searchIcon);
		sendKeys(searchInput, text);
		click(searchIcon);
	}

	public ContactsPage navigateToContactPage() {
		driver.findElement(contactsLink).click();
		return new ContactsPage(driver);
	}
	
	public BlogPage navigateToBlogClassicPage() {
		driver.findElement(blogLink).click();
		driver.findElement(classicBlog).click();
		return new BlogPage(driver);
	}
	
	public BooksPage navigateToBooksPage() {
		driver.findElement(booksLink).click();
		return new BooksPage(driver);
	}
	
}
