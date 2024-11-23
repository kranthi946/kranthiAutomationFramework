package driver;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Objects;

import com.AI.enums.ConfigProperties;
import com.AI.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;


public class Driver {

	// private constructor is helpful for no one can call this class .
	private Driver() {
	}
//once we apply null check condition to the value of get property key , the IO exception will be changed to "Exception" due to implementation of new method.
//public static  void initDriver() throws IOException

	// private constructor is helpful for no one can call this class .

//once we apply null check condition to the value of get property key , the IO exception will be changed to "Exception" due to implementation of new method.
//public static  void initDriver() throws IOException


	/**
	 * public static  void initDriver() throws Exception  {
	 * //if(driver==null)
	 * //checking the null condition for driver
	 * if(Objects.isNull(DriverManager.getDriver())) {
	 * System.setProperty("webdriver.chrome.driver",FrameworkConstants.getChromedriverpath());
	 * WebDriver	driver = new ChromeDriver();
	 * // system.out.println(Thread.currentThreadcount formula we can use ) in this line so we can find which thread is active when test is running in parallel methods
	 * DriverManager.setDriver(driver);
	 * // hardcoded url here . because of this ,  based on rule never hardcode, we are using property file .
	 * //DriverManager.getDriver().get("https://www.google.com/");
	 * DriverManager.getDriver().get(ReadPropertyFile.get("url")); // inputout exception will come because it is using property file exception
	 * }
	 * }
	 *
	 * @throws Exception
	 **/

	public static void initDriver(String browser) {

		if (Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser));


			} catch (MalformedURLException e) {
				throw new com.AI.exceptions.BrowserInvocationFailedException("Please check the capabilities of browser");
			}
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
			//DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.BROWSER));  tried but not working
			//DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.VERSION));
		}
	}



	public static void quitDriver() {


		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
//	/**
//	 * Initializes WebDriver instances for multiple browsers based on the configuration
//
////	public static void initDriver(List<String> browsers) {
////		if (Objects.isNull(DriverManager.getDriver())) {
////			try {
////				// Initialize multiple WebDriver instances for the given browsers
////				List<WebDriver> drivers = DriverFactory.getMultipleDrivers(browsers);
////
////				// Set the WebDriver instances in DriverManager for each thread
////				for (WebDriver driver : drivers) {
////					DriverManager.setDriver(driver);  // Set each driver for the current test thread
////				}
////
////				// Use the first driver (e.g., Chrome) to open the URL
////				DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
////
////			} catch (MalformedURLException e) {
////				// If there is an issue creating WebDriver, throw a custom exception
////				throw new com.AI.exceptions.BrowserInvocationFailedException("Please check the capabilities of the browser");
////			}
////		}
////	}
////
