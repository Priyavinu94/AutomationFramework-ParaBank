package com.parasoft.parabank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.parasoft.parabank.BasePackage.TestBase;

public class TransferFundsPage extends TestBase {

	public TransferFundsPage() {

		PageFactory.initElements(driver, this);
	}

	Select select;

	@FindBy(className = "title")
	WebElement transferFundsFormTitle;
	
	@FindBy(id = "amount")
	WebElement transferAmountInput;

	@FindBy(id = "fromAccountId")
	WebElement fromAccountDropdown;

	@FindBy(id = "toAccountId")
	WebElement toAccountDropdown;

	@FindBy(xpath = "//input[@class='button']")
	WebElement transferButton;
	
	@FindBy(xpath = "//div[@ng-if='showResult']//h1[@class='title']")
	WebElement transferSuccessMessage;
	
	public void enterTransferAmount(String transferAmount) {
		transferAmountInput.sendKeys(transferAmount);
	}

	public void selectFromAccount(String fromAccount) {
		select = new Select(fromAccountDropdown);
		select.selectByValue(fromAccount);
	}

	public void selectToAccount(String toAccount) {
		select = new Select(toAccountDropdown);
		select.selectByValue(toAccount);
	}
	
	public String getFormTitle() {
		return transferFundsFormTitle.getText();
	}
	
	public TransferFundsPage submitTransfer() {
		transferButton.submit();
		return new TransferFundsPage();
	}
	
	public String getSuccessMessage() {
		return transferSuccessMessage.getText();
	}
}
