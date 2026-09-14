package pageobject;

import java.net.URI;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddTest {

    
  
    WebDriver driver;
    WebDriverWait wait;

    // ==============================
    // Constructor
    // ==============================

    public AddTest(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Locators

    @FindBy(xpath = "//a[@href='/test-catalog/tests/new']")
    WebElement addTest;
    
    @FindBy(name="code")
    WebElement testcode;

    @FindBy(name="name")
    WebElement name;

    @FindBy(name = "b2cPrice")
    WebElement b2cprice;

    @FindBy(name = "b2bPrice")
    WebElement b2bprice;

    @FindBy(name = "b2dPrice")
    WebElement b2dPrice;

    @FindBy(name = "mrpPrice")
    WebElement mrPrice;

    @FindBy(name = "turnaroundTime")
    WebElement time;

    @FindBy(xpath = "//button[@role='combobox']")
    WebElement timebox;

    @FindBy(name = "referenceRange")
    WebElement rRange;

    @FindBy(xpath = "//input[@placeholder='Measurement unit']")
    WebElement unit;

    @FindBy(id = "sample-type")
    WebElement sampleType;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement add;

    @FindBy(xpath = "//button[normalize-space()='Add Test']")
    WebElement AddTest;


  //Action methods 

    public void clickTestCatalog() {
	    By locator = By.xpath(
	        "//button[contains(.,'Test Catalog')] | " +
	        "//span[normalize-space()='Test Catalog']/ancestor::button | " +
	        "//span[normalize-space()='Test Catalog']"
	    );
	    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

    public void clickAddTestB() {
    	
    	   By addTestLocator = By.xpath(
    		        "//a[contains(@href, '/test-catalog/tests/new')] | " +
    		        "//a[normalize-space()='Add Test'] | " +
    		        "//span[normalize-space()='Add Test']/ancestor::a"
    		    );

    		    // Step 1: Check if 'Create Panel' link is already visible in the DOM
    		    
    		    List<WebElement> elements = driver.findElements(addTestLocator);
    		    boolean isVisible = !elements.isEmpty() && elements.get(0).isDisplayed();

    		    // Step 2: If NOT visible, expand the Test Catalog menu
    		    if (!isVisible) {
    		        clickTestCatalog();
    		        try {
    		            Thread.sleep(500); // Allow brief moment for React state update & slide animation
    		        } catch (InterruptedException ignored) {}
    		    }

    		    // Step 3: Click the link (or navigate directly if blocked by UI/collapsed sidebar)
    		    try {
    		        WebElement createTestElem = wait.until(ExpectedConditions.visibilityOfElementLocated(addTestLocator));
    		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", createTestElem);
    		        
    		        try {
    		            createTestElem.click();
    		        } catch (Exception e) {
    		            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", createTestElem);
    		        }
    		    } catch (TimeoutException te) {
    		        // Step 4: Fallback to direct navigation if UI state prevents sub-menu rendering
    		        System.out.println("'Create Panel' link not visible in sidebar menu. Navigating directly to /test-catalog/panels/new");
    		        try {
    		            URI uri = URI.create(driver.getCurrentUrl());
    		            String targetUrl = uri.getScheme() + "://" + uri.getAuthority() + "/test-catalog/tests/new";
    		            driver.get(targetUrl);
    		        } catch (Exception e) {
    		            ((JavascriptExecutor) driver).executeScript("window.location.href = '/test-catalog/tests/new';");
    		        }
    		    }
    	    }
   
    	


    public void setCode(String Code) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(testcode));


        element.clear();
        element.sendKeys(Code);
    }

    public void setTestName(String testName) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(name)
        );

        element.clear();
        element.sendKeys(testName);
    }


    public void setb2cPrice(String b2cpri) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(b2cprice)
        );

        element.clear();
        element.sendKeys(b2cpri);
    }


    public void setb2bPrice(String b2bpri) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(b2bprice)
        );

        element.clear();
        element.sendKeys(b2bpri);
    }


    public void setb2dPrice(String b2dpri) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(b2dPrice)
        );

        element.clear();
        element.sendKeys(b2dpri);
    }


    public void setmrPrice(String mrPri) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(mrPrice)
        );

        element.clear();
        element.sendKeys(mrPri);
    }


    public void setTime(String tm) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(time)
        );

        element.clear();
        element.sendKeys(tm);
    }


    // ==============================
    // Select Time Unit
    // ==============================

    public void selectTimeUnit(String unitName) {

        /*
         * DO NOT USE:
         * timebox.clear();
         *
         * timebox is a button/combobox.
         */

        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(timebox)
        );

        dropdown.click();

        /*
         * After clicking the dropdown,
         * select the required option.
         */
        By option = By.xpath(
                "//*[@role='option' and normalize-space()='" + unitName + "']"
        );

        WebElement selectedOption = wait.until(
                ExpectedConditions.elementToBeClickable(option)
        );

        selectedOption.click();
    }


    // ==============================
    // Reference Range
    // ==============================

    public void setRange(String range) {

        WebElement rangeField = wait.until(
                ExpectedConditions.visibilityOf(rRange)
        );

        rangeField.clear();
        rangeField.sendKeys(range);
    }


    // Measurement Unit

    public void setUnit(String unitValue) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(unit)
        );

        element.clear();
        element.sendKeys(unitValue);
    }


    // Sample Type

    public void setSampletype(String sample) {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(sampleType)
        );

        element.click();
        element.sendKeys(sample);
    }


    // Add Button

    public void clickOnAdd() {

        wait.until(
                ExpectedConditions.elementToBeClickable(add)
        ).click();
    }


    // Add Test Button

    public void clickAddTestButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(AddTest)
        ).click();
    }

}
