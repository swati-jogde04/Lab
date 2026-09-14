package utilities;
import testcases.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.Status;


public class ExtentListenerClass implements ITestListener{

    
    
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configureReport() {
		
		  String reportPath = System.getProperty("user.dir")
		            + "/ExtentReports/LMSAutomationReport.html";

		    htmlReporter = new ExtentSparkReporter(reportPath);

		    reports = new ExtentReports();

		    reports.attachReporter(htmlReporter);

		// add system information

		reports.setSystemInfo("Project", "LMS - Laboratory Management System");
		reports.setSystemInfo("Module", "Login");
		reports.setSystemInfo("Test Type", "Automation Testing");
		reports.setSystemInfo("Testing Tool", "Selenium WebDriver");
		reports.setSystemInfo("Programming Language", "Java");
		reports.setSystemInfo("Test Framework", "TestNG");
		reports.setSystemInfo("Build Tool", "Maven");
		reports.setSystemInfo("Automation Framework", "Page Object Model");
		reports.setSystemInfo("Browser", "Google Chrome");
		reports.setSystemInfo("Operating System", "Windows");
		reports.setSystemInfo("Tester", "Swati");

		// Change look and filled

		htmlReporter.config().setDocumentTitle("LMS Automation Test Report");

		htmlReporter.config().setTheme(Theme.DARK);

		htmlReporter.config().setReportName("LMS Automation Testing");
	}

	@Override
	public void onStart(ITestContext context) {

		System.out.println("LMS Automation Test Execution Started");
		configureReport();
	}

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println("Test Started: ");



	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("Test passed:" + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Test Passed+" + result.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("Test Failed:" + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Test Failed+" + result.getName(), ExtentColor.RED));
		test.log(Status.INFO, result.getThrowable().getMessage());
        // Exception / Failure reason
        if (result.getThrowable() != null) {

            test.log(
                    Status.FAIL,
                    "Failure Reason: "
                            + result.getThrowable().getMessage());

            test.log(
                    Status.FAIL,
                    result.getThrowable());
        }

        // ========================================================
        // Take Screenshot and Attach Directly to Extent Report
        // No Screenshots folder
        // No PNG file
        // ========================================================

        try {

            String screenshotBase64 =
                    takeScreenshotAsBase64();

            test.log(
                    Status.FAIL,
                    "Failed Test Case Screenshot:");

            test.addScreenCaptureFromBase64String(
                    screenshotBase64,
                    "Failure Screenshot");

        } catch (Exception e) {

            test.log(
                    Status.WARNING,
                    "Unable to attach screenshot: "
                            + e.getMessage());
        }
    }

	@Override
	public void onTestSkipped(ITestResult result) {

		test = reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Test Skipped:" + result.getName(), ExtentColor.YELLOW));

	}

	// Screenshot method (inside extentreport folder)
	/*public String captureScreenshot(String testName) {

		String screenshotFolder = System.getProperty("user.dir") + "/ExtentReports/Screenshots/";

		// Create screenshot folder if it doesn't exist
		File folder = new File(screenshotFolder);

		if (!folder.exists()) {
			folder.mkdirs();
		}

		String screenshotPath = screenshotFolder + testName + ".png";

		try {

			TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			File destination = new File(screenshotPath);

			FileUtils.copyFile(source, destination);

			System.out.println("Screenshot saved: " + screenshotPath);

		} catch (IOException e) {

			e.printStackTrace();
		}

		return screenshotPath;
	}*/
	public String takeScreenshotAsBase64() {

        TakesScreenshot ts =
                (TakesScreenshot) BaseClass.driver;

        return ts.getScreenshotAs(
                OutputType.BASE64);
    }
	
	

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Completed");
		reports.flush();

	}



}
