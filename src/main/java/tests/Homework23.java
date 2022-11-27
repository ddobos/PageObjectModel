package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.BlogPage;
import pages.BooksPage;
import utils.BaseTest;

public class Homework23 extends BaseTest{
	
	@Test(priority = 1)
	public void homeWork22() {
		BlogPage blog = menu.navigateToBlogClassicPage();
		blog.submitSearchMessage(blog.seachText);
		menu.navigateTo(blog.foundMsg);
		SoftAssert softAsser = new SoftAssert();
		softAsser.assertTrue(blog.checkBlogCategory("Classic"));
		softAsser.assertTrue(blog.checkBlogCategory("News"));
		softAsser.assertTrue(blog.checkBlogCategory("Recommend"));
		softAsser.assertAll();
	}
	
	@Test(priority = 2)
	public void cookBooksSale() {
		BooksPage book = menu.navigateToBooksPage();
		book.navigateTo(book.cookBooks);
		assertTrue(book.allBooksIsOnSale());
		
	}

}
