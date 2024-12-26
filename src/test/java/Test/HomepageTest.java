package Test;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.ClosingFuture.ValueAndCloserConsumer;

import base.Base;
import configreader.ConfigReader;
import object.Homepageobject;
import object.Hrmspageobject;
import object.Loginpageobject;
import utility.Utility;

public class HomepageTest extends Base {
	Loginpageobject login;
	Homepageobject home;
	Hrmspageobject hrms;
	@BeforeMethod
	public void setUp() {
		Base.initialization();
		login=new Loginpageobject(dr);
		hrms=new Hrmspageobject(dr);
		
		home=login.clickloginButton(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
		 WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.titleIs("Home"));
	
		
	}
	@Test
	public void HomeplogoTest() {
		
		Assert.assertTrue(home.HomeplogoVisible(),"loge test fail");
	}
	@Test
	public void HomepTitle() {	
	
		 String expectedTitle = "Home";
		 
		 String actualTitle=home.getTitle();
	     
		 System.out.println(actualTitle);
		    Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch - test failed");
	}
	@Test
	public void cliconHrmsTest() {
		hrms=home.clickOnHrms();
		Assert.assertTrue(true, "Hrms not clicked");
	}
}
