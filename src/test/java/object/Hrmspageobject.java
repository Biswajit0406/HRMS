package object;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class Hrmspageobject extends Base{
	WebDriver dr;
	
	@FindBy(xpath="//input[@id='navbar-search']")
	public WebElement searchbar;
	
	@FindBy(xpath="//span[@class='link-content ellipsis'][normalize-space()='Employment Type']")
	public WebElement emptype;
	
	@FindBy(xpath="//div[@class='avatar-frame standard-image']")
	public WebElement logoutoption;
	
	@FindBy(xpath="//a[normalize-space()='Reload']")
	public WebElement reload;
	
	@FindBy(xpath="//a[normalize-space()='Toggle Theme']")
	public WebElement toggleBar;
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	public WebElement logOut;
	
	@FindBy(xpath="//div[@id='toolbar-user']")
	List< WebElement> logOutButtonDropdown;
	

	
    public Hrmspageobject(WebDriver dr)
       {
      super();
	  this.dr=dr;
	  PageFactory.initElements(dr, this);
        }
    public void clickOnSearch(String query) {
    	searchbar.clear();
    	searchbar.sendKeys(query);
    	searchbar.sendKeys(Keys.ENTER);
    }
    public void SelewctReload(String  optionText) {
     logoutoption.click();
     toggleBar.click();
     
     }
    public void SelewctToggleBar(String  optionText) {
        logoutoption.click();
        toggleBar.click();
    }
    public void SelewctLogOut(String  optionText) {
        logoutoption.click();
        logOut.click();
    }
    
    public EmployeeMaster clickonMasterEmplyee() {
//    	WebDriverWait wait=new WebDriverWait(dr,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(emptype));
    	 emptype.click();
    	 return new EmployeeMaster(dr) ;
    }
}
