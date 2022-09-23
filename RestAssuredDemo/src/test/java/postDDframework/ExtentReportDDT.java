package postDDframework;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentReportDDT extends TestListenerAdapter{
ExtentHtmlReporter htmlReporter;
ExtentReports extent;
ExtentTest logger;
@BeforeTest
public void startReport(){
	//String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
htmlReporter = new ExtentHtmlReporter("ExtentReport1.html");
extent = new ExtentReports ();
extent.attachReporter(htmlReporter);
extent.setSystemInfo("Host Name", "Rest Assured DDT");
extent.setSystemInfo("Environment", "Automation Testing");
extent.setSystemInfo("User Name", "Sharmila SM");
htmlReporter.config().setDocumentTitle("Title of the Report ");
htmlReporter.config().setReportName("REQRES");
//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
htmlReporter.config().setTheme(Theme.STANDARD);
}
@Test
public void passTest(){
logger = extent.createTest("passTest");
AssertJUnit.assertTrue(true);
logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
}
@Test

public void failTest(){
logger = extent.createTest("failTest");
AssertJUnit.assertTrue(false);
logger.log(Status.PASS, "Test Case (failTest) Status is passed");
logger.log(Status.PASS, MarkupHelper.createLabel("Test Case (failTest) Status is passed", ExtentColor.GREEN));
}


@Test
public void skipTest(){
logger = extent.createTest("skipTest");
throw new SkipException("Skipping - This is not ready for testing ");
}
@AfterMethod
public void getResult(ITestResult result){
if(result.getStatus() == ITestResult.FAILURE){
//logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
//MarkupHelper is used to display the output in different colors
logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
}else if(result.getStatus() == ITestResult.SKIP){
//logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
}
}
@AfterTest
public void endReport(){
extent.flush();
   }
}