package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class HandleWindowExample extends BaseTest{

	
	@Test(priority = 1)
	public void hundleWindowTest() {
		app.menu.navigateTo(app.menu.eventsLink);
		app.events.click(app.events.festivalOfOldLink);
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 800).perform();
//		action.scrollToElement(app.genericEvent.getWebElement(app.genericEvent.iFrame));
		
		app.genericEvent.clickMap();
		
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		for (String browserTab : browserTabs) {
			driver.switchTo().window(browserTab);
		}
		
		driver.findElement(By.xpath("//span[contains(text(), 'Accept all')]")).click();
		
		driver.close();
		
		driver.switchTo().window(browserTabs.get(0));
		
		app.genericEvent.clickMap();
		
		
	}
}
