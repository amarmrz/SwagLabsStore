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
public class checkoutTwoPage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//div[@class='summary_subtotal_label']")
	private WebElement ItemPrice;

	@FindBy(xpath = "//div[@class='summary_total_label']")
	private WebElement TotalPrice;

	@FindBy(id = "finish")
	private WebElement FinishBtn;

	public checkoutTwoPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public double getUnitPrice() {
		String unitPrice1 = ItemPrice.getText();
		String unit = unitPrice1.replaceAll("[^0-9]", "");
		double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice / 100;
	}

	public double getTotalPrice() {
		String unitPrice1 = TotalPrice.getText();
		String unit = unitPrice1.replaceAll("[^0-9]", "");
		double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice / 100;
	}

	/**
	 * public double ClickOnFinish() { String unitPrice1 = unitPrice.getText();
	 * String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]", ""); double
	 * finalUnitPrice = Double.parseDouble(unit); return finalUnitPrice / 100; }
	 */

}
