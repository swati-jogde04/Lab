package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

     WebDriver driver;

	    // Constructor
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(name ="email")
	    WebElement email;

	    @FindBy(name ="password")
	    WebElement pwd;

	    @FindBy(xpath = "//span[@class='flex items-center justify-center gap-1.5']")
	    WebElement loginButton;

	    public void setEmail(String emailAddress) {
	        email.clear();
	        email.sendKeys(emailAddress);
	    }

	    public void setPassword(String password) {
	        pwd.clear();
	        pwd.sendKeys(password);
	    }

	    public void clickLogin() {
	        loginButton.click();
	    }


}
