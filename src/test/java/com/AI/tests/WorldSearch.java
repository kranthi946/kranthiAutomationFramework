package com.AI.tests;
import org.testng.annotations.Test;

import com.AI.pages.WorldsearchEU;

public class WorldSearch extends BaseTest {

    @Test
    public void doworldsearch() throws Throwable {
        WorldsearchEU ws = new WorldsearchEU();
        ws.acceptcookies().closebutton().selectcountryandsearchresult();
    }
}
