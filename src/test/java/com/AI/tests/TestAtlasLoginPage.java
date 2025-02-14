package com.AI.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import com.AI.pages.AtlasMainUrlPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.util.List;

public class TestAtlasLoginPage extends BaseTest {



        @Test
        public void testAtlasLogin() throws InterruptedException {
            // Get the WebDriver instance from DriverManager (it will be set up in BaseTest)
           // WebDriver driver = DriverManager.getDriver();

            // Initialize the page object with the WebDriver
            AtlasMainUrlPage amp = new AtlasMainUrlPage();

            // Perform the necessary actions on the page using the page object model
            amp
                    .signinapp()
                    .signinpagecookies()
                    .login()
                    .continuebutton()
                    .skipbuttonclick()
                    .alertconfirmationtolforskip()
                    .atlasdashboardpage();


        }

}