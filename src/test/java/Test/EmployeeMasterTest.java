package Test;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.Base;
import configreader.ConfigReader;
import object.EmployeeMaster;
import object.Homepageobject;
import object.Hrmspageobject;
import object.Loginpageobject;
import utility.Utility;

public class EmployeeMasterTest extends Base {
	Loginpageobject login;
	Homepageobject home;
	Hrmspageobject hrms;
	EmployeeMaster emp;
	public EmployeeMasterTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		Base.initialization();
		login=new Loginpageobject(dr);
		home=new Homepageobject(dr);
		hrms=new Hrmspageobject(dr);
		emp=new EmployeeMaster(dr);
		home=login.clickloginButton(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		WebDriverWait wait=new WebDriverWait(dr, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs("Home"));
		hrms=home.clickOnHrms();
		//emp=hrms.clickonMasterEmplyee();
	}
	@Test
	
	public void EmployeeTest()throws Exception {
		emp=hrms.clickonMasterEmplyee();
		emp.addemp();
	    dr.close();
	    }
	@DataProvider(name = "campus_location")
	public Object[][] getcampuslocation_data() {
	    String filePath = "C:\\Users\\KIIT\\Desktop\\Credential.xlsx"; // Correct file path
	    String sheetName = "ADD CAMPUS location"; // Ensure this sheet exists

	    // Fetching data using Utility class
	    Object[][] data = null;
	    try {
	        data = Utility.getDataFromExcel(filePath, sheetName); // Ensure this method is correctly implemented
	    } catch (Exception e) {
	        e.printStackTrace(); // Print error if reading fails
	    }

	    return data; // Return Object[][]
	}
	@Test(dataProvider = "campus_location")
	
	public void campus_location_test(String Campus_Location,String Address,String Pincode,String Landmark,String Contact_Person_Email) {
		emp.Campus_Location(Campus_Location, Address, Pincode, Landmark, Contact_Person_Email);
	}
}
