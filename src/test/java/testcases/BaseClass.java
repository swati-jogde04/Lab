package testcases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import java.time.Duration;
import utilities.ConfigReader;
import org.testng.annotations.Test;
import pageobject.LoginPage;
import org.testng.Assert;

public class BaseClass {

    
    ConfigReader config = new ConfigReader();

    //Login
    String Url = config.getApplicationUrl();
    String email = config.getEmail();
    String password = config.getPassword();

    //AddTest
      String cod = config.getCode();
    String testn = config.getName();
    String b2cPri =config.getb2cPrice();
    String b2bPri = config.getb2bPrice();
    String b2dPri = config.getb2dPrice();
    String mrPrice = config.getMrPrice();
    String time = config.gettrunaroundTime();
    String rRange = config.getrefRange();
    String unit = config.getunit();
   //String Des = config.getTestdescription();
    String sampleType = config.getSampleType();

    //AddPanel
   String PCode =config.getPanelCode();
   String PName =config.getPanelName();
   String Pb2cPri =config.getb2cPrice();
   String Pb2bPri =config.getb2bPrice();
   String Pb2dPri =config.getb2dPrice();
   String PMrPri =config.getPanelMrpPr();
   String decrip = config.getPanelDescrip();

    
    
    public static WebDriver driver;
    WebDriverWait  wait;

    @BeforeClass
    public void setUp() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(Url);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {

        Thread.sleep(5000);

        if (driver != null) {
            driver.quit();
        }
    }
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
