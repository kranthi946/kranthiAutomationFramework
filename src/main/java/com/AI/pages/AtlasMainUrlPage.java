package com.AI.pages;

import com.AI.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AtlasMainUrlPage extends Basepage {

    By cookies = By.xpath("//button[@id=\"onetrust-accept-btn-handler\"]");

    By signinlink = By.xpath("//button[@class='btn btn-link']");




    public AtlasMainUrlPage mainpagecookies() throws InterruptedException {


        System.out.println("cookies clicking");


        cookies(cookies, WaitStrategy.CLICKABLE);

        System.out.println("cookies clicked");

        driver.DriverManager.getDriver().navigate().refresh();

        Thread.sleep(5000);

        return  this ;
    }



    public AtlasSignPage signinapp() throws InterruptedException {




        System.out.println(" signin link clicking");

        Thread.sleep(8000);
        signinpage(signinlink, WaitStrategy.CLICKABLE, driver.DriverManager.getDriver());

        return  new AtlasSignPage() ;




    }

}
