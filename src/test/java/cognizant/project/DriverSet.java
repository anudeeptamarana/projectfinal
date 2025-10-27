package cognizant.project;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSet {
	 	WebDriver driver;
	    HomePage homePage;
	    SearchResultsPage resultsPage;

	    @BeforeClass
	    public void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://www.coursera.org");
	        homePage = new HomePage(driver);
	        resultsPage=new SearchResultsPage(driver);
	    	driver.manage().window().maximize();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	    }
	    
	   // @AfterClass
//	    public void tearDown() {
//	        driver.quit();
//	    }

}
