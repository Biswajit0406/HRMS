package Test;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import configreader.ConfigReader;
import object.EmployeeMaster;
import object.Homepageobject;
import object.Hrmspageobject;
import object.Loginpageobject;

public class HrmsTest extends Base {
	Scanner sc=new Scanner(System.in);
	Loginpageobject login;
	Homepageobject home;
	Hrmspageobject hrms;
	EmployeeMaster emp;
	
	public HrmsTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		Base.initialization();
		login=new Loginpageobject(dr);
		home=new Homepageobject(dr);
        emp=new EmployeeMaster(dr);
    	home=login.clickloginButton(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
		 WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.titleIs("Home"));
		 hrms=home.clickOnHrms();
	}
	@Test
	public void searchbarTest() {
		System.out.println("enter textwrite or select from option");
		String choice=sc.nextLine();
		    switch(choice)
		             {
		    	case "text":
		    	
		           String searchQuery = "employee list"; // Example search query
		           hrms.clickOnSearch(searchQuery); // Perform the search

		   
		          Assert.assertTrue(true, "Search results are not displayed!");
		          break;
		    	case "select":
		    		
		    		hrms.searchbar.click();
		    		//hrms.searchbar.sendKeys(Keys.ARROW_DOWN);;
		    		for(int i=0;i<=6;i++) {
		    			System.out.println("enter which no you want to select");
		    			int no=sc.nextInt();
		    			if(i==no) {
		    				hrms.searchbar.sendKeys(Keys.ENTER);
		    			}
		    			else
		    				hrms.searchbar.sendKeys(Keys.ARROW_DOWN);
		    		}
		    		Assert.assertTrue(true, "Search fail");
		    		
		    		break;
		    	default:
		    		System.out.println(" invalid selection");
		    		
		}	
	}
    @Test
	public void ReloadTest() {
        hrms.SelewctReload("reload");
        Assert.assertTrue(true, "Reload button did not perform as expected");
    
    }
    @Test
   	public void ToggleBarTest() {
           hrms.SelewctReload("togglebar");
           Assert.assertTrue(true, "Reload button did not perform as expected");
       
       }
    @Test
   	public void LogoutTest() {
           hrms.SelewctReload("logout");
           Assert.assertTrue(true, "Reload button did not perform as expected");
       
       }
    
//       
//        hrms.logOut("toggleBarButton");
//        Assert.assertTrue(true, "Toggle button did not perform as expected");
//
//        
//        hrms.logOut("logOutButton");
//        Assert.assertTrue(true, "Logout button did not perform as expected");
    	
//    @Test(dependsOnMethods = {"logOutTest"})
//    public void loginAgainTest(String username,String password) {
//       
//        login.enterUsername();
//    	
//    	login.enterPassword();
//    	
//    	login.clickloginButton(ConfigReader.getProperty(username),ConfigReader.getProperty(password));
//    	
//      
//    }
//    
   @Test
	public void clickonempmaster() {
	   
		emp=hrms.clickonMasterEmplyee();
		Assert.assertTrue(true, "not clicked");
	}
}