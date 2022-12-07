package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LoginPage;
import pages.ShippingPage;
import utils.BaseTest;

public class Homework24 extends BaseTest{

	private final String country = "Canada";
	private final String region = "Newfoundland and Labrador";
	
	@Test(priority = 1)
	public void loginTest() {
		app.menu.navigateTo(menu.loginLink);
		LoginPage login = new LoginPage(driver);
		login.loginInApp("TestUser", "12345@67890");
		login.waitForELementToBeVisible(By.cssSelector("span[class='user_name']"));
	}
	
	@Test(priority = 2)
	public void shippingTest() {
		driver.navigate().to("https://keybooks.ro/account/edit-address/shipping/");
		ShippingPage ship = new ShippingPage(driver);
//		ship.selectedCustomSelectByValue(ship.country, this.country);
//		ship.selectedCustomSelectByValue(ship.region, this.region);
		ship.filterByIndex(ship.countryShipping, 41);
		ship.filterByValue(ship.regionShipping, "NL");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(this.country, ship.getFilterValue(ship.countryShipping));
		sa.assertEquals(this.region, ship.getFilterValue(ship.regionShipping));
		sa.assertAll();
	}
}
