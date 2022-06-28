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
 * @author Hitendra
 *  
 */
public class LoginPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(id="user-name")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement password;

	@FindBy(id="login-button")
	private WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public InventoryPage login(String uname, String pswd) throws Throwable {
		action.type(userName, uname);
		action.type(password, pswd);
		action.JSClick(getDriver(), loginBtn);
		Thread.sleep(2000);
		return new InventoryPage();
	}
	
}






