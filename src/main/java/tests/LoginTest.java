package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MenuPage;
import utils.BaseTest;
import utils.TestNgListener;

@Listeners(TestNgListener.class)
public class LoginTest extends BaseTest {

	@Test(priority = 1)
	public void validLoginTest() {
		MenuPage menuPage = new MenuPage(driver);
		
		menuPage.click(menuPage.loginLink);
//		menuPage.navigateTo(menuPage.loginLink);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginInApp("TestUser", "12345@67890");
		
		assertTrue(loginPage.checkElementIsDisplayed(loginPage.loginSuccessMsg));
		loginPage.logoutFromApp();
	}
	
	@Test(priority = 2)
	public void invalidLoginTest() {
		MenuPage menuPage = new MenuPage(driver);
		
		menuPage.navigateTo(menuPage.loginLink);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginInApp("TestUser", "12345");
		
		assertTrue(LoginPage.checkElementIsDisplayed(loginPage.loginSuccessMsg));
		
	}
}
