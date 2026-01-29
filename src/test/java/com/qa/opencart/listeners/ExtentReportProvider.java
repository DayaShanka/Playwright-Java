package com.qa.opencart.listeners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportProvider implements ITestListener {

	public static ExtentReports extentrepo;
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	@Override
	public void onStart(ITestContext testcontext) {

		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "TestReport_" + timestamp + ".html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/reports/" + reportName);

		reporter.config().setDocumentTitle("Automation testing");
		reporter.config().setReportName("Automation Report");
		reporter.config().setTheme(Theme.STANDARD);

		extentrepo = new ExtentReports();
		extentrepo.attachReporter(reporter);
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extentrepo.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extentrepo.flush();
	}
}
