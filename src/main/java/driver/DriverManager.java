package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	// A static WebDriver instance for the current thread
	private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

	// Get the WebDriver instance for the current thread
	public static WebDriver getDriver() {
		return driverThreadLocal.get();
	}

	// Set the WebDriver instance for the current thread
	public static void setDriver(WebDriver driver) {
		driverThreadLocal.set(driver);
	}

	// Clean up (quit driver) when the test ends
	public static void unload() {
		WebDriver driver = driverThreadLocal.get();
		if (driver != null) {
			driver.quit();
			driverThreadLocal.remove();
		}
	}
}
