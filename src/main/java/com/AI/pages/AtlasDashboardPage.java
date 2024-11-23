package com.AI.pages;

public class AtlasDashboardPage {




    public void atlasdashboardpage() throws InterruptedException {

        driver.DriverManager.getDriver().navigate().refresh();


        Thread.sleep(3000);
        System.out.println("driver navigated to dashboard page");


    }
}
