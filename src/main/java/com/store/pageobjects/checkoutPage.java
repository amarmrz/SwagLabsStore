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
public class checkoutPage extends BaseClass {

	Action action = new Action();

	@FindBy(id = "first-name")
	private WebElement FirstName;

	@FindBy(id = "last-name")
	private WebElement LastName;

	@FindBy(id = "postal-code")
	private WebElement PostalCode;

	@FindBy(id = "continue")
	private WebElement ContinueBtn;

	@FindBy(xpath = "//span[@class='title']")
	private WebElement CheckoutTitle;

	public checkoutPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String GetTitle() {
		String title = CheckoutTitle.getText();
		return title;
	}

	public checkoutTwoPage ClickOnContinue(String Fname, String Lname, String Pcode) throws Throwable {
		action.type(FirstName, Fname);
		action.type(LastName, Lname);
		action.type(PostalCode, Pcode);
		action.click(getDriver(), ContinueBtn);
		return new checkoutTwoPage();
	}

}
