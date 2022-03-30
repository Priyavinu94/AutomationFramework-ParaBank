package com.parasoft.parabank.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.parasoft.parabank.BasePackage.TestBase;
import com.parasoft.parabank.Pages.CustomerCreatedPage;
import com.parasoft.parabank.Pages.HomePage;

public class CustomerCreatedPageTest extends TestBase {

	HomePage homePage;
	CustomerCreatedPage custAcctPage;

	@BeforeMethod
	public void openBrowser() {
		intialiseDriver();
		homePage = new HomePage();
	}

	@Test
	public void verifyUserCanRegister() {

		homePage.enterFirstName(prop.getProperty("firstName"));
		homePage.enterLastName(prop.getProperty("lastName"));
		homePage.enterStreetAddress(prop.getProperty("streetAddress"));
		homePage.enterCity(prop.getProperty("city"));
		homePage.enterState(prop.getProperty("state"));
		homePage.enterZipCode(prop.getProperty("zipCode"));
		homePage.enterPhoneNum(prop.getProperty("phoneNo"));
		homePage.enterSSN(prop.getProperty("SSN"));
		homePage.enterUsername(prop.getProperty("username"));
		homePage.enterPassword(prop.getProperty("password"));
		homePage.confirmPassword(prop.getProperty("password"));

		custAcctPage = homePage.submitRegistration();
		String welcomeMessageText = custAcctPage.getWelcomeMessage();
		String getConfirmationText = custAcctPage.getConfirmationMessage();
		
		Assert.assertEquals(welcomeMessageText, "Welcome " + prop.getProperty("username"),
				"Not registered as expected");
		
		Assert.assertEquals(getConfirmationText, "Your account was created successfully. You are now logged in.",
				"Confirmation message not as expected");
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
