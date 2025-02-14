package com.AI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.DriverManager;
import java.util.List;

public class DemoPagelinks extends Basepage {


    By by = By.xpath("//a[*]");


    public   DemoPagelinks getLinks() {
        List<WebElement> links = driver.DriverManager.getDriver().findElements(By.xpath("//a[*]"));



        System.out.println(links.size());



        for(WebElement link : links) {

            System.out.println(link.getAttribute("href"));


        }


        return this;

    }


}


