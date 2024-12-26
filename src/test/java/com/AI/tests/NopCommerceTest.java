package com.AI.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import com.AI.listeners.ListenerClass;
import com.AI.pages.NopCommercepage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerClass.class) // This attaches the custom listener to this test class
public class NopCommerceTest extends BaseTest {

	@Test
	public void ncloginTest() throws Throwable {
		NopCommercepage np = new NopCommercepage();
		AssertJUnit.assertTrue(false);
		np.enterEmail().enterPassword().click();
	}
}
