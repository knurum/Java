package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BasePage;
import utility.ScreenshotRule;

public class HomePage extends BasePage {
	ScreenshotRule screenShot = new ScreenshotRule();

	String homeURL = "https://www.amazon.com/";
	@FindBy(xpath = ".//*[@id='nav-search']/form/div[2]/div/input")
	WebElement searchBotton;
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchbox;

	public void searchiPhone() throws InterruptedException {
		driver.get(homeURL);
		PageFactory.initElements(driver, this);
		searchbox.clear();
		searchbox.sendKeys("iphone 7");
		
		searchBotton.click();

		Thread.sleep(4000);
	}

	public void takeScreen() {

	}

}
