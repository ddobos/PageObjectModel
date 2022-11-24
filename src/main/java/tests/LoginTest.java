package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MenuPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {

	@Test(priority = 1)
	public void loginTest() {
		MenuPage menuPage = new MenuPage(driver);
		
		menuPage.navigateTo(menuPage.loginLink);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginInApp("TestUser", "12345@67890");
	}
}
