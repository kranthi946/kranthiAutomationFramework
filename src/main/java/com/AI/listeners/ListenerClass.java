package com.AI.listeners;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;
import org.testng.xml.XmlTest;
import java.lang.reflect.Method;
import java.util.List;

public class ListenerClass implements
		ITestListener, IInvokedMethodListener, ISuiteListener, IAnnotationTransformer, IReporter, IExecutionListener,
		IClassListener, IRetryAnalyzer {

	public ListenerClass() {}

	// ----- ITestListener Methods -----
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started - Method: " + result.getMethod().getMethodName() + ", Status: " + result.getStatus());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed - Method: " + result.getMethod().getMethodName() + ", Status: " + result.getStatus());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed - Method: " + result.getMethod().getMethodName() + ", Exception: " + result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped - Method: " + result.getMethod().getMethodName() + ", Status: " + result.getStatus());
	}

	// ----- ISuiteListener Methods -----
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Suite Started - Suite Name: " + suite.getName());
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Suite Finished - Suite Name: " + suite.getName());
	}

	// ----- IInvokedMethodListener Methods -----
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("Before Method Invocation - Method: " + method.getTestMethod().getMethodName() +
				", Test Class: " + testResult.getTestClass().getName());
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("After Method Invocation - Method: " + method.getTestMethod().getMethodName() +
				", Test Class: " + testResult.getTestClass().getName());
	}

	// ----- IAnnotationTransformer Methods -----

	public void transform(ITestAnnotation annotation, Class testClass, Method testMethod, ITestContext context) {
		// Print the order in which annotations are executed
		System.out.println("Transforming Annotation - Test Name: " + annotation.getTestName() +
				", Test Method: " + testMethod.getName() + ", Test Class: " + testClass.getName());

		// Enable the test method if needed
		annotation.setEnabled(true); // Example: dynamically enabling/disabling tests
	}

	// ----- IReporter Methods -----
	// You can implement a custom report generation logic here
	// @Override
	// public void generateReport(List<XmlTest> xmlTests, List<ISuite> suites, String outputDirectory) {
	//    System.out.println("Generating Custom Report...");
	//    System.out.println("XML Tests: " + xmlTests.size() + ", Suites: " + suites.size() +
	//            ", Output Directory: " + outputDirectory);
	// }

//	// ----- IExecutionListener Methods -----
//	@Override
//	public void beforeExecution() {
//		System.out.println("Before Test Execution - Initializing environment.");
//	}

//	@Override
//	public void afterExecution() {
//		System.out.println("After Test Execution - Cleaning up environment.");
//	}

	// ----- ITestContextListener Methods -----
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Context Started - Test Name: " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Context Finished - Test Name: " + context.getName());
	}

	// ----- IRetryAnalyzer Methods -----
	@Override
	public boolean retry(ITestResult result) {
		System.out.println("Retrying Test - Method: " + result.getMethod().getMethodName());
		// Implement retry logic if needed (for simplicity, this always returns false)
		return false; // If you want to retry, return true, otherwise return false
	}

	// ----- IParameterListener Methods -----
	// You can implement parameter-based hooks here if needed, but they are commented out.
	// @Override
	// public void beforeConfiguration(ITestResult result) {
	//    System.out.println("Before Configuration - Test Method: " + result.getMethod().getMethodName());
	// }
	//
	// @Override
	// public void afterConfiguration(ITestResult result) {
	//    System.out.println("After Configuration - Test Method: " + result.getMethod().getMethodName());
	// }
}
