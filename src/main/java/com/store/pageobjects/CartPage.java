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
public class CartPage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//span[@class='title']")
	private WebElement Title;

	@FindBy(id = "checkout")
	private WebElement CheckoutBtn;

	public CartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean validateTitle() throws Throwable {
		return action.isDisplayed(getDriver(), Title);
	}

	public checkoutPage ClickOnCheckout() throws Throwable {
		action.click(getDriver(), CheckoutBtn);
		return new checkoutPage();
	}
}
