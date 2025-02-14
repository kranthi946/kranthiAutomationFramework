package com.AI.pages;

import com.AI.enums.WaitStrategy;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class AtlasContinuePage extends Basepage {



    By Continuebutton = By.xpath("//button[@class = 'px-5 btn bg-red text-white']");













    public AtlasCompleteYourRegistration continuebutton() throws InterruptedException {


        driver.DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        click(Continuebutton, WaitStrategy.CLICKABLE);


        return new AtlasCompleteYourRegistration();
    }









}
