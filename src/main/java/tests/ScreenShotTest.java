package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import utils.BaseTest;

public class ScreenShotTest extends BaseTest {
	
	@Test(priority = 1)
	public void screeShotTest() {
		app.menu.navigateTo(app.menu.books);
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/");
	}

}
