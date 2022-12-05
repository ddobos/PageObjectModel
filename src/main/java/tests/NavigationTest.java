package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.MenuPage;
import utils.BaseTest;

public class NavigationTest extends BaseTest {

	@Test(priority = 1)
	public void naviTest() {
		MenuPage menuPage = new MenuPage(driver);
		
		assertTrue(menuPage.checkElementIsDisplayed(menuPage.eventsLink));
		menuPage.click(menuPage.eventsLink);
		assertTrue(menuPage.checkElementIsDisplayed(menuPage.contactsLink));
		menuPage.click(menuPage.contactsLink);
		assertTrue(menuPage.checkElementIsDisplayed(menuPage.homeLink));
		menuPage.click(menuPage.homeLink);
	}
}
