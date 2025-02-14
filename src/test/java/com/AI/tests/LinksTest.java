package com.AI.tests;


import com.AI.pages.DemoPagelinks;
import org.testng.annotations.Test;

@Test
public class LinksTest extends BaseTest{



    public void testlinks(){

        DemoPagelinks dpl = new DemoPagelinks();

        dpl.getLinks();
    }



    }

