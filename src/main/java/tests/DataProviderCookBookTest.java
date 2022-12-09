package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.BooksPage;
import utils.BaseTest;
import utils.DataProviderClass;

public class DataProviderCookBookTest extends BaseTest {

	@DataProvider(name = "RedirectBookTestData")
	public Object[][] redirectBookTestData() {
		Object[][] data = new Object[5][2];

		data[0][0] = "A hundred and one receipes";
		data[0][1] = "https://keybooks.ro/shop/a-hundred-and-one-receipes/";

		data[1][0] = "Cooking with love";
		data[1][1] = "https://keybooks.ro/shop/cooking-with-love/";

		data[2][0] = "Healthy Lifestyle";
		data[2][1] = "https://keybooks.ro/shop/healthy-lifestyle/";

		data[3][0] = "The Vegan Cookery";
		data[3][1] = "https://keybooks.ro/shop/the-vegan-cookery/";

		data[4][0] = "Ultimate book of receipes";
		data[4][1] = "https://keybooks.ro/shop/ultimate-book-of-receipes/";

		return data;
	}

	@Test(priority = 1, dataProvider = "RedirectBookTestData")
	public void redirectBookTest1(String bookName, String bookUrl) {
		
		redirectBookTest(bookName, bookUrl);

//		menu.click(menu.booksLink);
//		BooksPage books = new BooksPage(driver);
//		books.click(books.cookBooksLink);
//
//		books.click(By.xpath("//a[contains(text(), '" + bookName + "')]"));
//		books.waitForElementToBeClicable(books.productTitle);
//		assertEquals(driver.getCurrentUrl(), bookUrl);

	}

	@Test(priority = 2, dataProviderClass = DataProviderClass.class, dataProvider = "redirectBookDataProvider")
	public void redirectBookTest2(String bookName, String bookUrl) {
//		menu.click(menu.booksLink);
//		BooksPage books = new BooksPage(driver);
//		books.click(books.cookBooksLink);
//
//		books.click(By.xpath("//a[contains(text(), '" + bookName + "')]"));
//		books.waitForElementToBeClicable(books.productTitle);
//		assertEquals(driver.getCurrentUrl(), bookUrl);
		redirectBookTest(bookName, bookUrl);
	}

	public void redirectBookTest(String bookName, String bookUrl) {

		menu.click(menu.booksLink);
		BooksPage books = new BooksPage(driver);
		books.click(books.cookBooksLink);

		books.click(By.xpath("//a[contains(text(), '" + bookName + "')]"));
		books.waitForElementToBeClicable(books.productTitle);
		assertEquals(driver.getCurrentUrl(), bookUrl);

	}
}
