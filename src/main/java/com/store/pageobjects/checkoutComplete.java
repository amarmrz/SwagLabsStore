package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondriver.Action;
import com.store.base.BaseClass;

public class checkoutComplete extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//h2[@class='complete-header']")
	private WebElement TitleCheckout;

	public checkoutComplete() {
		PageFactory.initElements(getDriver(), this);
	}

	public String getConfirmationTitle() {
		String Title = TitleCheckout.getText();
		return Title;
	}
}
