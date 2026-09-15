package testcases;
import org.testng.annotations.Test;

import pageobject.AddPatient;

public class TC_AddPatient extends BaseClass {
@Test 
    public void TC_addPatient() throws InterruptedException{

        AddPatient p = new  AddPatient(driver);
        p.clickPatients();
        Thread.sleep(1000);
        p.clickAddPatient();
            Thread.sleep(1000);
        p.setPatientFName(Fname);
            Thread.sleep(1000);
        p.setPatientLName(Lname);
            Thread.sleep(1000);
        p.setPatientAge(age);
            Thread.sleep(1000);
        p.setGender(2);
            Thread.sleep(1000);
        p.setPhone(Phone);
            Thread.sleep(1000);
        p.setEmail(PEmail);
            Thread.sleep(1000);
        p.setAddress(addres);

        

    }



}
