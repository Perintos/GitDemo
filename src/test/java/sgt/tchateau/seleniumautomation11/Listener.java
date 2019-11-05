package sgt.tchateau.seleniumautomation11;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.Status;


import sgt.tchateau.seleniumautomation11.ressources.Base;

public class Listener implements ITestListener{
	private Base base;
	private ExtentHtmlReporter htmlReporter;
	private ExtentReports extent ;
	private ExtentTest test ; 
	 
	public Listener() throws IOException {
		System.out.println("nouveau listener");
		base = new Base();
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-outpu/MyReport.html");

		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("funtional report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name", "Pavan");
		extent.setSystemInfo("Browser", "Chrome");
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
		test.log(Status.PASS, "TEST CASE FAILED IS " + result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); //to add name in extent report
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); //to add error/exception 
		
		String path;
		try {
			path = base.getScreeshot(result.getName());
			test.addScreenCaptureFromPath(path);

		} catch (IOException e) {
			System.out.println("erreur screenshot");
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");

		test.log(Status.PASS, "TEST CASE FAILED IS " + result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentagev");

		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		System.out.println("onStart");
		test = extent.createTest(context.getName());

		
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish");

		extent.flush();
	}

}
