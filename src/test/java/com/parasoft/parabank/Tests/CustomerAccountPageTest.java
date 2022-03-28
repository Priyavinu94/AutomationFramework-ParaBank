package com.parasoft.parabank.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.parasoft.parabank.BasePackage.TestBase;
import com.parasoft.parabank.Pages.CustomerAccountPage;
import com.parasoft.parabank.Pages.RegisterPage;

public class CustomerAccountPageTest extends TestBase {

	RegisterPage registerPage;
	CustomerAccountPage custAcctPage;

	@BeforeMethod
	public void openBrowser() {
		intialiseDriver();
		registerPage = new RegisterPage();
	}

	@Test
	public void verifyUserCanRegister() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterStreetAddress(prop.getProperty("streetAddress"));
		registerPage.enterCity(prop.getProperty("city"));
		registerPage.enterState(prop.getProperty("state"));
		registerPage.enterZipCode(prop.getProperty("zipCode"));
		registerPage.enterPhoneNum(prop.getProperty("phoneNo"));
		registerPage.enterSSN(prop.getProperty("SSN"));
		registerPage.enterUsername(prop.getProperty("username"));
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.confirmPassword(prop.getProperty("password"));

		custAcctPage = registerPage.submitRegistration();
		String welcomeMessageText = custAcctPage.getWelcomeMessage();

		Assert.assertEquals(welcomeMessageText, "Welcome " + prop.getProperty("username"),
				"Not registered as expected");
	}

}
