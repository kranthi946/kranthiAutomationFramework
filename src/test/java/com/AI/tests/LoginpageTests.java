package com.AI.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import driver.DriverManager;

public class LoginpageTests  extends BaseTest{

	private  LoginpageTests() {

	}
	@Test


	public void test1() {


		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation",Keys.ENTER);


	}

	@Test


	public void test2() {


		DriverManager.getDriver().findElement(By.name("q")).sendKeys("testng",Keys.ENTER);


	}


	
	

}
