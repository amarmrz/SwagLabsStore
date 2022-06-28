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
public class LoginPageTest extends BaseClass {
	private InventoryPage InventoryPage;
	private LoginPage loginPage;

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
	public void loginTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("loginTest");
		loginPage = new LoginPage();
		Log.info("Enter Username and Password");
		InventoryPage = loginPage.login(uname, pswd);
		String actualURL = InventoryPage.getCurrURL();
		String expectedURL = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is Sucess");
		Log.endTestCase("loginTest");
	}
}
