package com.AI.pages;

import org.openqa.selenium.By;

import com.AI.enums.WaitStrategy;

public class NopCommercepage extends Basepage{

	By email = By.xpath("//input[@id='Email']");
	
	

	By Password = By.xpath("//input[@id='Password']");

	By button = By.xpath("//button[contains(text(),'Log in')]" );


	
	
		// sendkeys(BY by , String value ,WaitStrategy waitstrategy ){
	
	
	

	
	public  NopCommercepage   enterEmail() throws Throwable {
	

		sendkeys(email, "kranthi20231@mailinator.com", WaitStrategy.PRESENCE);
		return this ;
	}

	public  NopCommercepage enterPassword() {
		sendkeys(Password , "Test@1234", WaitStrategy.PRESENCE);
		return this;
	}


	public NopCommerceHomePage	click(){
		click(button , WaitStrategy.CLICKABLE);
		return new NopCommerceHomePage() ;
	}

	

















}






























