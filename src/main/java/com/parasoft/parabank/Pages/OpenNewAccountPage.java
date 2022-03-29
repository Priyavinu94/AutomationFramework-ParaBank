package com.parasoft.parabank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.parasoft.parabank.BasePackage.TestBase;

public class OpenNewAccountPage extends TestBase {

	public Select select;

	public OpenNewAccountPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "title")
	WebElement openAccountTitle;

	@FindBy(id = "type")
	WebElement accTypeDropdown;

	@FindBy(id = "fromAccountId")
	WebElement transferFromAcctDropdown;

	@FindBy(css = "input.button")
	WebElement openNewAccountButton;
	

	@FindBy(xpath = "//div[@ng-if='showResult']//h1[@class='title']")
	WebElement accountOpenSuccessMessage;
	

	public void selectAccountType(String visibleText) {
		select = new Select(accTypeDropdown);
		select.selectByVisibleText(visibleText);
	}
	
	public void selectTransferFromAccount(String value) {
		select = new Select(transferFromAcctDropdown);
		select.selectByValue(value);
	}
	
	public String getOpenAccountTitle() {
		return openAccountTitle.getText();
	}
	
	public OpenNewAccountPage clickOpenNewAccButton() {
		openNewAccountButton.submit();
		return new OpenNewAccountPage();
	}
	
	public String getSuccessMessage() {
		return accountOpenSuccessMessage.getText();
	}
}
