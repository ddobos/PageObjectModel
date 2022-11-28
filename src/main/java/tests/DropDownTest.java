package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utils.BaseTest;

public class DropDownTest extends BaseTest {

	
	@Test(priority = 1)
	public void selectByValueTest() {
		app.menu.navigateTo(app.menu.books);
		app.shop.filterByValue("price-desc");
		assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/?orderby=price-desc");
		assertEquals(app.shop.getCurrentSelectedOption(),"Sort by price: high to low2");
	}
	
	@Test(priority = 2)
	public void selectByIndex() {
		app.shop.filterByIndex(3);
		assertEquals(app.shop.getCurrentSelectedOption(),"Sort by latest");
	}
	
	@Test(priority = 3)
	public void selectedByVisibleText() {
		app.shop.filterByVisibleText("Sort by popularity");
		assertEquals(app.shop.getCurrentSelectedOption(), "Sort by popularity");
		
	}
	
	@Test(priority = 4)
	public void example() {
		WebElement element = driver.findElement(By.name("orderby"));
		Select selecta = new Select(element);
		selecta.selectByIndex(2);
		//la fiecare refresh de pagina trebuie de identificat elementul din nou.
		selecta.selectByVisibleText("Sort By popularity");
	}
		
		
}

