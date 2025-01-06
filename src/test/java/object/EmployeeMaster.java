package object;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class EmployeeMaster extends Base{
	WebDriver dr;
	Scanner s=new Scanner(System.in);
	@FindBy(xpath="//span[@data-label='Add%20Employment%20Type']")
	WebElement addemployee;
	@FindBy(xpath="//div[@class='row form-section card-section visible-section']//input[@type='text']")
	WebElement employement_type;
	@FindBy(xpath="//div[@class='modal fade show']//button[contains(@class,'btn btn-secondary btn-sm')][normalize-space()='Edit Full Form']")
	WebElement editfullformbutton;
	@FindBy(xpath="//button[@data-label='Save']")
	WebElement savebutton;
	@FindBy(xpath="//input[@placeholder='ID']")
	WebElement empsearchById;
	@FindBy(xpath="//div[@class='frappe-list']//div[@class='list-row-container']")
	List<WebElement> empfhistory;
	
	
	
	@FindBy(xpath="(//span[@class='link-content ellipsis'][normalize-space()='Campus Location'])[1]")
	public WebElement campus_master_xpath;
	@FindBy(xpath="//span[@data-label='Add%20Campus%20Location']")
	public WebElement add_campus_Location;
	@FindBy(xpath="(//button[normalize-space()='Edit Full Form'])[1]")
	public WebElement edit_Fullform_Button;
	@FindBy(xpath = "//div[@class='modal fade show']//div[@class='modal-dialog']//div[@class='modal-content']//div[@class='modal-body ui-front']//div//input[@type='text']")
	public WebElement campus_location_Field;
	@FindBy(xpath="//div[@class='modal fade show']//button[@class='btn btn-modal-close btn-link']//*[name()='svg']//*[name()='use' and contains(@class,'close-alt')]")
	
	public WebElement close1;
	
	@FindBy(xpath = "//textarea[@type='text']")
	public WebElement address_field;
	@FindBy(xpath = "//div[@class='link-field ui-front']//input[@role='combobox']")
	public WebElement ContactpersonEmail_field;
	@FindBy(xpath = "//input[@type='text'])[12]")
	public WebElement ContactpersonName_field;
	@FindBy(xpath = "(//input[@data-fieldtype='Int'])[1]")
	public WebElement Pincode_field;
	@FindBy(xpath = "//div[@data-fieldname='landmark']//input[@type='text']")
	public WebElement Landmark_field;
	@FindBy(xpath = "//div[@id='page-Branch']//button[@data-label='Save']")
	public WebElement Save_field;
	
	
	public EmployeeMaster(WebDriver dr) {
		this.dr=dr;
		PageFactory.initElements(dr,this);
	}
	public void addemp() throws Exception {
		
		addemployee.click();
		editfullformbutton.click();
		System.out.println("input the employeement type");
		String emp=s.nextLine();
		Thread.sleep(5000);
		employement_type.sendKeys(emp);
		dr.switchTo().activeElement().sendKeys(Keys.ESCAPE);
		savebutton.click();
		savebutton.click();
		dr.navigate().back();
		empsearchById.clear();
		empsearchById.sendKeys(emp);
		empsearchById.sendKeys(Keys.ENTER);
		//Thread.sleep(3000);
		List<String>historytext=new ArrayList<>();
		for(WebElement element : empfhistory)
		{
			historytext.add(element.getText());
		}
		
			if(historytext.contains(emp))
			{
				System.out.println("input data is showing in history of employeement type");	
				}
				else
				{
					System.out.println("input data is not showing in history of employeement type");	
				}
			}
	

		
//		String data=empformvalue.getText();
//		Thread.sleep(5);	
//		System.out.println(data);
//		if(emp.equalsIgnoreCase(data)) {
//			System.out.println("input data is showing in history of employeement type");	
//		}
//		else
//		{
//			System.out.println("input data is not showing in history of employeement type");	
//		}
       
		 public void Campus_Location(String Campus_Location,String Address,String Pincode,String Landmark,String Contact_Person_Email) {
			 

			campus_master_xpath.click();
			add_campus_Location.click();
			campus_location_Field.clear();
				
			campus_location_Field.sendKeys(Campus_Location);
			edit_Fullform_Button.click();
			
			
			
			close1.click();
           
			//dr.switchTo().activeElement().sendKeys(Keys.ESCAPE);
			address_field.clear();
			address_field.sendKeys(Address);
			ContactpersonEmail_field.click();
			ContactpersonEmail_field.clear();
			ContactpersonEmail_field.sendKeys(Contact_Person_Email);
			ContactpersonEmail_field.sendKeys(Keys.ENTER);;
		
			Pincode_field.click();
			Pincode_field.clear();
			Pincode_field.sendKeys(Pincode);
			Landmark_field.clear();
			Landmark_field.sendKeys(Landmark);
			
			Save_field.click();
	
		}
}