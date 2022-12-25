package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.Log;

public class ScrollExample extends BaseTest {

	
//	@Test(priority = 1)
	public void  scrollExample1() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 2000)");
		
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 2000);
	}
	
//	@Test(priority = 2)
	public void scrollExample2() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		Actions action = new Actions(driver);
		
		WebElement signUpButton = driver.findElement(By.cssSelector("input[value='Sign up']"));
		jse.executeScript("arguments[0].scrollIntoView", signUpButton);
		
		action.moveToElement(signUpButton).perform();
	}
	
	@Test(priority = 3)
	public void scrollTopAndDown() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Log.info("My first Log");
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}
}
