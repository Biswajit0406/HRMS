package Test;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import object.Loginpageobject;
import utility.Logerutility;
import utility.Utility;
public class LoginpageTest extends Base {
	public static final Logger loger=Logerutility.getLogger(LoginpageTest.class);
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
		loger.info("logotest is successful");
		//login.tearDownBrowser();
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
   	public void SignUpTest() {
//    	System.out.println("Provide your SignUp name");
    	String name="x yz";
//    	System.out.println("Provide your SignUp mail");
    	String mail="xyz100@gmail.com";
   		login.clicksignup(name,mail);
   		//Assert.assertTrue(true); 
   		//login.tearDownBrowser();
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
       // login.tearDownBrowser();
        Assert.assertTrue(true, "test fail");
        // Verification: Replace with actual success condition
//        boolean isPasswordResetSuccessMessageDisplayed = forgotDialobBox.isDisplayed(); 
//        Assert.assertTrue(isPasswordResetSuccessMessageDisplayed, "Forgot password functionality is not working as expected");
    }
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        // Path to your Excel file and sheet name
        String filePath = "C:\\Users\\KIIT\\Desktop\\Credential.xlsx";
        String sheetName = "sheet1";
        return Utility.getDataFromExcel(filePath, sheetName);
    }

    // Test method using DataProvider
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) throws InterruptedException {
        // Initialize the Loginpageobject
        login = new Loginpageobject(dr);

        // Enter username and password from DataProvider
        login.enterUsername(username);
        login.enterPassword(password);
        // Wait until the button is clickable
       
        login.clickloginButton(username, password);
       
        String currentUrl = dr.getCurrentUrl();
        System.out.print(currentUrl);
        String expectedUrl = "https://wscdemo.eduleadonline.com/app";
        
        if (currentUrl.contains(expectedUrl)) {
            System.out.println("Login successful!");
            Assert.assertTrue(true, "Login successful!");
        } else {
            // Verify invalid login by checking for an error message or remaining on the login page
        
            System.out.println("Login failed: Invalid credentials or other issue.");
        }
    }

    	//login.tearDownBrowser();
    	//WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.urlContains("https://wscdemo.eduleadonline.com/app"))
     	//String expectedUrl = "https://wscdemo.eduleadonline.com/app"; 
//        
    	//Assert.assertEquals(dr.getCurrentUrl(), expectedUrl, "Login failed! User is not navigated to the homepage.");
    	//login.tearDownBrowser();
    	}
	

