package reports;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    public static ExtentReports createReport() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        return extent;
    }
}
