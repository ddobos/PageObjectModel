package tests;

import org.testng.annotations.Test;

import pages.AudioPage;
import utils.BasePage;

public class Homework26 extends BasePage {

	
	@Test(priority = 1)
	public void homeWorkTest() throws InterruptedException {
		app.menu.hoverElement(app.menu.blogLink);
		app.menu.click(app.menu.blogSubMenuPostFormats);
		
		AudioPage audioPage = new AudioPage(driver);
		app.menu.click(audioPage.audioPostTiyle);
		audioPage.click(audioPage.playButton);
		audioPage.dragAndDrop(audioPage.timeSlider, 200, 0);
		audioPage.dragAndDrop(audioPage.volumeSlider, -50, 0);
		
	}
}
