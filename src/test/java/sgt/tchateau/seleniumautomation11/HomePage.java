package sgt.tchateau.seleniumautomation11;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sgt.tchateau.seleniumautomation11.pageobject.LandingPage;
import sgt.tchateau.seleniumautomation11.pageobject.LoginPage;
import sgt.tchateau.seleniumautomation11.ressources.Base;


public class HomePage extends Base{
	@BeforeTest
	public void initialize() throws IOException {
		System.out.println("beforetestHomePage");
		initializeDriver();
		driver.get(prop.getProperty("url"));
		LandingPage landingPage = new LandingPage(driver);
		landingPage.getLogIn().click();
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password) throws IOException {
			LoginPage loginPage = new LoginPage(driver);
			loginPage.getEmail().sendKeys(username);
			loginPage.getPassword().sendKeys(password);
			loginPage.getSubmit().click();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="itsasecret";
		
		data[1][0]="restricteduser@qw.com";
		data[1][1]="itsasecret";
		
		return data;		
	}
	
	@AfterTest
	public void teardown() {
		System.out.println("aftertestHomePage");
		driver.quit();
		driver=null;
	}
}
