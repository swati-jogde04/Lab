package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddPatient {

    
	WebDriverWait wait;
	WebDriver driver;
	
	public AddPatient(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	    this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

    @FindBy(xpath="//span[text()='Patients']")
    WebElement patients;

    @FindBy(xpath="a[href='/patients/new']")
    WebElement addPatient ;
}
