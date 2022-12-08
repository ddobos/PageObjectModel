package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ActionClassExample extends BaseTest {

	
//	@Test(priority = 1)
	public void hoverTest() {
		app.menu.hoverElement(app.menu.blog);
		app.menu.hoverElement(app.menu.aboutLink);
		app.menu.hoverElement(app.menu.blog);
		app.menu.hoverElement(app.menu.blogSubMenuMansory);
		app.menu.click(app.menu.blogSubMenuMansorySubMenu2);
	}
	
//	@Test(priority = 2)
	public void dragAndDropTest() {
		app.menu.navigateTo(app.menu.books);
		app.shop.dragAndDrop(app.shop.sliderInitialPosition, 100, 0); //x + 100 px - deplasarea la dreapta
		app.shop.dragAndDrop(app.shop.sliderFinalPosition, -100, 0); //x - 100 px - deplasarea la stanga
	}
	
//	@Test(priority = 3)
	public void sendKeysExample() {
		app.menu.hoverElement(app.menu.blog);
		app.menu.click(app.menu.blogSubMenuPostFormats);
		
		Actions action = new Actions(driver);
		action.moveToElement(app.postFormat.getWebElement(app.postFormat.searchFiled))
		.keyDown(Keys.SHIFT)
		.sendKeys(app.postFormat.getWebElement(app.postFormat.searchFiled), "abracadabra")
		.perform();
	}
	
	@Test(priority = 4)
	public void sendKeysExample2() {
		app.menu.navigateTo(app.menu.contactsLink);
		
		Actions action = new Actions(driver);
		action.moveToElement(app.contact.getWebElement(app.contact.nameField))
		.sendKeys(app.contact.getWebElement(app.contact.nameField), "Name")
		.sendKeys(Keys.TAB, "ddobos@mtc.md")
		.sendKeys(Keys.TAB, "Subiect meu")
		.sendKeys(Keys.TAB, "Mesajul meu")
		.sendKeys(Keys.TAB, Keys.ENTER).perform();
	}
	
//	@Test(priority = 5)
	public void sendKeysExample3() {
		app.menu.navigateTo(app.menu.contactsLink);
		
		int getX = app.contact.getWebElement(app.contact.nameField).getLocation().getX();
		int getY = app.contact.getWebElement(app.contact.nameField).getLocation().getY();
		
		Actions action = new Actions(driver);
		action.moveByOffset(getX, getY)
		.sendKeys("Name")
		.sendKeys(Keys.TAB, "ddobos@mtc.md")
		.sendKeys(Keys.TAB, "Subiect meu")
		.sendKeys(Keys.TAB, "Mesajul meu")
		.sendKeys(Keys.TAB, Keys.ENTER).perform();
	}
}
