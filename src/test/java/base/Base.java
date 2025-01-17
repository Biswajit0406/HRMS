package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import configreader.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver dr;

//	public Base() {
//		initialization();
//	}

	
	public static void initialization() {
		String browser = ConfigReader.getProperty("browser");
		switch (browser.toLowerCase()) {
		case "chrome":
			// System.setProperty("Webdriver.chrome.driver","path")
			WebDriverManager.chromedriver().setup();
			dr = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup(); // Automatically sets up GeckoDriver
			dr = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup(); // Automatically sets up EdgeDriver
			dr = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Browser type not supported!");
		}
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    dr.manage().window().maximize();
	    dr.get(ConfigReader.getProperty("url"));
	}
	
	@AfterMethod(enabled =true)
	public void tearDownBrowser() {
		if (dr != null) {
			dr.quit();
		}
	}
}
