package com.parasoft.parabank.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.parasoft.parabank.BasePackage.TestBase;
import com.parasoft.parabank.Pages.AccountsOverviewPage;
import com.parasoft.parabank.Pages.HomePage;
import com.parasoft.parabank.Pages.OpenNewAccountPage;

public class OpenAccountPageTest extends TestBase {

	HomePage homePage;
	AccountsOverviewPage accountPage;
	OpenNewAccountPage openNewAccountPage;

	@BeforeMethod
	public void openBrowser() {
		intialiseDriver();
		homePage = new HomePage();
	}

	@Test
	public void verifyUserCanOpenNewAccount() {

		homePage.enterUsernameToLogin(prop.getProperty("username"));
		homePage.enterPasswordToLogin(prop.getProperty("password"));

		accountPage = homePage.customerLogin();

		String customerFullname = accountPage.getCustomerName();
		String initialAccountNo = accountPage.getInitialAccountNo();
		Assert.assertEquals(customerFullname, prop.getProperty("firstName") + " " + prop.getProperty("lastName"));
		
		openNewAccountPage = accountPage.clickOpenNewAccount();
		Assert.assertEquals(openNewAccountPage.getFormTitle(),"Open New Account");
		
		openNewAccountPage.selectAccountType(prop.getProperty("newAccountType"));
		openNewAccountPage.selectTransferFromAccount(initialAccountNo);
		openNewAccountPage = openNewAccountPage.clickOpenNewAccButton();
			
		String newMessage = openNewAccountPage.getSuccessMessage();
		Assert.assertEquals(newMessage, "Account Opened!", "Account not successfully opened");
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
