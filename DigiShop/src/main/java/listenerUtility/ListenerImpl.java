package listenerUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import genericLibrary.BaseClass;

public class ListenerImpl extends BaseClass implements ITestListener{

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Execution Started");
	}
	
	@Override
	 public void onFinish(ITestContext context) {
	    System.out.println("Execution completed");
	  }
	
	@Override
	public  void onTestStart(ITestResult result) {
	    System.out.println(result.getName()+" execution Started");
	  }
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
	    System.out.println(result.getName()+"execution completed Com");
	  }
	
	@Override
	public void onTestFailure(ITestResult result) {
	    test.log(LogStatus.FAIL, test.addScreenCapture(getWebPageScreenshot(driver)));
	  }

	
}
