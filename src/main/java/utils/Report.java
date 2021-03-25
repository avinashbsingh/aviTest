package utils;

import com.rajatthareja.reportbuilder.Color;
import com.rajatthareja.reportbuilder.ReportBuilder;
import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.java.Scenario;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Report {

    private String reportPrefix = "TestReport_Avi" + MasterData.getContext(Keys.BROWSER);
    private String projectPath = System.getProperty("user.dir");
    private String reportGeneratePath = projectPath + "./target/cucumber-reports/extent-reports/";
    private String reportScreenshotPath = projectPath + "./target/cucumber-reports/extent-reports/screenshots/";

    public Report() {
        String reportName = "Extent_" + reportPrefix + "_" + getDateStamp();
        File directoryExtentReport = new File(reportGeneratePath);
        directoryExtentReport.mkdir();
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath(reportGeneratePath + reportName + ".html");
    }

    public static String getDateStamp() {
        return new SimpleDateFormat("MM-dd-YYYY_HH-mm-ss").format(new GregorianCalendar().getTime());
    }

    public void generateBuilderReport() {
        ReportBuilder reportBuilder = new ReportBuilder();

        // Set output Report Dir
        reportBuilder.setReportDirectory("./target/cucumber-reports/rb-reports/");

        // Set output report file name
        reportBuilder.setReportFileName("RB_" + reportPrefix);

        // Set Report Title
        reportBuilder.setReportTitle("Automation Test Report");

        // Set Report Color for more visit http://materializecss.com/color.html
        reportBuilder.setReportColor(Color.INDIGO);

        // Enable voice control for report
        //reportBuilder.enableVoiceControl();

        // Add additional info for Report
        reportBuilder.setAdditionalInfo("Environment", "QC");
        reportBuilder.setAdditionalInfo("Client", "Avinash");
        reportBuilder.setAdditionalInfo("Browser", "Chrome");

        // Create list or report Files or Directories or URLs or JSONObject or JSONString
        List<Object> cucumberJsonReports = new ArrayList<>();
        cucumberJsonReports.add(new File("./target/cucumber-reports/cucumber-report.json"));

        // Build your report
        reportBuilder.build(cucumberJsonReports);

    }

    public void reportlog(String arg) {
        Scenario scenario = (Scenario) MasterData.getContext(Keys.SCENARIO);
        scenario.log(arg);
        //Reporter.addStepLog(arg);

    }
}
