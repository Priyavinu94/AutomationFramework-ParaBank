package com.parasoft.parabank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parasoft.parabank.BasePackage.TestBase;

public class AccountsOverviewPage extends TestBase {

	public AccountsOverviewPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "smallText")
	WebElement customerWelcome;
	
	@FindBy(xpath = "//a[text()='Open New Account']")
	WebElement openNewAccountLink;
	
	@FindBy(xpath = "//a[text()='Transfer Funds']")
	WebElement transferFundsLink;
	
	@FindBy(xpath = "//table[@id='accountTable']//tbody//tr[1]//td[1]//a")
	WebElement initialAccountNumber;
	
	@FindBy(xpath = "//table[@id='accountTable']//tbody//tr[2]//td[1]//a")
	WebElement newAccountNumber;
	
	public String getCustomerName() {
		return customerWelcome.getText().substring(8);
	}
	
	public String getInitialAccountNo() {
		return initialAccountNumber.getText();
	}
	
	public String getNewAccountNo() {
		return newAccountNumber.getText();
	}
	
	public OpenNewAccountPage clickOpenNewAccount() {
		openNewAccountLink.click();
		return new OpenNewAccountPage();
	}
	
	public TransferFundsPage clickTransferFunds() {
		transferFundsLink.click();
		return new TransferFundsPage();
	}
	
}
