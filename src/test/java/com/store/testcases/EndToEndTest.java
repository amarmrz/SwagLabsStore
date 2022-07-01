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
public class EndToEndTest extends BaseClass {

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

	@Test(groups = { "Smoke", "Regression" }, dataProvider = "Info", dataProviderClass = DataProviders.class)
	public void endToEndTest(String Fname, String Lname, String Pcode) throws Throwable {
		Log.startTestCase("endToEndTest");
		loginPage = new LoginPage();
		Log.info("Enter Username and Password");
		inventoryPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("User loged in");
		Log.info("User Selecting Products");
		inventoryPage.ClickOnProducts();
		Log.info("Verify if Busket get Updated");
		int ActualResult = inventoryPage.getBusketProductNumber();
		int ExpectedResult = 3;
		Assert.assertEquals(ActualResult, ExpectedResult);
		Log.info("Busket Reflect Correctly with the Selected Products");
		Log.endTestCase("endToEndTest");
	}

}
