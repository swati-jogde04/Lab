package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigReader {

     Properties pro;

	String path = "C:\\Users\\WIN\\VS WorkSpace\\lab-automation\\src\\test\\java\\resources\\config.properties";

	public ConfigReader() {

		pro = new Properties();

		try {
			FileInputStream fis = new FileInputStream(path);
			pro.load(fis);
			// fis.close();

		} catch (IOException e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationUrl() {
		String url = pro.getProperty("baseUrl");
		return url;
	}

	public String getEmail() {

		String email = pro.getProperty("email");
		return email;
	}

	public String getPassword() {
		String pass = pro.getProperty("password");
		return pass;
	}
//AddTest
	 public String getCode() {
	        return pro.getProperty("TestCode");
	    }


	    public String getName() {
	        return pro.getProperty("TestName");
	    }


	    public String getb2cPrice() {
	        return pro.getProperty("B2CPrice");
	    }

	    public String getb2bPrice() {
	        return pro.getProperty("B2BPrice");
	    }

	    public String getb2dPrice() {
	        return pro.getProperty("B2DPrice");
	    }

	    public String getMrPrice() {
	        return pro.getProperty("mrPrice");
	    }


	    public String gettrunaroundTime() {
	        return pro.getProperty("TrTime");
	    }


	    public String getrefRange() {
	        return pro.getProperty("refRange");
	    }


	    public String getunit() {
	        return pro.getProperty("unit");
	    }


	   
	     /*public String getTestdescription() {
	        return pro.getProperty("description");
	    }*/


	    public String getSampleType() {
	        return pro.getProperty("SampleType");
	    }
//AddPanel
		 
	    public String getPanelCode() {
	    	return pro.getProperty("PanelCode");
	    }
	    public String getPanelName() {
	    	return pro.getProperty("PanelName");
	    }
	    public String getPanelB2CPr() {
	    	return pro.getProperty("B2CPrice");
	    }
	    public String getPanelB2BPr() {
	    	return pro.getProperty("B2BPrice");
	    }
	    public String getPanelB2DPr() {
	    	return pro.getProperty("B2DPrice");
	    }
	    public String getPanelMrpPr() {
	    	return pro.getProperty("MRPPrice");
	    }

	    public String getPanelDescrip() {
	    	return pro.getProperty("Desc");
	    }

}
