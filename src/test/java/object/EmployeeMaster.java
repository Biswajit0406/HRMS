package object;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.invokers.AbstractParallelWorker.Arguments;

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
	
	
	@FindBy(xpath="//a[@title='Department']")
	WebElement Deparment_master;
	@FindBy(xpath="//div[@id='page-List/Department/List']//button[@class='btn btn-primary btn-sm primary-action']")
	WebElement Add_Deparment;
	@FindBy(xpath="//div[@data-fieldname='department_name']//input[@type='text']")
	WebElement deparmentform;
	
	@FindBy(xpath="//div[@data-fieldname='parent_department']//input[@role='combobox']")
	WebElement Parent_Deparment;
	@FindBy(xpath="//div[@data-fieldname='department_alias']//input[@type='text']")
	WebElement Deparment_alias;
	@FindBy(xpath="//ul[@id='awesomplete_list_5']")
	List<WebElement>p_department;
	@FindBy(xpath="//div[@data-fieldname='payroll_cost_center']//input[@role='combobox']")
	WebElement payroll_costcenter;
	@FindBy(xpath="//*[@id=\"awesomplete_list_5\"]")
	List<WebElement> payrollcostcenter_list;
	@FindBy(xpath="//div[@data-fieldname='department_head_name']//input[@role='combobox']")
	WebElement department_head;
	
	@FindBy(xpath="//ul[@id='awesomplete_list_6']")
	List<WebElement>department_list;
	@FindBy(xpath="//div[@data-fieldname='leave_block_list']//input[@role='combobox']")
	WebElement Leave_block;
	@FindBy(xpath="//*[@id=\"awesomplete_list_7\"]")
	List<WebElement>leave_block_list;
	
	@FindBy(xpath="//div[@data-fieldname='shift_request_approver']//button[@class='btn btn-xs btn-secondary grid-add-row'][normalize-space()='Add Row']")
	WebElement Add_Row_Shift_Approver;
	@FindBy(xpath="//div[@data-fieldname='shift_request_approver']//div[@class='btn-open-row']")
	WebElement Add_Row_Shift_Approver1_view;
	@FindBy(xpath="//input[@data-target='User']")
	WebElement Add_Row_Shift_Approver1_field;
	
	@FindBy(xpath="//*[@id=\"awesomplete_list_77\"]")
	List<WebElement>shift_approver_list;
	
	@FindBy(xpath = "//button[contains(@class,'btn btn-secondary btn-sm pull-right grid-collapse-row')]//*[name()='svg']")
	WebElement shift_approver_save;
	
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
		 public void DepartmentMaster(String department1,String alias,String parent_department_choice,String pay_roll_costcenter,String depart_head,String leave_block_value,String shift_approver_value)
		 {
			 WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));

			    // Click on Department Master
			    wait.until(ExpectedConditions.elementToBeClickable(Deparment_master)).click();

			    // Click and interact with Add Department
			    wait.until(ExpectedConditions.elementToBeClickable(Add_Deparment)).click();
			    deparmentform.sendKeys(department1);

			    // Enter Department Alias
			    Deparment_alias.click();
			    Deparment_alias.sendKeys(alias);

			    // Select Parent Department
			    Parent_Deparment.click();
			    Parent_Deparment.sendKeys(parent_department_choice);
                for (WebElement element : p_department) {
			        if (element.getText().equalsIgnoreCase(parent_department_choice)) {
			        	//System.out.println(element.getText());
			        	//element.sendKeys(Keys.TAB);
			        	element.sendKeys(Keys.ENTER);
//			        	JavascriptExecutor js = (JavascriptExecutor) dr;
//			        	js.executeScript("arguments[0].click();", element);
			            
			            
			            break;
			        }
			        
			    }
                payroll_costcenter.click();
                payroll_costcenter.sendKeys(pay_roll_costcenter);
                for(WebElement element:payrollcostcenter_list) {
			    	if(element.getText().equalsIgnoreCase(pay_roll_costcenter)) {
			    		element.sendKeys(Keys.ENTER);

			    		break;
			    	}
			    }
			    department_head.click();
			    department_head.sendKeys(depart_head);
			    for(WebElement element:department_list) {
			    	if(element.getText().equalsIgnoreCase(depart_head)) {
			    		element.sendKeys(Keys.ENTER);
//			    		 Actions actions = new Actions(dr);
//			             actions.moveToElement(element).click().perform();
			    		break;
			    	}
			    }
			    
		       Leave_block.click();
			   Leave_block.sendKeys(leave_block_value);
			   for(WebElement element:leave_block_list) {
			    	if(element.getText().equalsIgnoreCase(leave_block_value)) {
			    		element.sendKeys(Keys.ENTER);

			    		break;
			    	}
			    } 
//			   JavascriptExecutor js = (JavascriptExecutor) dr;
//	           js.executeScript("arguments[0].scrollIntoView();", Add_Row_Shift_Approver);
//	           wait.until(ExpectedConditions.elementToBeClickable(Add_Row_Shift_Approver)).click();
////			   Add_Row_Shift_Approver.click();
//	           Add_Row_Shift_Approver1_view.click();
//	           wait.until(ExpectedConditions.elementToBeClickable(Add_Row_Shift_Approver1_field)).click();
//	           Add_Row_Shift_Approver1_field.sendKeys(shift_approver_value);
//               for(WebElement element:shift_approver_list) {
//            	   System.out.println("elementelement=="+element);
//	               if(element.getText().contains(shift_approver_value)) {
//	            	   System.out.println("shift_approver_value=="+shift_approver_value); 
////	            	 element.click();
////		              element.sendKeys(Keys.ARROW_DOWN);
////		              element.sendKeys(Keys.ENTER);
//	            	   
//	            	   js.executeScript("arguments[0].click();", element);
////
////		              
//		              js.executeScript("arguments[0].scrollIntoView();", shift_approver_save);
//                       shift_approver_save.click();
//		                break;
//	               }
//               }
			   JavascriptExecutor js = (JavascriptExecutor) dr;

			// Scroll to and click on Add_Row_Shift_Approver
			js.executeScript("arguments[0].scrollIntoView();", Add_Row_Shift_Approver);
			wait.until(ExpectedConditions.elementToBeClickable(Add_Row_Shift_Approver)).click();

			// Click on Add_Row_Shift_Approver1_view
			Add_Row_Shift_Approver1_view.click();

			// Wait for and click on Add_Row_Shift_Approver1_field
			wait.until(ExpectedConditions.elementToBeClickable(Add_Row_Shift_Approver1_field)).click();

			// Type the value into Add_Row_Shift_Approver1_field
			Add_Row_Shift_Approver1_field.sendKeys(shift_approver_value);

			// Wait for the dropdown options to be present in the DOM
			List<WebElement> shiftApproverOptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
			    By.xpath("//*[contains(@id, 'awesomplete_list')]//li")
			));

			// Debugging: Print the size of the dropdown list
			System.out.println("Size of shiftApproverOptions: " + shiftApproverOptions.size());

			// Iterate through the list to find and click the desired option
			// Wait for dropdown options to be visible
			// Wait for dropdown options to be visible
			wait.until(ExpectedConditions.visibilityOfAllElements(shiftApproverOptions));

			for (WebElement element : shiftApproverOptions) {
			    // Debugging: Print each dropdown option
			    String dropdownText = element.getText();
			    System.out.println("Dropdown option text: [" + dropdownText + "]");
			    System.out.println("Comparing with: [" + shift_approver_value + "]");

			    // Match if dropdown contains the desired value
			    if (dropdownText.contains(shift_approver_value)) {
			        System.out.println("Selected value: " + shift_approver_value);

			        // Ensure the element is scrolled into view and ready for interaction
			        js.executeScript("arguments[0].scrollIntoView(true);", element);
			        js.executeScript("arguments[0].click();", element);

			        // Click the save button
			        shift_approver_save.click();

			        // Break after selecting the desired option
			        break;
			    }
			}




 }
}