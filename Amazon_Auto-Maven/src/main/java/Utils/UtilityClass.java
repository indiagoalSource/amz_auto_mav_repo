package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass {
	
	public static String getExcelData(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream("src/main/resources/Data/testDataForSelenium.xlsx");
		Workbook book = WorkbookFactory.create(file);
		
		try {
			
			return book.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		}
		catch(IllegalStateException e) {
			
			double value = book.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
			String data = String.valueOf(value);
			return data ;
		}
		
	}
	
	public static void cpatureScreenshot(WebDriver driver, String testID) throws IOException {
		
		String date = new SimpleDateFormat("dd-MM-YY-hh-mm-ss-SS").format(Calendar.getInstance().getTime());
		
		File src1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("test-output/FailtestScreenshots/Test-"+testID+"-"+date+".png");
		FileHandler.copy(src1, dest);
		
	}
	
}
