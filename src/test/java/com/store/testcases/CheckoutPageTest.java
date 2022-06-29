package com.store.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.store.base.BaseClass;
import com.store.dataprovider.DataProviders;
import com.store.pageobjects.CartPage;
import com.store.pageobjects.InventoryPage;
import com.store.pageobjects.LoginPage;
import com.store.pageobjects.checkoutPage;
import com.store.utility.Log;

public class CheckoutPageTest extends BaseClass {

	private LoginPage loginPage;
	private InventoryPage inventoryPage;
	private CartPage cartPage;
	private checkoutPage checkoutPage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Regression" })
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = { "Smoke", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups = { "Smoke", "Regression" }, dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void VerifyCheckOutTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("VerifyCheckOutTest");
		loginPage = new LoginPage();
		Log.info("Enter Username and Password");
		inventoryPage = loginPage.login(uname, pswd);
		Log.info("User loged in");
		Log.info("User Clicked on Product");
		inventoryPage.ClickOnProduct();
		Log.info("User Clicked Busket");
		cartPage = inventoryPage.ClickOnBusket();
		Log.info("User Clicked on Product");
		checkoutPage = cartPage.ClickOnCheckout();
		String actualTitle = checkoutPage.GetTitle();
		Assert.assertEquals(actualTitle, "CHECKOUT: YOUR INFORMATION");
		Log.info("Title 'Checkout: Your Information' displayed fine");
		Log.endTestCase("VerifyCheckOutTest");
	}

}
