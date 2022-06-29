/**
 * 
 */
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
import com.store.utility.Log;

/**
 * @author Amar
 *
 */
public class CartPageTest extends BaseClass {

	private LoginPage loginPage;
	private InventoryPage inventoryPage;
	private CartPage cartPage;

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
	public void VerifyAddToCartTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("VerifyAddToCartTest");
		loginPage = new LoginPage();
		Log.info("Enter Username and Password");
		inventoryPage = loginPage.login(uname, pswd);
		Log.info("User loged in");
		Log.info("User Clicked on Product");
		inventoryPage.ClickOnProduct();
		Log.info("User Clicked Busket");
		cartPage = inventoryPage.ClickOnBusket();
		Boolean result = cartPage.validateTitle();
		Assert.assertTrue(result);
		Log.info("Title 'your Cart' displayed fine");
		Log.endTestCase("VerifyAddToCartTest");
	}

}
