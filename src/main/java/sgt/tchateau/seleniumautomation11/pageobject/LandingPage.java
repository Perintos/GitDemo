package sgt.tchateau.seleniumautomation11.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	@FindBy(xpath="//a/span[contains(text(),'Login')]")
	private WebElement logIn;
	@FindBy(xpath="//div[@class='text-center']/h2")
	private WebElement title;
	@FindBy(css=".nav.navbar-nav.navbar-right>li>a")
	private WebElement navBar;
	@FindBy(css="div[class*=video-banner] h3")
	private WebElement header;
	
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getLogIn() {
		return logIn;
	}
	public WebElement getTitle() {
		return title;
	}
	public WebElement getNavBar() {
		return navBar;
	}
	public WebElement getHeader() {
		return header;
	}
	
	
	// //tagName[@attribute='value'] - custom xpath on peut ajouter [x] si l'element est dispo plusieurs fois.
	// regular expression //tagName[contains(@attribute,'value')]
	// parent - child = //tagName[@class='RNNXgb']/tagName/tagName[x]/tagName
	
	//body//section//div/div/div/div//ul/li[2]
	//*[@id='tablist1-tab1']/following-sibling::li[3]
	//*[@id='tablist1-tab1']/parent::ul
	
	//--
	
	// - custom css selector 
	// tagName#id ou #idName
	// tagName.class ou .className
	// regular expression tagName[attribute*='value']
	// [attribute='value']
}
