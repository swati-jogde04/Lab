package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.LoginPage;

public class TC_Login extends BaseClass {

    
	@Test
	public void loginTest() {

		
		        LoginPage lm = new LoginPage(driver);

		        lm.setEmail(email);
		        lm.setPassword(password);
		        lm.clickLogin();
		    


	    String actualTitle = driver.getTitle();
	    String expectedTitle = "Cogni+Med — Laboratory Management System";

	    Assert.assertEquals(actualTitle, expectedTitle,
	            "Login page title is incorrect");
	}

}
