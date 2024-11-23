package com.AI.Reports;

import java.io.IOException;

import com.AI.constants.FrameworkConstants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReport {   // Main intention was not use test reports in page classes. so for reports we will use in page classes not in base page again . 

    private ExtentReport(){}

    public static ExtentReports extent;
    public static ExtentTest extentTest; //loginTest is not thread safe

// Before suite we will use this . 
    public static void initReports(){
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getReportPath());  // here we will give index.html path
        extent.attachReporter(spark);

    }

    
    // After suite we use this method
    public static void flushReports() throws IOException{
        extent.flush();
        
        // Automatically browser will open 
       // Desktop.getDesktop().browse(new File(FrameworkConstants.getReportPath()).toURI()); 
    }

    public static void createTest(String testCaseName){
        extentTest = extent.createTest(testCaseName);   // for every test case name we wil give here
        ExtentManager.setExtentTest(extentTest);
        
    }

    public static void assignAuthor(String author){
        ExtentManager.getExtentTest().assignAuthor(author);
    }

}
