package com.AI.pages;

import com.AI.enums.WaitStrategy;
import org.openqa.selenium.By;

public class AtlasMainUrlPage extends Basepage {

    By cookies = By.xpath("//button[@id = 'onetrust-accept-btn-handler']");

    By signinlink = By.xpath("//button[@class='btn btn-link']");




    public AtlasMainUrlPage mainpagecookies() throws InterruptedException {

        Thread.sleep(1000);
        cookies(cookies, WaitStrategy.CLICKABLE);

        System.out.println("cookies clicked");

        driver.DriverManager.getDriver().navigate().refresh();

        Thread.sleep(5000);
        return  this ;
    }



    public AtlasSignPage signinapp() throws InterruptedException {




        System.out.println(" signin link clicking");

        Thread.sleep(3000);
        signinpage(signinlink, WaitStrategy.CLICKABLE, driver.DriverManager.getDriver());

        return  new AtlasSignPage() ;




    }

}
