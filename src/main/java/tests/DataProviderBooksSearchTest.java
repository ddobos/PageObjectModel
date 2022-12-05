package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.DataProviderClass;

public class DataProviderBooksSearchTest extends BaseTest {

	@Test(priority = 1, dataProviderClass = DataProviderClass.class, dataProvider = "booksNameDataProvider")
	public void searchBooksTest(String bookName, String bookPictureName) {
		menu.search(bookName);
		
		WebElement element = driver.findElement(By.cssSelector("div[class*='" + bookPictureName+"']"));
		assertTrue(element.isDisplayed());
	}
	
}
