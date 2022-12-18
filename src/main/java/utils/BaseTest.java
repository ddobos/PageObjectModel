package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BlogPage;
import pages.MenuPage;

public class BaseTest {

	public static WebDriver driver;
	String startUrl = "https://keybooks.ro";
	public MenuPage menu;
	public BasePage app;
	public BlogPage blog;

	@BeforeClass
	public void setup() {

		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		// setarea globala la nivel de @testClass
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(startUrl);

//		menu = new MenuPage(driver);
//		blog = new BlogPage(driver);
		app = new BasePage();

	}

	@AfterClass
	public void tearTeste() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

	@AfterMethod
	public void recordFailure(ITestResult testResult) {

		if (ITestResult.FAILURE == testResult.getStatus()) {
			TakesScreenshot poza = (TakesScreenshot) driver;
			File picture = poza.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

			try {
				Files.copy(picture, new File("screenshots/" + testResult.getName() + '-' + timeStamp + ".png"));
				System.out.println("Picture saved");
			} catch (IOException e) {
				System.out.println("Picture could not by saved");
				e.printStackTrace();
			}
		}
	}

}
