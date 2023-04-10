package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class OpeningClosingClass implements Constants
{
	public static  WebDriver driver;
	
	@BeforeMethod
	public static void openApplication() {
		System.setProperty(chromekey, chromevalue);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(urlofapplication);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterMethod
	public static void closeapplication() {
		driver.quit();
	}
}
