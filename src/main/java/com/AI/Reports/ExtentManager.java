package com.AI.Reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    private ExtentManager(){}

    private static final ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();

   public static ExtentTest getExtentTest(){   // here we can put private static ExtentTest getExtentTest (){} in order to avoid methods exposing to user and hiding the methods . we using default  private package
        return threadLocal.get();
    }

 public   static void setExtentTest(ExtentTest test){
        threadLocal.set(test);

    }


	
}

