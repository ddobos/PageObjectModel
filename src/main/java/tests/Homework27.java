package tests;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class Homework27 extends BaseTest{

	
	@Test(priority = 1)
	public void homeWork27() {
		app.menu.navigateTo(app.menu.booksLink);
		app.shop.filterByValue(app.shop.orderDropDown, "price");
		List<WebElement> prices = app.shop.getWebElements(app.shop.price);
		Double lowPrice = Double.parseDouble(prices.get(0).getText().replace('$', ' '));
		Double highPrice = Double.parseDouble(prices.get(prices.size()-1).getText().replace('$', ' '));
		assertTrue(lowPrice<highPrice);
	}
}
