package tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.BaseTest;

public class Homework29 extends BaseTest {

	@Test(priority = 1)
	public void homeWorkTest() {
		app.menu.click(app.menu.searchIcon);
		app.menu.sendKeys(app.menu.searchInput, "King");
//		app.menu.click(app.menu.searchIcon);
		app.menu.click(app.menu.findKingLink);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("New releases", app.shop.getWebElement(app.shop.categoryTypeLink).getText());
		sa.assertEquals("1709", app.shop.getWebElement(app.shop.productId).getText());
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, 500)");
		
		List<WebElement> linkImages = app.shop.getWebElements(app.shop.linkImages);
		Set<Integer> checkedImages = new HashSet<Integer>();
		String imageName = "TheWickedKing";
		for (WebElement image : linkImages) {
			for (int imageNbr = 1; imageNbr < 7; imageNbr++) {
				if (!checkedImages.contains(imageNbr) &&image.getAttribute("href").contains(imageName + imageNbr + ".png")) {
					checkedImages.add(imageNbr);
					break;
				}
			}

		}

		sa.assertEquals(4, checkedImages.size());

		sa.assertAll();

	}

}
