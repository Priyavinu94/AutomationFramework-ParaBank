package com.parasoft.parabank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parasoft.parabank.BasePackage.TestBase;

public class CustomerCreatedPage extends TestBase {
	
	public CustomerCreatedPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "title")
	WebElement welcomeMessage;
	
	@FindBy(css = "#rightPanel p")
	WebElement confirmationMessage;
		
	public String getWelcomeMessage() {
		return welcomeMessage.getText();
	}
	
	public String getConfirmationMessage() {
		return confirmationMessage.getText();
	}

}
