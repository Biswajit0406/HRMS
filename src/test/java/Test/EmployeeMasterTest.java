package Test;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
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
	private static final Logger logger = LogManager.getLogger(EmployeeMasterTest.class);
	public EmployeeMasterTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		Base.initialization();
		login = new Loginpageobject(dr);
		home = new Homepageobject(dr);
		hrms = new Hrmspageobject(dr);
		emp = new EmployeeMaster(dr);
		home = login.clickloginButton(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs("Home"));
		hrms = home.clickOnHrms();
		// emp=hrms.clickonMasterEmplyee();
	}

	@Test
   // @Listeners(listeners.ExtentReportListener.class) //for run single test Listener anotation+package name+class name
	public void EmployeeTest() throws Exception {
		emp = hrms.clickonMasterEmplyee();
		emp.addemp();
		dr.close();
		logger.info("login test completed successfully");
	}

	@DataProvider(name = "campus_location")
	public Object[][] getcampuslocation_data() {
		String filePath = "C:\\Users\\KIIT\\Desktop\\Credential.xlsx"; // Correct file path
		String sheetName = "ADD_CAMPUS_Location"; // Ensure this sheet exists

		// Fetching data using Utility class
		Object[][] data = null;
		try {
			data = Utility.getDataFromExcel(filePath, sheetName); // Ensure this method is correctly implemented
		} catch (Exception e) {
			e.printStackTrace(); // Print error if reading fails
		}

		return data; 
		
	}

	@Test(dataProvider = "campus_location")

	public void campus_location_test(String Campus_Location, String Address, String Pincode, String Landmark,String Contact_Person_Email) {
		emp.Campus_Location(Campus_Location, Address, Pincode, Landmark, Contact_Person_Email);
	}

	@DataProvider(name = "Add_department")
	public Object[][] getdepartment_data() {
	    String filePath = "C:\\Users\\KIIT\\Desktop\\Credential.xlsx"; // Correct file path
	    String sheetName = "Add_Department"; // Ensure this sheet exists

	    // Fetching data using Utility class
	    Object[][] data = null;
	    try {
	        data = Utility.getDataFromExcel(filePath, sheetName); // Ensure this method is correctly implemented
	    } catch (Exception e) {
	        e.printStackTrace(); // Print error if reading fails
	    }

	    return data; // Return Object[][]
	}

	@Test(dataProvider = "Add_department")
	public void departmentTest(String department,String alias,String parent_department_choice,String pay_roll_costcenter,String depart_head,String leave_block_value,String shift_approver_value) {
		
		emp.DepartmentMaster( department, alias,parent_department_choice,pay_roll_costcenter,depart_head,leave_block_value,shift_approver_value);
	}

}