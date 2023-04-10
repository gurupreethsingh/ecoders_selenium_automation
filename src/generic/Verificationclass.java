package generic;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Verificationclass 
{
	public WebDriver driver;
	
	// constructor injection. 
	public Verificationclass(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//create method which verifies the title of the pages. 
	public void verifyallpagetitle(String expectedtitle) throws IOException {
		  LocalDateTime now = LocalDateTime.now();  
	        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
	        String formatDateTime = now.format(format);  
	        String timestamp =  formatDateTime.toString().replace(':', '-');
	        
	        WebDriverWait wait = 	new WebDriverWait(driver, Duration.ofSeconds(10)) ;
	        // explicitwait - WebDriverWait wait = 	new WebDriverWait(driver, 10) 
		 try {
	   
		 // expectedConditions classes methods 
		 wait.until(ExpectedConditions.titleIs(expectedtitle));
		 Reporter.log("Title matched.", true);
		 }
		 catch(Exception ex) {
			 ex.printStackTrace();
		  TakesScreenshot ts = (TakesScreenshot) driver;
		 File romlocation =  ts.getScreenshotAs(OutputType.FILE);
		 File harddisk = new File("C:\\Users\\Administrator\\Desktop\\latest_Eclipse\\all_programs\\ecoders_automation_Selenium\\failed_screenshots\\title_image_"+timestamp+".jpeg");
		 
		 FileUtils.copyFile(romlocation, harddisk);
//		 Files.copy(romlocation, harddisk);
		 Assert.fail();
		 }
	}
}