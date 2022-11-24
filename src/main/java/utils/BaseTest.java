package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	String startUrl = "https://keybooks.ro";
	
	@BeforeClass
	public void setup() {
	
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		// setarea globala la nivel de @testClass
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(startUrl);
//		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
	}
	
	@AfterClass 
	public void tearTeste() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
