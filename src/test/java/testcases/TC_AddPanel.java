package testcases;

import pageobject.AddPanel;
import org.testng.annotations.Test;

public class TC_AddPanel extends BaseClass{

    
	@Test
	public void addPanel() throws InterruptedException {
		
		AddPanel ad = new AddPanel(driver);
		Thread.sleep(1000);;
		ad.clickTestCatalog();
		Thread.sleep(1000);
		ad.clickAddPanel();
		Thread.sleep(1000);
		ad.setPanelCode(PCode);
		Thread.sleep(1000);
		ad.setPanelName(PName);
		Thread.sleep(1000);
		ad.setPanelB2CPrice(Pb2cPri);
		Thread.sleep(1000);
		ad.setPanelB2BPrice(Pb2bPri);
		Thread.sleep(1000);
		ad.setPanelB2DPrice(Pb2dPri);
		Thread.sleep(1000);
		ad.setPanelMRPPrice(PMrPri);
		Thread.sleep(1000);
	    ad.selectTestOrPanelByIndex(2);
	    Thread.sleep(1000);
		ad.setDescription(decrip);
		ad.clickCreatePanelB();
		
}
}