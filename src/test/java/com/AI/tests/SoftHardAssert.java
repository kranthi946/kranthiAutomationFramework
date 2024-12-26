package com.AI.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class SoftHardAssert {
	
	
SoftAssert sa = new SoftAssert();
	
	

    @Test
    public void login() {
        // Step 1: Open the browser
        System.out.println("Step 1: Opening the browser...");
        
	//	Assert.assertEquals(true, false);  //hard assertion   if it fails , the next steps wont run or executed.


        // Step 2: Load the URL
        System.out.println("Step 2: Loading the URL...");

        // Step 3: Enter username
        System.out.println("Step 3: Entering the username...");

        // Step 4: Enter password
        System.out.println("Step 4: Entering the password...");

        // Step 5: Click the sign-in button
        System.out.println("Step 5: Clicking the Sign-In button...");
        
        
       // Assert.assertEquals(true, false);

        // Step 6: End of the login process
        
        
        System.out.println("Step 6: Login process completed.");
        
        
        sa.assertEquals(true ,false);
        
      //  Assert.assertEquals(true, false);
        //step 7 : validate homepage



        sa.assertEquals(true ,false , "homepage title missing");
        System.out.println("step 7 : validate homepage");   // see if homepage title not coming means we can still find more number of bugs as in manual testing


        //see your 2 test cases got fail then if we perform assert all , then it will consider all failures and give fail rate



        sa.assertEquals(true ,false , "links missing");
        System.out.println("step 8 : validate links");
        sa.assertAll();  // without this  your test case will fail .
        
    }
		  
		  
		
		
	  
	   
	


}
