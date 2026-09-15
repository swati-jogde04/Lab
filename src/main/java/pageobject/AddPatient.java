package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class AddPatient {

    
	WebDriverWait wait;
	WebDriver driver;
	
	public AddPatient(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	    this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

      // Patients menu
    @FindBy(xpath = "//span[normalize-space()='Patients']")
    private WebElement patients;

    // Add Patient button
    @FindBy(css = "a[href='/patients/new']")
    private WebElement addPatient;

    // First Name
    @FindBy(xpath = "//input[@placeholder='Search existing or type new name...']")
    private WebElement firstName;

    // Last Name
    @FindBy(name = "lastName")
    private WebElement lastName;

    // Age
    @FindBy(name = "age")
    private WebElement age;

    // Gender dropdown
    @FindBy(xpath = "//button[@role='combobox'][.//span[normalize-space()='Select gender']]")
    private WebElement gender;

    // Phone
    @FindBy(name = "phone")
    private WebElement phone;

    // Email
    @FindBy(name = "email")
    private WebElement email;

    // Address
    @FindBy(xpath = "//input[@placeholder='Full address']")
    private WebElement address;

    // Create Patient button
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createPatient;


    // Click Patients
    public void clickPatients() {

        wait.until(ExpectedConditions.elementToBeClickable(patients));

        patients.click();
    }


    // Click Add Patient
    public void clickAddPatient() {

        wait.until(ExpectedConditions.elementToBeClickable(addPatient));

        addPatient.click();
    }


    // Enter First Name
    public void setPatientFName(String fname) {

        wait.until(ExpectedConditions.visibilityOf(firstName));

        firstName.clear();
        firstName.sendKeys(fname);
    }


    // Enter Last Name
    public void setPatientLName(String lname) {

        wait.until(ExpectedConditions.visibilityOf(lastName));

        lastName.clear();
        lastName.sendKeys(lname);
    }


    // Enter Age
    public void setPatientAge(String patientAge) {

        wait.until(ExpectedConditions.visibilityOf(age));

        age.clear();
        age.sendKeys(patientAge);
    }


    // Select Gender
    public void setGender(int index) {

        wait.until(ExpectedConditions.elementToBeClickable(gender)).click();
	    List<WebElement> options = wait.until(
	        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@role='combobox']"))
	    );
	    if (index >= 0 && index < options.size()) {
	        options.get(index).click();
	    }

	}
    // Enter Phone
    public void setPhone(String phoneNumber) {

        wait.until(ExpectedConditions.visibilityOf(phone));

        phone.clear();
        phone.sendKeys(phoneNumber);
    }


    // Enter Email
    public void setEmail(String emailAddress) {

        wait.until(ExpectedConditions.visibilityOf(email));

        email.clear();
        email.sendKeys(emailAddress);
    }


    // Enter Address
    public void setAddress(String patientAddress) {

        wait.until(ExpectedConditions.visibilityOf(address));

        address.clear();
        address.sendKeys(patientAddress);
    }


    // Click Create Patient
    public void clickCreatePatientButton() {

        wait.until(ExpectedConditions.elementToBeClickable(createPatient));

        createPatient.click();
    }

}
