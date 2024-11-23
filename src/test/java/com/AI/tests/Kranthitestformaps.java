package com.AI.tests;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.AI.utils.DataProviderUtils;

import driver.DriverManager;


@Test
public class Kranthitestformaps  extends BaseTest {

	
	
	
	

	@Test(dataProvider = "testDataProvider", dataProviderClass = DataProviderUtils.class)


	public void test1(Map<String, String> k) {

		// Accessing the test data from Excel

		String x = k.get("searchQuery");

		DriverManager.getDriver().findElement(By.name("q")).sendKeys(x, Keys.ENTER);
	}

	@Test(dataProvider = "testDataProvider", dataProviderClass = DataProviderUtils.class)
	public void test2(Map<String, String> testData) {
		// Accessing the test data from Excel
		String searchQuery = testData.get("searchQuery");

		DriverManager.getDriver().findElement(By.name("q")).sendKeys(searchQuery, Keys.ENTER);
	}
}
