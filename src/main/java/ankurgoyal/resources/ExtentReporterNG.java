package ankurgoyal.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class  ExtentReporterNG {
	
	
	public static ExtentReports getReportObject() {
		
		String path= System.getProperty("user.dir")+ "//reports//index.html";
		
		ExtentSparkReporter rep=new ExtentSparkReporter(path);
		rep.config().setReportName("Web Automation");
		rep.config().setDocumentTitle("Test Reports");
		
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(rep);
		extent.setSystemInfo("Tester", "Ankur");
		return extent;
	}

}
