package com.AI.pages;

import com.AI.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;
import driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class Basepage {





	public void confirmskip(By by, WaitStrategy waitStrategy, int customTimeout, WebDriver driver) {
		// Check if the alert-like modal is present
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(customTimeout));

			// Wait for the alert modal to be visible (this can be an actual alert-like pop-up, not a browser alert)
			WebElement alertElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			System.out.println("Alert-like pop-up is present: " + alertElement.getText());

			// Now that the alert modal is visible, we can click the skip button inside the modal
			WebElement skipButton = wait.until(ExpectedConditions.elementToBeClickable(by));
			skipButton.click();  // Click the skip button inside the alert modal

			System.out.println("Skip button clicked, alert-like pop-up dismissed");

		} catch (TimeoutException e) {
			// If the alert modal or skip button isn't found within the timeout period
			System.out.println("No alert-like pop-up found within the timeout period.");
		}
	}








	public void 	skipbutton(By by, WaitStrategy waitStrategy){

		click(by , waitStrategy);
	}
	public void 	cookies(By by, WaitStrategy waitStrategy){

		click(by , waitStrategy);
	}







	public void 	signinpage(By by, WaitStrategy waitStrategy, WebDriver driver){

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));

		if (element.isDisplayed() && element.isEnabled()) {
			// If both conditions are true, click the element
			element.click();
		} else {
			// If either condition fails, log or handle the failure as needed
			if (!element.isDisplayed()) {
				System.out.println("Element is not displayed");
			}
			if (!element.isEnabled()) {
				System.out.println("Element is not enabled");
			}


		}
	}









public void 	username(By by , String value , WaitStrategy waitStrategy){
	sendkeys(by,value,waitStrategy);



}

	public void password(By by , String value , WaitStrategy waitStrategy){

		sendkeys(by,value,waitStrategy);
	}

public void 	signinbutton(By by, WaitStrategy waitStrategy){

	click(by , waitStrategy);
}



	public void 	continuebutton(By by, WaitStrategy waitStrategy){

		click(by , waitStrategy);
	}



	public void select(By by, WaitStrategy waitStrategy, int customWait, WebDriver driver) throws InterruptedException {
		// Explicit wait for the element to be clickable
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);

		// Wait until the element is clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(customWait));
		wait.until(ExpectedConditions.elementToBeClickable(by));
		element.click();

		// Check if an alert is present after clicking
		if (isAlertPresent(waitStrategy, customWait, driver)) {
			try {
				// Wait for the alert to be present
				WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(customWait));
				alertWait.until(ExpectedConditions.alertIsPresent());

				// If alert is present, handle it
				Alert alert = driver.switchTo().alert();
				System.out.println("Alert Text: " + alert.getText());
				System.out.println("Alert is present");
				alert.accept();  // Accept the alert
				System.out.println("Alert accepted");
			} catch (NoAlertPresentException e) {
				System.out.println("No alert present after button click.");
			}
		}
	}


	public void selectMultiple(By by, WaitStrategy waitStrategy, int customTimeout, WebDriver driver) throws InterruptedException {
		// Find all buttons matching the given locator
		List<WebElement> locb = DriverManager.getDriver().findElements(by);

		System.out.println("Total buttons: " + locb.size());

		// Iterate over all the buttons
		for (int i = 0; i < locb.size(); i++) {  // Change from i = 1 to i = 0 to process the first button
			// XPath for each button in the list (use the index to identify each button)
			By buttonsXPath = By.xpath("//div[@class='col-12 mt-4 col-md-6']//descendant::button[" + (i + 1) + "]"); // i+1 for 1-based XPath index

			// Wait for the button to be clickable using the explicit wait
			WebElement cb = ExplicitWaitFactory.performExplicitWait(waitStrategy, buttonsXPath);

			System.out.println("Button Text: " + cb.getText());  // Log the text of the button

			try {
				// Click the button
				cb.click();

				// Check if an alert is present after clicking
				if (isAlertPresent(waitStrategy, customTimeout, driver)) {
					try {
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
						wait.until(ExpectedConditions.alertIsPresent());
						// If alert is present, handle it
						Alert alert = driver.switchTo().alert();
						System.out.println("Alert Text: " + alert.getText());
						System.out.println("Alert is present");
						alert.accept();  // Accept the alert
						System.out.println("Alert accepted");
					} catch (NoAlertPresentException e) {
						System.out.println("No alert present after button click.");
					}
				}
			} catch (Exception e) {
				// Log any exceptions that occur while interacting with the button
				System.out.println("Error interacting with button at index " + i + ": " + e.getMessage());
			}
		}
	}

	public List<WebElement> getLinksText(By by) {
		List<WebElement> li = driver.DriverManager.getDriver().findElements(By.tagName("a"));
		int count = li.size();
		System.out.println("Total number of links " + count);
		// ExtentManager.getExtentTest().pass("Total no of links is "  + count);
		/**
		 * for(int i=0; i<li.size();i++)
		 * {
		 * System.out.println(li.get(i).getText());
		 * }
		 */
		//li.forEach(e -> System.out.println(e.getText()));
		return li;
	}

	public void sendkeys(By by , String value , WaitStrategy waitStrategy ) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.sendKeys(value);
	}

	public void click(By by, WaitStrategy waitStrategy) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.click();
	}


	public void validateRemoveElements(int noOfClicks, WebDriver driver) throws InterruptedException {
		List<WebElement> removeElementBtns = driver.findElements(By.cssSelector("button.added-manually"));
		for (int i = 0; i < removeElementBtns.size(); i++) {
			removeElementBtns.get(i).click();
			Thread.sleep(2000);
		}
	}

	public void validateAddElements(int noOfClicks, WebDriver driver) {
		WebElement addElementBtn = driver.findElement(By.xpath("//button[contains(text(),'Add Element')]"));
		for (int i = 0; i < noOfClicks; i++) {
			addElementBtn.click();
		}
		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='elements']/button"));
		Assert.assertEquals(noOfClicks, elements.size());
	}

	public boolean isAlertPresent(WaitStrategy waitStrategy, int customTimeout, WebDriver driver) {
		try {
			// Use customTimeout in seconds and create a WebDriverWait with the custom timeout
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(customTimeout));

			// Wait until the alert is present
			wait.until(ExpectedConditions.alertIsPresent());
			return true;  // Alert is present
		} catch (TimeoutException e) {
			System.out.println("Alert is not present");
			return false;
		}
	}

	public void acceptAlert(WaitStrategy waitstartegy , int customTimeout, WebDriver driver) {
		if (isAlertPresent(waitstartegy, customTimeout, driver)) {
			Alert al = driver.switchTo().alert();
			al.accept();
		} else {
			System.out.println("Alert not present");
		}
	}

	public void dismissAlert(WaitStrategy waitstartegy , int customTimeout, WebDriver driver) {
		if (isAlertPresent(waitstartegy, customTimeout, driver)) {
			Alert al = driver.switchTo().alert();
			al.dismiss();
		} else {
			System.out.println("Alert not present");
		}
	}

	public String getAlertText(WaitStrategy waitstartegy , int customTimeout, WebDriver driver) {
		if (isAlertPresent(waitstartegy, customTimeout, driver)) {
			Alert al = driver.switchTo().alert();
			String temptxt = al.getText().trim();
			al.accept();
			if (temptxt.length() > 0) {
				return temptxt;
			}
			return null;
		} else {
			System.out.println("Alert not present");
		}
		return null;
	}

	public void checkBox(By by , WaitStrategy waitStrategy ) {
		List<WebElement> checkboxes = driver.DriverManager.getDriver().findElements(by);
		checkboxes.size();
		System.out.println("count of checkboxes " + checkboxes.size());

		for (WebElement checkbox : checkboxes) {
			System.out.println("is this selected " + checkbox.isSelected());
			if (!checkbox.isSelected()) {
				checkbox.click();
			}
		}
	}

	public void forTextToBePresent(String text, int customTimeOut) {
		text = text.trim();
		int count = 0;
		boolean flag = false;

		do {
			if (driver.DriverManager.getDriver().getPageSource().contains(text)) {
				flag = true;
				break;
			} else {
				count++;
			}
		} while (count < customTimeOut);

		if (!flag) {
			throw new TimeoutException("Search text not found on the webpage after timeout period of " + customTimeOut + " secs");
		}
	}
}
