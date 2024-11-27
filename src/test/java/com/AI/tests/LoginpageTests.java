package com.AI.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import driver.DriverManager;
import org.testng.annotations.Test;

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
