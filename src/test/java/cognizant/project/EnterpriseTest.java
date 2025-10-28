package cognizant.project;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EnterpriseTest extends DriverSet {
	
	
	@Test(priority=1)
	public void clickOnEnterprise() {
		eppage.enterPrise();
		
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
	                            		   throws InterruptedException {
//	    eppage.enterPrise();
//	    Thread.sleep(3000); // Wait for form to load
	
	    eppage.fillForm(firstName, lastName, email, phone, organisationType, jobTitle, companyName, companySize, describe, country, state);
	    eppage.submitForm();

	}
}
