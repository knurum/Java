package utility;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Library {

	public WebDriver driver;
	private static Logger log = Logger.getLogger(Library.class.getName());

	public Library(WebDriver _driver) {
		driver = _driver;
	}

	public WebDriver openChromeBrowser() {
		try {

			System.setProperty("webdriver.chrome.driver", "C:/workSpaceEclipse/driver/chromedriver.exe");
			DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome();
			handlSSLErr.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new ChromeDriver(handlSSLErr);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			log.error("Oops, error with starting Chrome browser method! ", ex);
			ex.printStackTrace();
		}
		return driver;
	}

	public WebDriver openFirefoxBrowser() {

		try {
			System.setProperty("webdriver.gecko.driver", "C:/workSpaceEclipse/driver/newDriver/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			log.debug("window is maximized!");

		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			log.error("Oops, error with starting firefox browser method! ", ex);
			ex.printStackTrace();
		}
		return driver;
	}

	public WebDriver openIEBrowser() {
		try {
			System.setProperty("webdriver.ie.driver", "C:/workSpaceEclipse/driver/newDriver/IEDriverServer.exe");
			new DesiredCapabilities();
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);

			driver = new InternetExplorerDriver(capabilities);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			log.error("Oops, error with starting IE browser method! ", ex);
			ex.printStackTrace();
		}
		return driver;
	}

	public WebDriver selectBrowser(String browser) {

		String LCBrowser = browser.toLowerCase();
		if (LCBrowser.contains("chrome")) {
			driver = openChromeBrowser();
			browser = "Chrome";

		} else if (LCBrowser.contains("fire")) {
			driver = openFirefoxBrowser();
			browser = "Firefox";

		} else {
			driver = openIEBrowser();
			browser = "IE";
		}
		log.info("All Test Started with browser " + browser);
		return driver;

	}
}
