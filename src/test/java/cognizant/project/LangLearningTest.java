package cognizant.project;

import org.testng.annotations.Test;



public class LangLearningTest extends DriverSet{

	
	@Test(priority=0)
	public void langLearning() {
		langPage.langLearn();
	}
	
	
	@Test(priority=1)
	public void languagesAvailable() {
		langPage.getLanguages();
		langPage.getLevels();
	}

}
