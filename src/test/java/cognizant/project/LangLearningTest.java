package cognizant.project;

import org.testng.annotations.Test;

import util.RetryAnalyzer;

public class LangLearningTest extends DriverSet{

	

    @Test(priority=0,retryAnalyzer = RetryAnalyzer.class)
	public void langLearning() {
		langPage.langLearn();
	}
	
	
	@Test(priority=1,retryAnalyzer = RetryAnalyzer.class)
	public void languagesAvailable() {
		langPage.getLanguages();
		langPage.getLevels();
	}

}
