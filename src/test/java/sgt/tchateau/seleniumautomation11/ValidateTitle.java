package sgt.tchateau.seleniumautomation11;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import sgt.tchateau.seleniumautomation11.pageobject.LandingPage;
import sgt.tchateau.seleniumautomation11.ressources.Base;


public class ValidateTitle extends Base {
	
	private static Logger log = LogManager.getLogger(Base.class.getName());
	private LandingPage l;
	
	@BeforeTest
	public void initialize() throws IOException {
		System.out.println("beforetestValidateTitle");
		initializeDriver();
		log.info("driver is initialized");
		driver.get("http://qaclickacademy.co/");
		log.info("navigated to home page");

	}
	
	@Test
	public void baseNavigation() throws IOException{
		l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("successfully validated");

	}
	
	
	
	@Test
	public void baseNavigation2() throws IOException{
		
		driver.get("http://qaclickacademy.com/");

		l = new LandingPage(driver);
		Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("successfully validated");

	}
	
	@AfterTest
	public void teardown() {
		System.out.println("aftertestValidateTitle");
		driver.quit();
		driver=null;
		log.info("driver is quited");

	}
}
