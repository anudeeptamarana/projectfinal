package cognizant.project;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
    WebDriver driver;

    //Locators
    //"//span[text()='Beginner']"
    
    @FindBy(xpath = "//div[text()='Level']")
    WebElement level;
    
    @FindBy(xpath = "//span[text()='Beginner']")
    WebElement beginnerOption;
    
  
    @FindBy(xpath = "//span[text()='View']")
    WebElement view;
    
    
    
    @FindBy(xpath = "//div[text()='Language']")
    WebElement language;
    
    @FindBy(xpath = "//span[text()='English']")
    WebElement englishOption;
    
 
	
	@FindBy(xpath = "//h3[contains(@class,'cds-CommonCard-title')]")
	List<WebElement> courseName;

	@FindBy(xpath = "//div[contains(text(),'Rating,')]")
	List<WebElement> ratings;
	
	@FindBy(xpath = "//p[contains(text(),'Beginner') and @class='css-vac8rf']")
	List<WebElement> beginnerElements;

	
    //Actions performed
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void selectLevel() {
    	//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", level);
        level.click();
    	beginnerOption.click();
    	//view.click();
    	
    }
    
    public void selectLanguage() {
    	
    	//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", language);
        language.click();
    	englishOption.click();
    	//view.click();
    	
    }
    

	public void noOfCourses() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfAllElements(courseName));
		System.out.println("Total Courses found: " + courseName.size());
		System.out.println("The top three listed courses:\n--------------------------------");
		
		for (int i = 0; i < Math.min(3, courseName.size()); i++) {
				
		        System.out.println(courseName.get(i).getText());
		        System.out.println(ratings.get(i).getText());
		        System.out.println(beginnerElements.get(i).getText());
		        System.out.println("---------------------------------");
		}
	}


}
