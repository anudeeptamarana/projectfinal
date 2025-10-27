package cognizant.project;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(id = "search-autocomplete-input")
    WebElement searchBox;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    public void ClickSearchBox() {
    	searchBox.click();
    }

    public void searchCourse(String keyword) {
        searchBox.sendKeys(keyword,Keys.ENTER);
    }
}
