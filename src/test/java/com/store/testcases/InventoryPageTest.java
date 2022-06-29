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
import com.store.pageobjects.InventoryPage;
import com.store.pageobjects.LoginPage;
import com.store.utility.Log;

/**
 * @author Amar
 *
 */
public class InventoryPageTest extends BaseClass {
	private LoginPage loginPage;
	private InventoryPage inventoryPage;

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
	public void ValidateLogo(String uname, String pswd) throws Throwable {
		Log.startTestCase("Validate Logo Test");
		loginPage = new LoginPage();
		Log.info("Enter Username and Password");
		inventoryPage = loginPage.login(uname, pswd);
		Log.info("User loged in");
		Log.info("Validate Availability of Logo");
		Boolean result = inventoryPage.validateLogo();
		Assert.assertTrue(result);
		Log.info("Logo displayed fine");
		Log.endTestCase("ValidateManuTest");
	}

	@Test(groups = { "Smoke", "Regression" }, dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void ValidateManu(String uname, String pswd) throws Throwable {
		Log.startTestCase("Validate Manu Test");
		loginPage = new LoginPage();
		Log.info("Enter Username and Password");
		inventoryPage = loginPage.login(uname, pswd);
		Log.info("User loged in");
		Log.info("Validate Availability of Manu Button");
		Boolean result = inventoryPage.ValidateManu();
		Assert.assertTrue(result);
		Log.info("Manu displayed fine");
		Log.endTestCase("ValidateManuTest");

	}

}
