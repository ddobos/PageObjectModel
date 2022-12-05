package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.BasePage;

public class DataProviderLoginTest extends BasePage {

	@DataProvider(name="LoginTestData")
	public Object[][] loginTestData(){
		
		Object[][] data = new Object[2][3];
		data[0][0] = "TestUser";
		data[0][1] = "12345@67890";
		data[0][2] = true;
		data[1][0] = "UserGresit";
		data[1][1] = "parolaGresita";
		data[1][2] = false;
		
		return data;
	}
	
	@Test(priority = 1, dataProvider = "LoginTestData")
	public void loginTest(String userName, String password, Boolean success) {
		menu.click(menu.loginLink);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginInApp(userName, password);
		if (success) {
			assertTrue(loginPage.checkElementIsDisplayed(loginPage.loginSuccessMsg));
			loginPage.logoutFromApp();
		}else if(!success) {
			assertTrue(loginPage.checkElementIsDisplayed(loginPage.loginErrorMsg));
			loginPage.closePopUp();
		}
	}
}
