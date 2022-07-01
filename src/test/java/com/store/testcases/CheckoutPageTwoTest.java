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
import com.store.pageobjects.checkoutPage;
import com.store.pageobjects.checkoutTwoPage;
import com.store.utility.Log;

/**
 * @author Amar
 *
 */
public class CheckoutPageTwoTest extends BaseClass {
	private LoginPage loginPage;
	private InventoryPage inventoryPage;
	private CartPage cartPage;
	private checkoutPage checkoutPage;
	private checkoutTwoPage checkoutPageTwo;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Regression" })
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = { "Smoke", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups = { "Smoke", "Regression" }, dataProvider = "Info", dataProviderClass = DataProviders.class)
	public void ValidatePriceTest(String Fname, String Lname, String Pcode) throws Throwable {
		Log.startTestCase("ValidatePriceTest");
		loginPage = new LoginPage();
		Log.info("Enter Username and Password");
		inventoryPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("User loged in");
		Log.info("User Clicked on Product");
		inventoryPage.ClickOnProduct();
		Log.info("User is going to Click on Busket");
		cartPage = inventoryPage.ClickOnBusket();
		Log.info("User Clicked on Busket");
		checkoutPage = cartPage.ClickOnCheckout();
		Log.info("User is going to Click on Continue");
		checkoutPageTwo = checkoutPage.ClickOnContinue(Fname, Lname, Pcode);
		Log.info("Getting Prices");
		double totalprice = checkoutPageTwo.getTotalPrice();
		double unitprice = checkoutPageTwo.getUnitPrice();
		double ExpectedTotalPrice = unitprice + 2.40;
		Assert.assertEquals(totalprice, ExpectedTotalPrice);
		Log.info("Price Is Correct");
		Log.endTestCase("ValidatePriceTest");
	}
}
