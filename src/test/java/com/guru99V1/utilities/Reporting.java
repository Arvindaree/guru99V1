package com.guru99V1.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports reporter;
	public ExtentTest test;

	@Override
	public void onTestSuccess(ITestResult tr) 
	{
		test=reporter.createTest(tr.getName()); //create new entry in report
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));//send passed info in green color
	}

	@Override
	public void onTestFailure(ITestResult tr) 
	{
		test=reporter.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenshotPat="Screenshots\\"+tr.getName()+".png";
		
		File f=new File(screenshotPat);
		if(f.exists())
		{
			try {
				test.log(Status.FAIL, (Markup) test.addScreenCaptureFromPath(screenshotPat));
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
		}
	}

	@Override
	public void onTestSkipped(ITestResult tr) 
	{
		test=reporter.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onStart(ITestContext testContext) 
	{
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		String reportName="Test-Report"+timeStamp+".html";
		htmlReporter=new ExtentHtmlReporter("test-output//"+reportName);
		htmlReporter.loadXMLConfig("extent-config.xml");
		
		reporter=new ExtentReports();
		reporter.attachReporter(htmlReporter);
		reporter.setSystemInfo("Host Name", "localhost");
		reporter.setSystemInfo("Environment", "QA");
		reporter.setSystemInfo("User", "Aravind");
		
		htmlReporter.config().setDocumentTitle("guru99V1 Test Project"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
	}

	@Override
	public void onFinish(ITestContext testContext)
	{
		reporter.flush();
	}
	
}
