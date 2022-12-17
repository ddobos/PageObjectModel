package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniuWrappers;

public class AudioPage extends SeleniuWrappers {
	
	WebDriver driver;
	
	public AudioPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By audioPostTiyle = By.xpath("//a[contains(text(), 'Audio post')]");
	public By playButton = By.cssSelector("div[class*='mejs-play']");
	public By timeSlider = By.cssSelector("span[class='mejs-time-current']");
	public By volumeSlider = By.cssSelector("div[class='mejs-horizontal-volume-total'");

}
