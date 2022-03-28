package com.parasoft.parabank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parasoft.parabank.BasePackage.TestBase;

public class RegisterPage extends TestBase {

	public RegisterPage() {

		PageFactory.initElements(driver, this);
	}

	// web elements for Registering a user
	@FindBy(id = "customer.firstName")
	WebElement firstNameInput;

	@FindBy(id = "customer.lastName")
	WebElement lastNameInput;

	@FindBy(id = "customer.address.street")
	WebElement streetAddressInput;

	@FindBy(id = "customer.address.city")
	WebElement cityInput;
	
	@FindBy(id = "customer.address.state")
	WebElement stateInput;
	
	@FindBy(id = "customer.address.zipCode")
	WebElement zipCodeInput;

	@FindBy(id = "customer.phoneNumber")
	WebElement phoneNoInput;

	@FindBy(id = "customer.ssn")
	WebElement ssnInput;

	@FindBy(id = "customer.username")
	WebElement usernameInput;

	@FindBy(id = "customer.password")
	WebElement passwordInput;

	@FindBy(id = "repeatedPassword")
	WebElement confirmPwdInput;

	@FindBy(css = "td input.button")
	WebElement registerButton;

	// web elements for user Login
	@FindBy(name = "username")
	WebElement loginUsernameInput;

	@FindBy(name = "password")
	WebElement loginPasswordInput;

	@FindBy(css = "div.login input.button")
	WebElement loginButton;
	
	public void enterFirstName(String firstName) {
		firstNameInput.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		lastNameInput.sendKeys(lastName);
	}
	
	public void enterStreetAddress(String streetAddress) {
		streetAddressInput.sendKeys(streetAddress);
	}
	
	public void enterCity(String city) {
		cityInput.sendKeys(city);
	}
	
	public void enterState(String state) {
		stateInput.sendKeys(state);
	}
	
	public void enterZipCode(String zipCode) {
		zipCodeInput.sendKeys(zipCode);
	}
	
	public void enterPhoneNum(String phoneNo) {
		phoneNoInput.sendKeys(phoneNo);
	}
	
	public void enterSSN(String ssn) {
		ssnInput.sendKeys(ssn);
	}
	
	public void enterUsername(String username) {
		usernameInput.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}
	
	public void confirmPassword(String password) {
		confirmPwdInput.sendKeys(password);
	}
	
	public CustomerAccountPage submitRegistration() {
		registerButton.submit();
		return new CustomerAccountPage();
	}
}
