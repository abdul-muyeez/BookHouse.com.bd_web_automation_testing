package webauto.bd.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import webauto.bd.utilities.GetScreenShot;
import webauto.bd.drivers.PageDriver;
import webauto.bd.utilities.CommonMethods;

public class LoginPage extends CommonMethods {
	
	
	ExtentTest test;
	
	public LoginPage(ExtentTest test) {
		
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test= test;
	}
	
	@FindBys({@FindBy (xpath="//input[@id='email']")})
	WebElement useremail;
	
	@FindBys({@FindBy (xpath="//input[@id='c-password']")})
	WebElement password;

	@FindBys({@FindBy (xpath="//button[contains(text(),'login')]"),
			@FindBy (xpath="//button[normalize-space()='login']")})
	WebElement signin;
	
	
	// Report
	public void passCase(String message) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
	}

	@SuppressWarnings("unused")
	public void passCaseWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "" + scName + "");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "" + scName + ".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}

	// Fail
	@SuppressWarnings("unused")
	public void failCase(String message, String scName) throws IOException {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>" + message + "</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "" + scName + "");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "" + scName + ".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}
	
	public void login () throws IOException {
		
		try {
			test.info("Please enter email address");
			if(useremail.isDisplayed()) {
				useremail.sendKeys("muyeezrj@gmail.com");
				passCase("You have successfully entered email");
				timeout(2000);
				
				try {
					test.info("Please enter passwor");
					if(password.isDisplayed()) {
						password.sendKeys("astapasta");
						passCase("You have successfully entered password");
						timeout(2000);
						
						try {
							test.info("Click on Sign in");
							if(signin.isDisplayed()) {
							signin.click();
							timeout(10000);
							passCaseWithSC("You have successfully clicked Login", "login_pass");
							}
						
							
						} catch (Exception e) {
							failCase("Login button locator not found", "login_fail");
							System.out.println("User signin locator was not found");
						}		
					}
				
				} catch (Exception e) {
					failCase("Password locator not found", "password_fail");
					System.out.println("User password locator was not found");
				}
			
			} 
			
		} catch (Exception e) {
			failCase("email locator not found", "email_fail");
			System.out.println("User email locator was not found");
		}
		
	}
}



	
	
	

