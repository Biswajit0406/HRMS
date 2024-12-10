package Test;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import base.Base;
import object.Loginpageobject;
import utility.Utility;

public class LoginpageTest extends Base {
	Loginpageobject login;
	String username="";
	String password="";
	//WebDriver driver;
//	Scanner sc=new Scanner(System.in);

	@BeforeMethod
    public void setUp() {
        // Initialize WebDriver (e.g., ChromeDriver)
//        driver = new ChromeDriver();
//        driver.get("https://wscdemo.eduleadonline.com");
		Base.initialization();
        // Initialize Loginpageobject with WebDriver
        login = new Loginpageobject(dr);
    }
    @Test
	public void logoTest() {
		Assert.assertTrue(login.isLogoVisible(), "logo not visible");
		login.tearDownBrowser();
    }
//    @Test()
//	public void usernameTest(String username) {
//		login.enterUsername(username);
//		Assert.assertTrue(true);
//	}
//    @Test()
//	public void passwordTest(String pass) {
//		login.enterPassword(pass);
//		Assert.assertTrue(true);
//	}
    @Test
	public void loginTest() throws InterruptedException {
    	login.enterUsername();
    	Thread.sleep(2000);
    	login.enterPassword();
    	
    	login.clickloginButton();
    	Thread.sleep(20);
    	login.tearDownBrowser();
    	//WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.urlContains("https://wscdemo.eduleadonline.com/app"))
     	//String expectedUrl = "https://wscdemo.eduleadonline.com/app"; 
//        
    	//Assert.assertEquals(dr.getCurrentUrl(), expectedUrl, "Login failed! User is not navigated to the homepage.");
    	//login.tearDownBrowser();
    	}
    @Test
   	public void SignUpTest() {
//    	System.out.println("Provide your SignUp name");
    	String name="x yz";
//    	System.out.println("Provide your SignUp mail");
    	String mail="xyz100@gmail.com";
   		login.clicksignup(name,mail);
   		//Assert.assertTrue(true); 
   		login.tearDownBrowser();
   	}
    //@Test
////    public void forgotPasswordTest(){
////   	System.out.println("Provide your mail to recover yoour account");
////    	String forgotMail="xy100@gmail.com";
////    	login.clickforgotpassword(forgotMail);
////   		Assert.assertTrue(true, "forgot password not working");
////	}
//   
	
    @Test
    public void forgotPasswordTest() {
        System.out.println("Provide your email to recover your account");

        // Test Data
        String forgotMail = "xy100@gmail.com";

        // Action
        login.clickForgotPassword(forgotMail);
        login.tearDownBrowser();

        // Verification: Replace with actual success condition
//        boolean isPasswordResetSuccessMessageDisplayed = forgotDialobBox.isDisplayed(); 
//        Assert.assertTrue(isPasswordResetSuccessMessageDisplayed, "Forgot password functionality is not working as expected");
    }
	
}
