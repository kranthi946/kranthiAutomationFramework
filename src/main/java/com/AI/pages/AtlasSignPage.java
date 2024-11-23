package com.AI.pages;

import com.AI.enums.WaitStrategy;
import org.openqa.selenium.By;

public class AtlasSignPage extends Basepage {


    By username =By.xpath("//input[@id='Email']");

    By password =By.xpath("//input[@id='Password']");


    By signin = By.xpath("//button[@id='btnSignIn']");

    By cookies = By.xpath("//button[@id = 'onetrust-accept-btn-handler']");



    public AtlasSignPage signinpagecookies() throws InterruptedException {

        Thread.sleep(5000);
        cookies(cookies, WaitStrategy.CLICKABLE);

        System.out.println("cookies clicked");


        return this ;


    }
    public AtlasContinuePage login() throws InterruptedException {


        Thread.sleep(2000);
        System.out.println("username  passing");
        username(username,"kattakranthikumar333@gmail.com", WaitStrategy.VISIBLE);

        System.out.println("username passed ");
        Thread.sleep(2000);

        System.out.println("password passing ");
        password(password,"Kranthi@333",WaitStrategy.VISIBLE);
        System.out.println("password sent ");

        Thread.sleep(2000);

        System.out.println("signin button next  ");
        signinbutton(signin,WaitStrategy.CLICKABLE);

        System.out.println("sigin button  clicked");
        return new AtlasContinuePage();




    }


}
