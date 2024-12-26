package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.commons.compress.harmony.unpack200.bytecode.forms.NarrowClassRefForm;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	
	   public static  Object[][] getDataFromExcel(String filePath, String sheetName) throws IOException {
	        FileInputStream fis=new FileInputStream(filePath);
	        
	        XSSFWorkbook workbook=new XSSFWorkbook(fis);
	        Sheet sheet=workbook.getSheet(sheetName);
	        int rowCount = sheet.getPhysicalNumberOfRows();
	        
	        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

	        Object[][] data = new Object[rowCount - 1][colCount];
	        DataFormatter formatter = new DataFormatter();

	        for (int i = 1;i<rowCount; i++) {
	            Row row = sheet.getRow(i);
	            for (int j = 0; j < colCount; j++) {
	                data[i - 1][j] = formatter.formatCellValue(row.getCell(j));
	            }
	        }

	        workbook.close();
	        fis.close();
	        return data;
	    }
	

			
	public static void waitForElement(WebDriver dr, WebElement element, int timeout) {

		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static boolean isElementVisible(WebElement element) {
		try {
			return element.isDisplayed();

		} catch (Exception e) {
			return false;
		}
	}
	
}
