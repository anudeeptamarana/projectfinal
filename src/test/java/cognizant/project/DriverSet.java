package cognizant.project;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSet {

	protected static WebDriver driver;
    protected static HomePage homePage;
    protected static SearchResultsPage resultsPage;
    protected static LangLearningPage langPage;
    protected static EnterprisePage eppage;

	    @BeforeSuite
	    public void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://www.coursera.org");
	        homePage = new HomePage(driver);
	        resultsPage=new SearchResultsPage(driver);
	        langPage=new LangLearningPage(driver);
	        eppage=new EnterprisePage(driver);
	        
	    	driver.manage().window().maximize();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	    }
	    
	   // @AfterClass
//	    public void tearDown() {
//	        driver.quit();
//	    }

}
