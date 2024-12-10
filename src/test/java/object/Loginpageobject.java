package object;

import java.util.Scanner;

import org.openqa.selenium.Alert;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import configreader.ConfigReader;
//import dev.failsafe.internal.util.Assert;
//import dev.failsafe.internal.util.Assert;
import utility.Utility;

public class Loginpageobject extends Base{
	WebDriver dr;
	
	Scanner sc=new Scanner(System.in);
	
	    @FindBy(xpath = "//section[@class='for-login']//div[@class='page-card-head']") 
	    WebElement logo;

	    @FindBy(xpath = "//input[@id='login_email']") 
	    WebElement usernameField;
	    @FindBy(xpath = "//a[normalize-space()='Have an account? Login']") 
	    WebElement signUpLogin;
	  
	    @FindBy(xpath = "//input[@id='login_password']")
	    WebElement passwordField;

	    @FindBy(xpath = "//button[normalize-space()='Login']") 
	    WebElement loginButton;
	   
	    @FindBy(xpath ="//a[normalize-space()='Forgot Password?']")
	    WebElement forgotp;
	    
	    @FindBy(xpath ="//input[@id='forgot_email']")
	    WebElement forgotemail;
	    
	    @FindBy(xpath ="//button[normalize-space()='Reset Password']")
	    WebElement resetpass;
	    
	    @FindBy(xpath ="(//p[@class='text-center sign-up-message'])[2]")
	    WebElement backtologin;
	    
	    @FindBy(xpath ="//a[normalize-space()='Sign up']")
	    WebElement signup;
	    
	    @FindBy(xpath ="//input[@id='signup_fullname']")
	    WebElement signupname;
	    
	    @FindBy(xpath ="//input[@id='signup_email']")
	    WebElement signupmail;
	    
	    @FindBy(xpath ="//button[normalize-space()='Already Registered']")
	    WebElement alreadyregister;
	    
	    @FindBy( css="div[role='dialog']")
	    WebElement dialogbox;
	    
	    @FindBy( xpath="//button[normalize-space()='Success']")
	    WebElement success;
	    
	    @FindBy( xpath="//button[normalize-space()='Sign up']")
	    WebElement signUp;
	    @FindBy( xpath="//button[normalize-space()='Valid email and name required']")
	    WebElement validmailpassword;
	    
	    @FindBy( xpath="//button[@aria-label='Close']")
	    WebElement forgotDialogBox;
	    
	    @FindBy(xpath="//button[@aria-label='Close'])[1]")
	    WebElement signUpDialogBox;
	    public Loginpageobject(WebDriver dr) {
	        this.dr = dr;
	        PageFactory.initElements(dr, this);
	    }

	    // Actions
	    public boolean isLogoVisible() {
	        // Validate logo visibility
	        return Utility.isElementVisible(logo);
	    }

	    public void enterUsername() {
//	        usernameField.clear();
//	    	usernameField.sendKeys(Keys.CONTROL + "a");
//	    	usernameField.sendKeys(Keys.BACK_SPACE);
	    	String username = ConfigReader.getProperty("username");
	    	System.out.println("Username: " + username);
	        usernameField.sendKeys(username);
	    }

	    public void enterPassword() {
//	        passwordField.clear();	      
	    	String password = ConfigReader.getProperty("password");
	        System.out.println("password: " + password);
	        passwordField.sendKeys(password);
	    }

	    public  Homepageobject clickloginButton() {
	    	
	        loginButton.click();
	        return new Homepageobject();
	    }

public void clicksignup(String name, String mail) {
    
    signup.click();
    
    
    signupname.sendKeys(name);
    signupmail.sendKeys(mail);
    
   
    signUp.click();

 
    if (alreadyregister.isDisplayed() || validmailpassword.isDisplayed()) {
   
        System.out.println("User already registered with this email or invalid password.");

     

        System.out.println("Provide a new name: ");
        name = sc.nextLine(); 

        System.out.println("Provide a new email: ");
        mail = sc.nextLine();

        
        signupname.clear();
        signupmail.clear();
        signupname.sendKeys(name); 
        signupmail.sendKeys(mail); 
        //alreadyregister.click();
        //signUpDialogBox.click();
//       Alert alert=dr.switchTo().alert();
//       String text=alert.getText();
//       System.out.println("Alert message: " + text);
//       alert.accept();
        if (alreadyregister.isDisplayed() || validmailpassword.isDisplayed()) {
            System.out.println("Sign-up failed even after trying a new name/email.");
        } else {
            System.out.println("Sign-up successful with new details.");
        }
    } else {
       
        System.out.println("Sign-up successful!");
    }

     
 
}


//		public void clickforgotpassword(String forgotMail) {
//	    	forgotp.click();
//	    	forgotemail.sendKeys(forgotMail);
//	    	resetpass.click();
//	    	
//	    }
//	    
public void clickForgotPassword(String forgotMail) {
    forgotp.click(); // Click the "Forgot Password" link
    if (forgotemail.isDisplayed()) { // Check if email input is visible
        forgotemail.sendKeys(forgotMail); // Enter the email
        resetpass.click(); 
        forgotDialogBox.click();
    } else {
        throw new IllegalStateException("Forgot email input field is not visible");
    }
}
        
}
