package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class JavascripExecutorTest extends BaseTest{

	@Test(priority = 1)
	public void example1() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.location='https://emag.ro'");
		driver.navigate().back();
		
		jse.executeScript("window.history.go(-1)");
		
		jse.executeScript("window.history.forward(-1)");
		
		driver.navigate().refresh();
		driver.get(driver.getCurrentUrl());
		jse.executeScript("window.location.reload()");
		jse.executeScript("window.history.go(0)");
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
		
	}
	
	@Test(priority = 2)
	public void example2() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//alternativa la click
		jse.executeScript("arguments[0].click()", app.menu.getWebElement(app.menu.searchIcon));
		//alternativa la send keys
		jse.executeScript("arguments[0].value='coocking'", app.menu.getWebElement(app.menu.searchInput));
		//iarasi click
		jse.executeScript("arguments[0].click()", app.menu.getWebElement(app.menu.searchIcon));
	}
}
