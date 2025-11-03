package cognizant.project;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LangLearningPage {
    WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    
    @FindBy(xpath = "(//span[@class=\"cds-button-label\"])[2]")
    WebElement exploreButton ;
    
    @FindBy(xpath = "//a[text()='Language Learning']")
    WebElement langLearnOption;
    
    @FindBy(xpath="//div[@data-testid='search-filter-group-Level']//div[@class='cds-checkboxAndRadio-labelText']")
    List<WebElement> levels;
    
    
    @FindBy(xpath = "//span[text()='Show 43 more']")
    WebElement showMoreLang;
    
  
    @FindBy(xpath = "//div[contains(@data-testid,'language')]/label/div/span/span")
    List<WebElement> languages;
    
    
    //Actions performed
    public LangLearningPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    public void langLearn() {
    	exploreButton.click();

		wait.until(ExpectedConditions.elementToBeClickable(langLearnOption));
		//langLearnOption.click()

    	langLearnOption.click();
    }
    
    public void getLanguages() {
    	showMoreLang.click();
    	System.out.println("Languages Available in Language Learning portal: "+languages.size());
    	System.out.println("---------------------------------");
        for (WebElement span : languages) {
            System.out.print(span.getText()+", ");
        }
        
        
    	
    }
    
    public void getLevels() {
    	System.out.println("Levels Avaialable: "+levels.size());
    	System.out.println("---------------------------------");
    	for(WebElement level:levels) {
        	System.out.println(level.getText());
        }
    }

}
