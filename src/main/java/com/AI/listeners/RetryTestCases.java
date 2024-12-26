package com.AI.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTestCases  implements IRetryAnalyzer{


	int rc = 0 ;
	
	int mrc = 2 ;
	
	
	
	public boolean retry(ITestResult result) {
	
		
		
		if(!result.isSuccess()) {
			
			System.out.println("retry method");
			
			if(rc<mrc) {
				
				
			System.out.println(result.getName() );	
			
			rc++;
			
			return true ;
			}
			
		}
		
		
		return false;
	}

}
