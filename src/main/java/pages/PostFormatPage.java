package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniuWrappers;

public class PostFormatPage extends SeleniuWrappers {

	public WebDriver driver;
	
	public PostFormatPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By searchFiled = By.cssSelector("input[title='Search for:']");
	
}
