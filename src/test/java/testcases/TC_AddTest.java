package testcases;

import pageobject.AddTest;
import org.testng.annotations.Test;


public class TC_AddTest extends BaseClass {

    @Test
	public void TC_addTest() throws InterruptedException {
		
		  AddTest add = new AddTest(driver);
		  
		  Thread.sleep(1000);
	        add.clickTestCatalog();
			  Thread.sleep(1000);

	        add.clickAddTestB();
			  Thread.sleep(1000);

	        add.setCode(cod);
			  Thread.sleep(1000);

	        add.setTestName(testn);
			  Thread.sleep(1000);

	        add.setb2cPrice(b2cPri);
			  Thread.sleep(1000);

	        add.setb2bPrice(b2bPri);
			  Thread.sleep(1000);

	        add.setb2dPrice(b2dPri);
			  Thread.sleep(1000);

	        add.setmrPrice(mrPrice);
			  Thread.sleep(1000);

	        add.setTime(time);
			  Thread.sleep(1000);

	        add.selectTimeUnit("Minutes");
			  Thread.sleep(1000);

	        add.setRange(rRange);
			  Thread.sleep(1000);

	        add.setUnit(unit);

	       // add.setDescription(descrip);

	        add.setSampletype(sampleType);
			  Thread.sleep(1000);

	        add.clickOnAdd();

	        add.clickAddTestButton();
	    }
		

}
