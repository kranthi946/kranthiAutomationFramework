package driver;

import com.AI.enums.ConfigProperties;
import com.AI.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class DriverFactory {

	private DriverFactory() {
	}

	public static WebDriver getDriver(String browser) throws MalformedURLException {

		WebDriver driver = null;
		String runmode = PropertyUtils.get(ConfigProperties.RUNMODE);

		if (browser.equalsIgnoreCase("chrome")) {
			// ChromeOptions to configure Chrome browser settings
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--incognito");
			chromeOptions.setBinary("/usr/bin/google-chrome");
			chromeOptions.addArguments("--incognito");
			chromeOptions.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--remote-allow-origins=*");


			// Add any Chrome options here (optional, e.g. headless mode)
			// chromeOptions.addArguments("--headless"); // Example: run headless
			// chromeOptions.addArguments("--disable-extensions"); // Example: disable extensions

			if (runmode.equalsIgnoreCase("remote")) {
				// Use ChromeOptions for remote WebDriver setup
				//chromeOptions.setCapability("browserName", BrowserType.CHROME);
				driver = new RemoteWebDriver(new URL("http://44.213.77.244:4444"), chromeOptions);

			} else {
				// Use ChromeOptions for local ChromeDriver setup
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(chromeOptions);
			}
		} else if (browser.equalsIgnoreCase("firefox")) {
			if (runmode.equalsIgnoreCase("remote")) {
				// Firefox specific configuration can be added here
				driver = new RemoteWebDriver(new URL("http://44.213.77.244:4444"), new FirefoxDriver().getCapabilities());
			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}



	// Method to initialize WebDriver instances for multiple browsers based on config
	public static List<WebDriver> getMultipleDrivers(List<String> browsers) throws MalformedURLException {
		// Initialize a list to store WebDriver instances for each browser
		List<WebDriver> drivers = new ArrayList<>();

		// Iterate through each browser in the list and create the corresponding WebDriver instance
		for (String browser : browsers) {
			WebDriver driver = getDriver(browser);  // Initialize the driver for the current browser
			drivers.add(driver);  // Add the driver to the list of drivers
		}

		// Return the list of WebDriver instances
		return drivers;
	}

}
