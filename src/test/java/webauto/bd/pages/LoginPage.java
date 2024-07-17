package webauto.bd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import webauto.bd.drivers.PageDriver;
import webauto.bd.utilities.CommonMethods;

public class LoginPage extends CommonMethods {
	
	
	ExtentTest test;
	
	public LoginPage(ExtentTest test) {
		
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}
	
	@FindBys({@FindBy (xpath="//input[@id='email']")})
	WebElement useremail;
	
	@FindBys({@FindBy (xpath="//input[@id='c-password'")})
	WebElement password;

	@FindBys({@FindBy (xpath="//div[@class='login_submit']"),
			@FindBy (xpath="//button[normalize-space()='login']")})
	WebElement signin;
	
	public void login () {
		
		try {
			test.info("Please enter email address");
			if(useremail.isDisplayed()) {
				useremail.sendKeys("muyeezrj@gmail.com");
				timeout(2000);
				
				try {
					test.info("Please enter passwor");
					if(password.isDisplayed()) {
						password.sendKeys("astapasta");
						timeout(2000);
						
						try {
							test.info("Click on Sign in");
							if(signin.isDisplayed()) {
							signin.click();
							timeout(10000);
							}
						
							
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("User signin locator was not found");
						}		
					}
				
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("User password locator was not found");
				}
			
			} 
			
		} catch (Exception e) {
			//TODO: Handle exception
			System.out.println("User email locator was not found");
		}
		
	}
}



	
	
	

