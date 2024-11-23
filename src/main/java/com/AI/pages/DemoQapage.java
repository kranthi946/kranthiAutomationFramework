package com.AI.pages;

import driver.DriverManager;
import org.openqa.selenium.By;

import com.AI.enums.WaitStrategy;

public class DemoQapage extends Basepage {
	
	
	By clickme = By.xpath("//button[@id=\"alertButton\"]");
	
	By clickmebuttons = By.xpath("//div[@class ='col-12 mt-4 col-md-6']/child::div[2]/child::div/child::div/child::button");

	public void alerttest() throws InterruptedException {

		System.out.println("alert  page , going to click ");

		select(clickme,  WaitStrategy.CLICKABLE , 5, driver.DriverManager.getDriver() );
		
	}

	public void alertbuttonstest() throws InterruptedException {
		System.out.println("multiple alerts clicking method");


		selectMultiple(clickmebuttons, WaitStrategy.CLICKABLE, 6, DriverManager.getDriver());
	}


}
