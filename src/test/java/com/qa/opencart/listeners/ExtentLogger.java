package com.qa.opencart.listeners;

import com.aventstack.extentreports.Status;

public class ExtentLogger {

	public static void pass(String message) {
		ExtentReportProvider.extentTest.get().log(Status.PASS, message);
	}

	public static void info(String message) {
		ExtentReportProvider.extentTest.get().log(Status.INFO, message);
	}

	public static void fail(String message) {
		ExtentReportProvider.extentTest.get().log(Status.FAIL, message);
	}
}
