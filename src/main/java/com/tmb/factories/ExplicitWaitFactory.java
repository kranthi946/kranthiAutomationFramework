package com.tmb.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.AI.constants.FrameworkConstants;
import com.AI.enums.WaitStrategy;

import driver.DriverManager;

import java.time.Duration;

/**
 * Explicit wait factory produces different waits before operating on webelement
 * 
 * <pre>
 * <b>
 * <a href=
"https://www.youtube.com/channel/UC6PTXUHb6j4Oxf0ccdRI11A">Testing Mini Bytes Youtube channel</a>
 * </b>
 * </pre>
 * 
 * Jan 21, 2021
 * 
 * @author Amuthan Sakthivel
 * @version 1.0
 * @since 1.0
 */
public final class ExplicitWaitFactory {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExplicitWaitFactory() {
	}

	/**
     * @param waitStrategy Strategy to be applied to find a webelement
     *                     {@link WaitStrategy}
     * @param by           By locator of the webelement
     * @return webelement Locates and return the webelement
     * @author Amuthan Sakthivel Jan 21, 2021
     */
	public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {
		WebElement element = null;

		if (waitStrategy == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
					.until(ExpectedConditions.elementToBeClickable(by));
		} else if (waitStrategy == WaitStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} else if (waitStrategy == WaitStrategy.VISIBLE) {
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} else if (waitStrategy == WaitStrategy.NONE) {
			element = DriverManager.getDriver().findElement(by);
		}

		return element;
	}


}
