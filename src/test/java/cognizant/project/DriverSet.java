package cognizant.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import reports.ExtentReportManager;


public class DriverSet {

		protected static WebDriver driver;
	    protected static HomePage homePage;
	    protected static SearchResultsPage resultsPage;
	    protected static LangLearningPage langPage;
	    protected static EnterprisePage eppage;
	    protected static ExtentReports extent;
	    protected ExtentTest test;

	       @BeforeSuite
	       public void setupExtentReport() {
	           extent = ExtentReportManager.createReport();
	       }

	       @AfterSuite
	       public void flushExtentReport() {
	           extent.flush();
	       }

   
	    @BeforeTest
	    public void setup() throws FileNotFoundException {
	    	Properties prop = new Properties();
	    	FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
	    	try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	
	    	
	    	String browser = prop.getProperty("browser");
	    	String url = prop.getProperty("url");

	    	if (browser.equalsIgnoreCase("chrome")) {
	    	   // WebDriverManager.chromedriver().setup();
	    	    driver = new ChromeDriver();
	    	} else if (browser.equalsIgnoreCase("edge")) {
	    	   //WebDriverManager.edgedriver().setup();

	    	    driver = new EdgeDriver();
	    	}
	    	
	    	driver.get(url);
	    	
	        homePage = new HomePage(driver);
	        resultsPage=new SearchResultsPage(driver);
	        langPage=new LangLearningPage(driver);
	        eppage=new EnterprisePage(driver);
	        
	    	driver.manage().window().maximize();
	    	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	    }
	    
	    
	    
	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }
	    

}