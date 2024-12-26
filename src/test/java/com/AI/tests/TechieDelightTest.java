package com.AI.tests;





import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.AI.pages.TechiedelightPage;

public class TechieDelightTest extends BaseTest {   // BaseTest will call the browser ., it will have Before method (setUP ) and After method (QUIT )
	
	
	
	@Test(retryAnalyzer = com.AI.listeners.RetryTestCases.class , groups = "regression")   // if we specify the listener here in test level we dont need to do in global suite xml level 
	
	// @Parameters("browser")   - if we pass here we need to pass it from xml no method required from property to basetest 
	public void getalllinks() {
		
		 new TechiedelightPage().gettext();
		
		
		
	}

	
@Test(retryAnalyzer = com.AI.listeners.RetryTestCases.class,groups = {"smoke","sanity"} )   // if we specify the listener here in test level we dont need to do in global suite xml level 
	
	// @Parameters("browser")   - if we pass here we need to pass it from xml no method required from property to basetest 
	public void getalllinks1() {
		
	
	System.out.print("getlinks1");
		 new TechiedelightPage().gettext();
		
		
		
	}
	

}
