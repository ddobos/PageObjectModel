package utils;

import pages.BooksPage;
import pages.MenuPage;

public class BasePage extends BaseTest {
	
	public MenuPage menu= new MenuPage(driver);
	public BooksPage shop = new BooksPage(driver);

}
