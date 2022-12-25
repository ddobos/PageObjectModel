package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.BaseTest;

public class Homework28 extends BaseTest {

	@Test(priority = 1)
	public void homeWorkTest() {

		SoftAssert sa = new SoftAssert();

		sa.assertTrue(checkRedirect(app.menu.fbLink, "facebook"));
		sa.assertTrue(checkRedirect(app.menu.twitterLink, "twitter"));
		sa.assertTrue(checkRedirect(app.menu.instagrammLink, "instagram"));

		sa.assertAll();
	}

	public Boolean checkRedirect(By locator, String checkedUrl) {
		app.menu.click(locator);

		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		boolean checked = driver.getCurrentUrl().contains(checkedUrl);
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
		return checked;
	}

	@Test(priority = 2)
	public void javScriptTest() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String javaStringHover = "var objObject=document.createEvent('MouseEvents');"
				+ "objObject.initMouseEvent('mouseover', true);arguments[0].dispatchEvent(objObject);";
		jse.executeScript(javaStringHover, app.menu.getWebElement(app.menu.blogLink));
		jse.executeScript("arguments[0].click()", app.menu.getWebElement(app.menu.blogSubMenuPostFormats));
		jse.executeScript("document.getElementsByClassName('post_title')[3].scrollIntoView()");
		jse.executeScript("arguments[0].click()", app.blog.getWebElement(app.blog.galleryLink));
		jse.executeScript("document.getElementById('author').value = \"abc\"");
		jse.executeScript("document.getElementById('email').value = \"test@test.com\"");
		jse.executeScript("document.getElementById('url').value = \"https:google.com\"");
		jse.executeScript("document.getElementById('comment').value = \"Mesaj de la test.\"");
		jse.executeScript("document.getElementById('send_comment').click()");

	}

}
