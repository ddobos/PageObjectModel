package tests;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import utils.BaseTest;

public class CookingHandle extends BaseTest {
	@Test(priority = 1)
	public void addCookie() {

		driver.manage().addCookie(new Cookie("myCookie", "My cookie value"));
	}
	
	@Test(priority = 2)
	public void getCookie() {
		System.out.println(driver.manage().getCookieNamed("PHPSESSID"));
	}
}
