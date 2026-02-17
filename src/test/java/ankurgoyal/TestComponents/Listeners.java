package ankurgoyal.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ankurgoyal.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent= ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentText=new ThreadLocal<ExtentTest>();//will make test threadsafe
	
	@Override
	public void onTestStart(ITestResult result) {
		
		test=extent.createTest(result.getMethod().getMethodName());
		extentText.set(test);//assign one unique threadID(ErrorValidationTest)->test
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		
		
		
		test.log(Status.PASS, "Test Passed");
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		extentText.get().fail(result.getThrowable());
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String filePath = null;
		try {
			filePath = getScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentText.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		//test.log(Status.FAIL, "Test Failed");
		
		
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	@Override
	public void onStart(ITestContext context) {
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}
	
	
	

}
