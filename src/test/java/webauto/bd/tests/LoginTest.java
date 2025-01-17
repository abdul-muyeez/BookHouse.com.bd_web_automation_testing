package webauto.bd.tests;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import webauto.bd.drivers.PageDriver;
import webauto.bd.pages.LoginPage;
import webauto.bd.utilities.CommonMethods;
import webauto.bd.utilities.ExtentFactory;

public class LoginTest extends CommonMethods{

	ExtentReports reports;
	ExtentTest parentTest;
	ExtentTest childTest;

	
	
	@BeforeClass
	public void openurl() throws InterruptedException {
		
		PageDriver.getCurrentDriver().get(url);
	timeout();
	reports = ExtentFactory.getInstance();
	parentTest = reports.createTest("<p style=\"color:#85BC63; font-size:13px\"><b>BookHouse</b></p>").assignAuthor("QA Team").assignDevice("Windows");
		
	}
@Test
	public void loginIntoShop() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:13px\"><b>Login</b></p>");
		LoginPage loginPage = new LoginPage(childTest);
		loginPage.login();
	
		
	}
		@AfterClass
		public void report() {
			reports.flush();
		}




}
