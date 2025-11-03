package cognizant.project;


import org.testng.annotations.*;

public class CourseSearchTest extends DriverSet{
	


    @Test(priority=1)
    public void testSearchWebDevCourses() {
    	test = extent.createTest("Search Web Dev Course");
    	
       	homePage.ClickSearchBox();
    	homePage.searchCourse("Web Development for Beginners");
	        // Your Selenium steps here
    	test.pass("Searching completed successfully");

    }
    
    
    @Test(priority=3)
    public void selectForBeginnerLevel() {
    	test = extent.createTest("Selecting Level");
    	resultsPage.selectLevel();
    	test.pass("Selecting Level completed successfully");


    }
    
    
    @Test(priority=2)
    public void selectForLanguage() {
    	test = extent.createTest("Selecting Language");
    	resultsPage.selectLanguage();

    	test.pass("Selecting Language completed successfully");

    	
    }
    
    
    @Test(priority=4)
    public void courseList() {
    	test = extent.createTest("Selecting No of Courses");
    	resultsPage.noOfCourses();
    	test.pass("Selecting No of courses completed successfully");

    }
    
    

}
