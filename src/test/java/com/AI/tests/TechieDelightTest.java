package com.AI.tests;



import org.testng.annotations.Test;

import com.AI.pages.TechiedelightPage;

public class TechieDelightTest extends BaseTest {   // BaseTest will call the browser ., it will have Before method (setUP ) and After method (QUIT )
	
	
	
	@Test
	public void getalllinks() {
		
		 new TechiedelightPage().gettext();
		
		
		
	}

	

}
