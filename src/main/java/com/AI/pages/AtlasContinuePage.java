package com.AI.pages;

import com.AI.enums.WaitStrategy;
import org.openqa.selenium.By;

public class AtlasContinuePage extends Basepage {



    By Continuebutton = By.xpath("//button[@class = 'px-5 btn bg-red text-white']");













    public AtlasCompleteYourRegistration continuebutton() throws InterruptedException {


        Thread.sleep(3000);
        click(Continuebutton, WaitStrategy.CLICKABLE);


        return new AtlasCompleteYourRegistration();
    }









}
