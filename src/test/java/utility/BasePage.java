package utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BasePage {
	public static WebDriver driver;
	public static Library lib;
	private static Logger log = Logger.getLogger(BasePage.class.getName());
	PropertyManager prpManager = new PropertyManager("propertyData");
	String browser = prpManager.readProperties("browser");
	

	@BeforeClass
	public void beforeAllTest() {
		lib = new Library(driver);
		driver = lib.selectBrowser(browser);
		driver.manage().deleteAllCookies();
		
	}
	@BeforeTest
	public void afterTest() {
		
	}
	@AfterClass
	public void afterAllTest() {
		log.info("closing browser");
		driver.quit();
		log.info("***All Test Finished***");
		//prpManager.writeProperties("todayDate", "dddd");
	}

}
