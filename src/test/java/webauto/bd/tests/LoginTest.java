package webauto.bd.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import webauto.bd.drivers.PageDriver;
import webauto.bd.pages.LoginPage;
import webauto.bd.utilities.CommonMethods;

public class LoginTest extends CommonMethods{
	@BeforeClass
	public void openurl() throws InterruptedException {
		
		PageDriver.getCurrentDriver().get(url);
		timeout();
	}
@Test
	public void loginIntoShop() {
		
		LoginPage loginPage = new LoginPage(null);
		loginPage.login();
		
	}
}
