package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MenuPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {

	@Test(priority = 1)
	public void validLoginTest() {
		MenuPage menuPage = new MenuPage(driver);
		
		menuPage.navigateTo(menuPage.loginLink);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginInApp("TestUser", "12345@67890");
		
		assertTrue(loginPage.checkMsgIsDisplayed(loginPage.loginSuccessMsg));
		loginPage.logoutFromApp();
	}
	
	@Test(priority = 2)
	public void invalidLoginTest() {
		MenuPage menuPage = new MenuPage(driver);
		
		menuPage.navigateTo(menuPage.loginLink);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginInApp("TestUser", "12345");
		
		assertTrue(loginPage.checkMsgIsDisplayed(loginPage.loginErrorMsg));
		
	}
}
