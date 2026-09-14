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
import org.openqa.selenium.NoSuchElementException;

public class AddPanel {

	WebDriverWait wait;
	WebDriver driver;
	
	public AddPanel(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	    this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));


	}

	// Locators
	
    @FindBy(xpath="//input[@placeholder='e.g. LFT-PANEL']")
   private WebElement panelCode;

    @FindBy(css = "input[name='name']")
   private  WebElement panelName;

	@FindBy(name = "b2cPrice")
	private WebElement pB2cPrice;

	@FindBy(name = "b2bPrice")
	private WebElement pB2bPrice;

	@FindBy(name = "b2dPrice")
	private WebElement pB2dPrice;

	@FindBy(name = "mrpPrice")
	private WebElement pMrpPrice;

	@FindBy(xpath = "//span[text()='Search and select tests...']")
	private WebElement searchTest;

	@FindBy(name = "description")
	private WebElement description;

	@FindBy(xpath = "//button[normalize-space()='Create Panel']")
	private WebElement createPanelButton;

	// Action Methods

	/**
	 * Clicks the 'Test Catalog' menu in the sidebar using JavaScript to trigger React event.
	 */
	public void clickTestCatalog() {
	    By locator = By.xpath(
	        "//button[contains(.,'Test Catalog')] | " +
	        "//span[normalize-space()='Test Catalog']/ancestor::button | " +
	        "//span[normalize-space()='Test Catalog']"
	    );
	    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	/**
	 * Safely navigates to the 'Create Panel' page.
	 * Checks if the link is visible first before toggling the menu, and falls back to direct navigation if necessary.
	 */
	public void clickAddPanel() {
	    By createPanelLocator = By.xpath(
	        "//a[contains(@href, '/test-catalog/panels/new')] | " +
	        "//a[normalize-space()='Create Panel'] | " +
	        "//span[normalize-space()='Create Panel']/ancestor::a"
	    );

	    // Step 1: Check if 'Create Panel' link is already visible in the DOM
	    
	    List<WebElement> elements = driver.findElements(createPanelLocator);
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
	        WebElement createPanelElem = wait.until(ExpectedConditions.visibilityOfElementLocated(createPanelLocator));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", createPanelElem);
	        
	        try {
	            createPanelElem.click();
	        } catch (Exception e) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", createPanelElem);
	        }
	    } catch (TimeoutException te) {
	        // Step 4: Fallback to direct navigation if UI state prevents sub-menu rendering
	        System.out.println("'Create Panel' link not visible in sidebar menu. Navigating directly to /test-catalog/panels/new");
	        try {
	            URI uri = URI.create(driver.getCurrentUrl());
	            String targetUrl = uri.getScheme() + "://" + uri.getAuthority() + "/test-catalog/panels/new";
	            driver.get(targetUrl);
	        } catch (Exception e) {
	            ((JavascriptExecutor) driver).executeScript("window.location.href = '/test-catalog/panels/new';");
	        }
	    }
	}

	public void setPanelCode(String code) {

        WebElement element = wait.until(
            ExpectedConditions.visibilityOf(panelCode)
        );

        element.clear();
        element.sendKeys(code);
    }

    public void setPanelName(String name) {

        WebElement element = wait.until(
            ExpectedConditions.visibilityOf(panelName)
        );

        element.clear();
        element.sendKeys(name);
    }

	public void setPanelB2CPrice(String price) {
	    wait.until(ExpectedConditions.visibilityOf(pB2cPrice));
	    pB2cPrice.clear();
	    pB2cPrice.sendKeys(price);
	}

	public void setPanelB2BPrice(String price) {
	    wait.until(ExpectedConditions.visibilityOf(pB2bPrice));
	    pB2bPrice.clear();
	    pB2bPrice.sendKeys(price);
	}

	public void setPanelB2DPrice(String price) {
	    wait.until(ExpectedConditions.visibilityOf(pB2dPrice));
	    pB2dPrice.clear();
	    pB2dPrice.sendKeys(price);
	}

	public void setPanelMRPPrice(String price) {
	    wait.until(ExpectedConditions.visibilityOf(pMrpPrice));
	    pMrpPrice.clear();
	    pMrpPrice.sendKeys(price);
	}

	public void selectTestOrPanelByIndex(int index) {
	    wait.until(ExpectedConditions.elementToBeClickable(searchTest)).click();
	    List<WebElement> options = wait.until(
	        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@role='option']"))
	    );
	    if (index >= 0 && index < options.size()) {
	        options.get(index).click();
	    }
	}

	public void setDescription(String desc) {

    List<WebElement> descriptions =
            driver.findElements(By.name("description"));

    System.out.println("Description elements found: " + descriptions.size());

    for (int i = 0; i < descriptions.size(); i++) {

        WebElement element = descriptions.get(i);

        System.out.println("Description element " + i);
        System.out.println("Tag: " + element.getTagName());
        System.out.println("Displayed: " + element.isDisplayed());
        System.out.println("Enabled: " + element.isEnabled());

        if (element.isDisplayed() && element.isEnabled()) {

            element.clear();
            element.sendKeys(desc);

            System.out.println("Description entered successfully.");

            return;
        }
    }

    throw new NoSuchElementException(
            "No visible and enabled description field found."
    );
}

	public void clickCreatePanelB() {
	    wait.until(ExpectedConditions.elementToBeClickable(createPanelButton)).click();
	}

}
