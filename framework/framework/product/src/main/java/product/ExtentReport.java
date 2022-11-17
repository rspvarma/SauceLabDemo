package product;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public static ExtentReports getReportObj()
	{
		String ER=System.getProperty("user.dir")+"\\Results\\index.html";
		//ExtendReports and ExtendSParkReporter are important classes in building the reports
		ExtentSparkReporter reporter =new ExtentSparkReporter(ER);
		reporter.config().setReportName("SauceLab_Results");
		reporter.config().setDocumentTitle("TestResults");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Pavan");
		return extent;
	}

}
