package sgt.tchateau.seleniumautomation11.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath="//input[@id='user_email']")
	private WebElement email;
	@FindBy(xpath="//input[@id='user_password']")
	private WebElement password;
	@FindBy(xpath="//input[@name='commit']")
	private WebElement submit;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmit() {
		return submit;
	}
}
