package cognizant.project;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

public class EnterpriseTest extends DriverSet {
	
	
	@Test(priority=1)
	public void clickOnEnterprise() {

		test = extent.createTest("Clicking on the Enterprise Button");

		eppage.enterPrise();
		
		test.pass("Enterprice button clicked Succesfully");

		
	}
	
	@DataProvider(name = "formData")
	public Object[][] getFormData() {
	    return new Object[][] {
	            {"Anudeep", "Tamarana", "invalidemail", "1234567890", "Business",
	            	"QA Engineer","ABC Company", "1-500", "Other","India","Telangana"}
	    };
	}
	

	@Test(priority = 2, dataProvider = "formData")
	public void clickOnEnterprise(String firstName, String lastName, String email, String phone,
	                               String organisationType, String jobTitle, String companyName,
	                               String companySize, String describe, String country, String state) 
	                            		   throws InterruptedException, IOException {
		test = extent.createTest("Form Filling with Wrong Email ID");
		    	
	    eppage.fillForm(firstName, lastName, email, phone, organisationType, jobTitle, companyName, companySize, describe, country, state);
	    eppage.submitForm();

	    

	    String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        test.pass("Form filled with wrong Email ID completed successfully",
            MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("test-output/screenshots/WrongEmailImage.png");
		org.apache.commons.io.FileUtils.copyFile(src, dest);
		


	}
}
