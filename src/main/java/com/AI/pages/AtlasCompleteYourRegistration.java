package com.AI.pages;

import com.AI.enums.WaitStrategy;
import org.openqa.selenium.By;

public class AtlasCompleteYourRegistration extends Basepage{



    By skip = By.xpath("//span[@class='hint px-4']/child::a");


    By alertconfirmskipbutton = By.xpath("//button[@id='btnSkip']");




    public AtlasCompleteYourRegistration skipbuttonclick() throws InterruptedException {

Thread.sleep(3000);
        skipbutton(skip, WaitStrategy.CLICKABLE);

        return this;
    }




    public  AtlasDashboardPage  alertconfirmationtolforskip() throws InterruptedException {


        Thread.sleep(3000);

        confirmskip(alertconfirmskipbutton, WaitStrategy.PRESENCE,10, driver.DriverManager.getDriver());



        return new AtlasDashboardPage();

    }

}
