package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	public static void screenshot(WebDriver driver , String testID) throws IOException {
		for(int i = 1;i<2;i++)
		{
		
			Date d = new Date();

			String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
			
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest = new File("E:\\screenshot\\Test"+ testID+FileName);
		FileHandler.copy(source, dest);
	}
}
	
	public static String getDataFromExcel(String sheet, int row, int cell) throws  IOException {
		String path = ("C:\\Users\\om\\Desktop\\Testing.xlsx")	;
		FileInputStream file = new FileInputStream(path);
		String data="";
		try
		{
		data=WorkbookFactory.create(file).getSheet("atul").getRow(row).getCell(cell).getStringCellValue();
		}
		catch(IllegalStateException e)
		{
			double value=WorkbookFactory.create(file).getSheet("atul").getRow(row).getCell(cell).getNumericCellValue();
			data=String.valueOf(value);
		}
		return data;
	}
}
