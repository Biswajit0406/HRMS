package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.Base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utility.Utility;

import org.openqa.selenium.WebDriver;

public class ExtentReportListener implements ITestListener {

    private ExtentReports extent;
    private ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    // Initialize Extent Report
//    @Override
//    public void onStart(ITestContext context) {
//        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("C:\\Users\\KIIT\\eclipse-workspace\\com.or.HRMS\\reports") + "reports/HRMS_REPORT.html");
//        sparkReporter.config().setDocumentTitle("Automation Test Report");
//        sparkReporter.config().setReportName("Functional Testing Report");
//        sparkReporter.config().setTheme(Theme.STANDARD);
//
//        extent = new ExtentReports();
//        extent.attachReporter(sparkReporter);
//
//        extent.setSystemInfo("Environment", "QA");
//        extent.setSystemInfo("OS", System.getProperty("os.name"));
//        extent.setSystemInfo("Tester", "Biswa");
//        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
//
//        System.out.println("Extent Reports initialized");
//    }
    @Override
    public void onStart(ITestContext context) {
        String reportPath = System.getProperty("user.dir") + "/reports/HRMS_REPORT.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Functional Testing Report");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Tester", "Biswa");
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));

        System.out.println("Extent Reports initialized");
    }


    // Clean up Extent Report
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        System.out.println("Extent Reports generated");
    }

    // Log when a test starts
    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
        extentTest.get().log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());
    }

    // Log when a test passes
    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
    }

    // Log when a test fails
    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
        extentTest.get().log(Status.FAIL, "Reason: " + result.getThrowable());

        // Capture and attach a screenshot
        Object testClass = result.getInstance();
        WebDriver driver = ((Base) testClass).dr; // Access WebDriver from BaseTest
        String screenshotPath = Utility.captureScreenshot(driver, result.getMethod().getMethodName());
        try {
            extentTest.get().addScreenCaptureFromPath(screenshotPath, "Screenshot on Failure");
        } catch (Exception e) {
            System.out.println("Error while attaching screenshot to report: " + e.getMessage());
        }
    }

    // Log when a test is skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
        extentTest.get().log(Status.SKIP, "Reason: " + result.getThrowable());
    }

    // Log when a test partially succeeds (optional)
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        extentTest.get().log(Status.WARNING, "Test Partially Successful: " + result.getMethod().getMethodName());
    }
}
