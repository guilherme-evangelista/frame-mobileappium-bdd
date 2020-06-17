package br.com.guilhermeevangelista.appium.core.utils;

import com.rajatthareja.reportbuilder.ReportBuilder;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Report {
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static DateFormat dateFormatFile = new SimpleDateFormat("ddMMyyyy");
    private static Date date = new Date();

    public static void gerarRelatio() {
        ReportBuilder reportBuilder = new ReportBuilder();

        reportBuilder.setReportDirectory("target/");
        reportBuilder.setReportFileName(dateFormatFile.format(date));

        // Set Report Title
        reportBuilder.setReportTitle("Frame Work Page Factory");
        reportBuilder.setReportColor("grey");

        // Enable voice control for report
        reportBuilder.enableVoiceControl();

        // Add additional info for Report
        reportBuilder.setAdditionalInfo("Date", dateFormat.format(date));

        // Create list or report Files or Directories or URLs or JSONObject or JSONString
        List<Object> cucumberJsonReports = new ArrayList<>();
        cucumberJsonReports.add(new File("target/cucumber.json"));
        cucumberJsonReports.add(new File("target/"));

        // Build your report
        reportBuilder.build(cucumberJsonReports);
    }
}
