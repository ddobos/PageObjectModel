package tests;

import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MenuPage;
import utils.BaseTest;

public class CookiesLoginTest extends BaseTest {
	Set<Cookie> setCookies;

	@Test(priority = 1)
	public void validLoginTest() {
		MenuPage menuPage = new MenuPage(driver);

		menuPage.navigateTo(menuPage.loginLink);

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginInApp("TestUser", "12345@67890");

		assertTrue(loginPage.checkElementIsDisplayed(loginPage.loginSuccessMsg));
		setCookies = driver.manage().getCookies();
	}

	@Test(priority = 2)
	public void cookiesLogin() {
		MenuPage menuPage = new MenuPage(driver);
		menuPage.navigateTo(menuPage.loginLink);
		for (Cookie cookie : setCookies) {
			driver.manage().addCookie(cookie);
		}

		menu.navigateTo(menu.blogLink);
	}
}
