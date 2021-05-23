package com.runner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JvmReport {
	public static void generateJvmReport(String jsonloc) {
		File jvmReport = new File("C:\\Users\\ramsi\\eclipse-workspace\\GoogleDemo\\src\\test\\resources\\Reports");
		List<String> emp = new ArrayList<String>();
		emp.add(jsonloc);
		Configuration con = new Configuration(jvmReport, "Google Search Demo");
		con.addClassifications("Browser", "Chrome");
		con.addClassifications("Browser version", "89 or later");
		con.addClassifications("OS", "Windows 10");

		ReportBuilder builder = new ReportBuilder(emp, con);
		builder.generateReports();

	}

}
