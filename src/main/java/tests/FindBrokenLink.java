package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class FindBrokenLink extends BaseTest {
	
	static List<String> brokenList = new ArrayList<String>();

	@Test(priority = 1)
	public void testBrokenLink() throws IOException {
		List<WebElement> links = driver.findElements(By.cssSelector("a[href*='http']"));
		for (WebElement link : links) {
			String urlString =link.getAttribute("href");
			if (null == urlString)
				continue;
			URL url = new URL(urlString);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.connect();
			if (httpUrlConnection.getResponseCode() == 200) {
				System.out.println(urlString + " = " + httpUrlConnection.getResponseCode());
			}
			if (httpUrlConnection.getResponseCode() == 404) {
				System.out.println(urlString + " = " + httpUrlConnection.getResponseCode());
				brokenList.add(urlString);
			}
		}
		assertTrue(0 == brokenList.size());
		
	}

}
