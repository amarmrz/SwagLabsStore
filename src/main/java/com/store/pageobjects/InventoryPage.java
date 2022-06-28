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

	@FindBy(id = "item_4_img_link")
	private WebElement product;

	public InventoryPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean validateLogo() throws Throwable {
		return action.isDisplayed(getDriver(), logo);
	}

	public String getMyStoreTitle() {
		String myStoreTitel = getDriver().getTitle();
		return myStoreTitel;
	}

	public String getCurrURL() throws Throwable {
		String homePageURL = action.getCurrentURL(getDriver());
		return homePageURL;
	}

}
