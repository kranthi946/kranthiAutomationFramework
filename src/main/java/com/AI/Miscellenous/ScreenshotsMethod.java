package com.AI.Miscellenous;

import driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotsMethod {










public static void takescreenshotmethod(){
    WebDriver driver  = DriverManager.getDriver();


    if(driver == null) {

        throw new RuntimeException("webdriver is not available");
    }
System.out.println("taking screenshot");
    String  timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());




    File sf = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

    File df = new File("test-output/screenshots/" + timestamp + ".png");

        try {
        FileUtils.copyFile(sf ,df);
        System.out.println(df.getAbsolutePath());
    } catch (
    IOException e) {
        throw new RuntimeException(e);
    }

}
}

