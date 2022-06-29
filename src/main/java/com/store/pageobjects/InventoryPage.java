/**
 * 
 */
package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondriver.Action;
import com.store.base.BaseClass;

/**
 * @author Amar
 *
 */
public class InventoryPage extends BaseClass {
	Action action = new Action();

	@FindBy(id = "react-burger-menu-btn")
	private WebElement manuBtn;

	@FindBy(xpath = "//div[@class='app_logo']")
	private WebElement logo;

	@FindBy(id="add-to-cart-sauce-labs-backpack")
	private WebElement AddProductBtn;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement Busket;

	// @FindBy(id = "//span[@class='shopping_cart_badge']")
	// private WebElement productBudges;

	public InventoryPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean validateLogo() throws Throwable {
		return action.isDisplayed(getDriver(), logo);
	}

	public boolean ValidateManu() {
		return action.isDisplayed(getDriver(), manuBtn);
	}

	public String getCurrURL() throws Throwable {
		String homePageURL = action.getCurrentURL(getDriver());
		return homePageURL;
	}

	public void ClickOnProduct() {
		action.click(getDriver(), AddProductBtn);
		action.fluentWait(getDriver(), AddProductBtn, 3);
		// verification if budges appeared
	}

	public CartPage ClickOnBusket() {
		action.click(getDriver(), Busket);
		return new CartPage();
	}

}
