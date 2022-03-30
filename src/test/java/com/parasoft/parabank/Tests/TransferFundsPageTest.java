package com.parasoft.parabank.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.parasoft.parabank.BasePackage.TestBase;
import com.parasoft.parabank.Pages.AccountsOverviewPage;
import com.parasoft.parabank.Pages.HomePage;
import com.parasoft.parabank.Pages.TransferFundsPage;

public class TransferFundsPageTest extends TestBase{
	
	HomePage homePage;
	AccountsOverviewPage accountPage;
	TransferFundsPage transferFundsPage;

	@BeforeMethod
	public void openBrowser() {
		intialiseDriver();
		homePage = new HomePage();
	}
	
	@Test
	public void verifyUserCanTransferFunds() {
		
		homePage.enterUsernameToLogin(prop.getProperty("username"));
		homePage.enterPasswordToLogin(prop.getProperty("password"));

		accountPage = homePage.customerLogin();

		String customerFullname = accountPage.getCustomerName();
		String initialAccountNo = accountPage.getInitialAccountNo();
		String newAccountNo = accountPage.getNewAccountNo();
		Assert.assertEquals(customerFullname, prop.getProperty("firstName") + " " + prop.getProperty("lastName"));
		
		transferFundsPage = accountPage.clickTransferFunds();
		Assert.assertEquals(transferFundsPage.getFormTitle(),"Transfer Funds");
		
		transferFundsPage.enterTransferAmount(prop.getProperty("transferAmount"));
		transferFundsPage.selectFromAccount(initialAccountNo);
		transferFundsPage.selectToAccount(newAccountNo);
		transferFundsPage = transferFundsPage.submitTransfer();
		
		String newMessage = transferFundsPage.getSuccessMessage();
		Assert.assertEquals(newMessage, "Transfer Complete!", "Transfer not successfully completed");
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
