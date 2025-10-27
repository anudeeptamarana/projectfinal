package cognizant.project;


import org.testng.annotations.*;

public class CourseSearchTest extends DriverSet{
	
    @Test(priority=1)
    public void testSearchWebDevCourses() {
    	homePage.ClickSearchBox();
    	homePage.searchCourse("Web Development for Beginners");
    }
    
    
    @Test(priority=3)
    public void selectForBeginnerLevel() {
    	resultsPage.selectLevel();
    }
    
    
    @Test(priority=2)
    public void selectForLanguage() {
    	resultsPage.selectLanguage();
    	
    }
    
    
    @Test(priority=4)
    public void courseList() {
    	resultsPage.noOfCourses();
    }
    
    

}
