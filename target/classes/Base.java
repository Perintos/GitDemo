package sgt.tchateau.seleniumautomation11.ressources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	protected WebDriver driver= null;
	protected Properties prop = null;
	
	public void initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream in = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\sgt\\tchateau\\seleniumautomation11\\ressources\\data.properties"); //exception
		prop.load(in); //exception
		String browser = prop.getProperty("browser");
		
		if(System.getProperty("browser")!=null)
			browser = System.getProperty("browser");
		
		
		if(browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\sgt\\tchateau\\seleniumautomation11\\ressources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(browser.contains("headless")) {
				options.addArguments("headless");	
			}
			driver = new ChromeDriver(options);
		} else if(browser.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\sgt\\tchateau\\seleniumautomation11\\ressources\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if(browser.contains("IE")){
			System.setProperty("webdriver.ie.driver", "C:\\Users\\tchateau\\Documents\\Resssources\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			throw new IOException();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public String  getScreeshot(String resultName) throws IOException {
		SimpleDateFormat formatter= new SimpleDateFormat(" yyyy-MM-dd HH-mm-ss z");
		Date date = new Date(System.currentTimeMillis());
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String s = "C://test//screenshot " + resultName + formatter.format(date) + ".png";
		FileUtils.copyFile(src, new File(s));
		return s;
	}
}
