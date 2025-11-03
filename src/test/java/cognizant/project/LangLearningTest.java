package cognizant.project;

import org.testng.annotations.Test;

import util.RetryAnalyzer;

public class LangLearningTest extends DriverSet{

	

    @Test(priority=0,retryAnalyzer = RetryAnalyzer.class)
	public void langLearning() {
		test = extent.createTest("Clicking on the Language Learning Button");

		langPage.langLearn();
		
		test.pass("Language learning button clicked Successfully");

	}
	
	
	@Test(priority=1,retryAnalyzer = RetryAnalyzer.class)
	public void languagesAvailable() {
		
		test = extent.createTest("Choosing the Languages Available");

		langPage.getLanguages();
		langPage.getLevels();
		
		test.pass("Languages are fetched Successfully");

	}

}
