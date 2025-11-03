package cognizant.project;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EnterprisePage {
    WebDriver driver;

    @FindBy(xpath = "(//li[@class='css-1dswftd']/a)[2]")
    WebElement enterpriseButton;

    @FindBy(id = "mktoForm_2666")
    WebElement inputForm;

    @FindBy(name = "FirstName")
    WebElement firstNameInput;

    @FindBy(name = "LastName")
    WebElement lastNameInput;

    @FindBy(name = "Email")
    WebElement emailInput;

    @FindBy(name = "Phone")
    WebElement phoneInput;
    
    @FindBy(name = "rentalField9")
    WebElement organisationType;
    
    @FindBy(name = "Title")
    WebElement jobTitle	;
    

    @FindBy(name = "Company")
    WebElement companyInput;

    @FindBy(id = "Employee_Range__c")
    WebElement employeeRange;
    
    
    @FindBy(id="What_the_lead_asked_for_on_the_website__c")
    WebElement describe;

    @FindBy(name = "Country")
    WebElement countryDropdown;
    
    @FindBy(id="State")
    WebElement state;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    @FindBy(id = "ValidMsgEmail")
    WebElement errorMsg;

    public EnterprisePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterPrise() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", enterpriseButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputForm);
    }
    

    public void fillForm(String firstName, String lastName, String email, String phone,String organisationT,
                     String title, String companyName, String companySize,
                     String describes, String country, String states) {

    	firstNameInput.sendKeys(firstName);

        lastNameInput.sendKeys(lastName);

        emailInput.sendKeys(email);

        phoneInput.sendKeys(phone);

        Select companyDropdown = new Select(organisationType);
        companyDropdown.selectByVisibleText(organisationT);

        jobTitle.sendKeys(title);
        
        companyInput.sendKeys(companyName);


        
	    Select employeeRangeSelect = new Select(employeeRange);
	    employeeRangeSelect.selectByVisibleText(companySize);
	    
	    Select industrySelect = new Select(describe);
	    industrySelect.selectByVisibleText(describes);

	
	    Select countrySelect = new Select(countryDropdown);
	    countrySelect.selectByVisibleText(country);
	    
	    Select stateSelect = new Select(state);
	    stateSelect.selectByVisibleText(states);

    }

    public void submitForm() {
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
    	System.out.println("\nThe Entered Mail is Wrong!!!\n-------------------");
    	System.out.println(errorMsg.getText());
    }

}