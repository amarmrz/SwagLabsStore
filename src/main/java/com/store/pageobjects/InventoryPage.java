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

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement AddProductBtn;

	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	private WebElement AddProductBtn1;

	@FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
	private WebElement AddProductBtn2;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement Busket;

	@FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
	private WebElement BusketBudges;

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

	}

	public void ClickOnProducts() throws InterruptedException {
		action.click(getDriver(), AddProductBtn);
		Thread.sleep(1000);
		action.click(getDriver(), AddProductBtn1);
		Thread.sleep(1000);
		action.click(getDriver(), AddProductBtn2);
		Thread.sleep(1000);
	}

	public CartPage ClickOnBusket() {
		action.click(getDriver(), Busket);
		return new CartPage();
	}

	public int getBusketProductNumber() {
		int Nbr = Integer.parseInt(BusketBudges.getText());
		return Nbr;
	}
}
