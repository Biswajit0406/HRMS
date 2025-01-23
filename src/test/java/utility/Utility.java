package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;

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
	            if (row == null) {
	                continue; 
	            }
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
//	  public static String captureScreenshot(WebDriver driver, String screenshotName) {
//	        String destinationPath = System.getProperty("user.dir") + "ScreenShot/HRMSscreenshots/" + screenshotName + ".png";
//	        try {
//	            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//	            FileUtils.copyFile(source, new File(destinationPath));
//	        } catch (IOException e) {
//	            System.out.println("Error capturing screenshot: " + e.getMessage());
//	        }
//	        return destinationPath;
//	    }
//	}
	public static String captureScreenshot(WebDriver dr, String screenshotName) {
	    // Define the directory for saving screenshots
	    String screenshotDir = System.getProperty("user.dir") + "/ScreenShot/HRMSscreenshots/";
	    String destinationPath = screenshotDir + screenshotName + ".png";

	    try {
	        // Create the directory if it doesn't exist
	        File dir = new File(screenshotDir);
	        if (!dir.exists()) {
	            dir.mkdirs(); // Create all necessary directories
	        }

	        // Capture the screenshot
	        File source = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);

	        // Save the screenshot in the desired location
	        FileUtils.copyFile(source, new File(destinationPath));
	    } catch (IOException e) {
	        System.out.println("Error capturing screenshot: " + e.getMessage());
	    }
	    return destinationPath;
	}
}

