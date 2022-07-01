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
import com.store.pageobjects.checkoutComplete;
import com.store.pageobjects.checkoutPage;
import com.store.pageobjects.checkoutTwoPage;
import com.store.utility.Log;

public class CheckoutCompleteTest extends BaseClass {
	private LoginPage loginPage;
	private InventoryPage inventoryPage;
	private CartPage cartPage;
	private checkoutPage checkoutPage;
	private checkoutTwoPage checkoutPageTwo;
	private checkoutComplete checkoutComplete;

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
	public void ValidateOrderConfirmationTest(String Fname, String Lname, String Pcode) throws Throwable {
		Log.startTestCase("ValidateOrderConfirmation");
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
		Log.info("User is going to Finish Order");
		checkoutComplete = checkoutPageTwo.ClickOnFinish();
		Log.info("Validating Order");
		String ActualTitle = checkoutComplete.getConfirmationTitle();
		Assert.assertEquals(ActualTitle, "THANK YOU FOR YOUR ORDER");
		Log.info("Order Is Confirmed Succefully");
		Log.endTestCase("ValidateOrderConfirmation");
	}

}
