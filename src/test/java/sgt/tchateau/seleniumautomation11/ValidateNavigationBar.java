package sgt.tchateau.seleniumautomation11;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import sgt.tchateau.seleniumautomation11.pageobject.LandingPage;
import sgt.tchateau.seleniumautomation11.ressources.Base;



public class ValidateNavigationBar extends Base { 

	
	
	@BeforeTest
	public void initialize() throws IOException {
		System.out.println("beforetestValidateNavigationBar");
		initializeDriver();
		driver.get(prop.getProperty("url"));		
	}

	
	@Test
	public void baseNavigation(){		
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavBar().isDisplayed());
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
		driver=null;
	}
}
