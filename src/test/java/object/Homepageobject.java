package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import utility.Utility;

public class Homepageobject extends Base{
	WebDriver dr;
	  @FindBy(xpath="//a[@class='navbar-brand navbar-home']")
	  public WebElement HomepLogo;
	  
	  @FindBy(xpath="//div[@class='flex fill-width title-area']")
	  public WebElement HomepTitle;
	  
	
	  @FindBy(xpath="//span[normalize-space()='HRMS (Base)']")
	  public WebElement hrms;
	
	  @FindBy(xpath="//div[@class='avatar-frame standard-image']")
	  public WebElement HomepLogout;
	  
	  public Homepageobject(WebDriver dr) {
		  super();
		  this.dr=dr;
		  PageFactory.initElements(dr, this);
		  
	  }
	  
	  
	  public boolean HomeplogoVisible() {
		  
		  return Utility.isElementVisible(HomepLogo);
	  }
      public String getTitle() {
    	  return dr.getTitle();
	  }
      public Hrmspageobject clickOnHrms() {
    	  hrms.click();
    	  return new Hrmspageobject(dr);
      }
	  
}
