package com.parasoft.parabank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parasoft.parabank.BasePackage.TestBase;

public class CustomerAccountPage extends TestBase {
	
	public CustomerAccountPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "title")
	WebElement welcomeMessage;
	
	public String getWelcomeMessage() {
		return welcomeMessage.getText();
	}
}
