package com.AI.pages;

import org.testng.Assert;

public class AtlasDashboardPage {




    public void atlasdashboardpage() throws InterruptedException {


        Thread.sleep(3000);
        driver.DriverManager.getDriver().navigate().refresh();

        Thread.sleep(5000);

        System.out.println("Dashboard Title: " +  driver.DriverManager.getDriver().getTitle()  );
        System.out.println("Dashboard Url: " +  driver.DriverManager.getDriver().getCurrentUrl() );


       String t =  driver.DriverManager.getDriver().getTitle();
       System.out.println(t);
        Assert.assertEquals(t , "Dashboard" ,"dashboard page of Atlas");


        Thread.sleep(3000);
        System.out.println("driver navigated to dashboard page");

   Thread.sleep(5000);



    }
}
