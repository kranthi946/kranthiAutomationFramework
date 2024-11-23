package com.AI.tests;

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
		Assert.assertTrue(false);
		np.enterEmail().enterPassword().click();
	}
}
