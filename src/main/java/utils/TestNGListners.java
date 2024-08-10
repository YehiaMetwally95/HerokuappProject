package utils;

import org.testng.*;

public class TestNGListners implements ITestListener , IInvokedMethodListener , ISuiteListener {

    public void onTestStart(ITestResult result) {
        // not implemented
    }

    public void onTestSuccess(ITestResult result) {
    }


    public void onTestFailure(ITestResult result) {
    }

    public void onTestSkipped(ITestResult result) {
        // not implemented
    }

    public void onStart(ITestContext context) {
        // not implemented
    }

    public void onFinish(ITestContext context) {
        // not implemented
    }

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        // not implemented
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
    }
}

