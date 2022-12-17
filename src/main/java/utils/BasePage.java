package utils;

import pages.BooksPage;
import pages.ContactsPage;
import pages.EventsPage;
import pages.GenericEventPage;
import pages.MenuPage;
import pages.PostFormatPage;

public class BasePage extends BaseTest {
	
	public MenuPage menu= new MenuPage(driver);
	public BooksPage shop = new BooksPage(driver);
	public PostFormatPage postFormat = new PostFormatPage(driver);
	public ContactsPage contact = new ContactsPage(driver);
	public EventsPage events = new EventsPage(driver);
	public GenericEventPage genericEvent = new GenericEventPage(driver);

}
