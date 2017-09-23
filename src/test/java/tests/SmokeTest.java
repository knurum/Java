package tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pages.HomePage;
import utility.BasePage;
import utility.ScreenshotRule;

public class SmokeTest extends BasePage {
	HomePage home = new HomePage();
	ScreenshotRule ScreenshotRule = new ScreenshotRule();
	private static Logger log = Logger.getLogger(SmokeTest.class.getName());

	@Test
	public void test1() throws InterruptedException {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		log.info("***New Test Started***" + methodName);
		home.searchiPhone();		
		ScreenshotRule.takeScreenshot(methodName);
	}

}
